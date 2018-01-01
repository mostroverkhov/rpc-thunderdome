package com.github.mostroverkhov.r2.testing;

import com.github.mostroverkhov.r2.ProtobufCodec;
import com.github.mostroverkhov.r2.core.responder.Codecs;
import com.github.mostroverkhov.r2.core.responder.Services;
import com.github.mostroverkhov.r2.java.JavaAcceptorBuilder;
import com.github.mostroverkhov.r2.java.R2Server;
import io.rsocket.RSocketFactory;
import io.rsocket.transport.netty.server.NettyContextCloseable;
import io.rsocket.transport.netty.server.TcpServerTransport;
import org.jetbrains.annotations.NotNull;

public class SimpleServer {
    private static final int port = 8081;

    public static void main(String[] args) {
        new R2Server<NettyContextCloseable>()
                .connectWith(RSocketFactory.receive())
                /*Configure Responder RSocket (acceptor) of server side of Connection.
                  Requester RSocket is not exposed yet*/
                .configureAcceptor(SimpleServer::configureAcceptor)
                .transport(TcpServerTransport.create(port))
                .start()
                .block()
                .onClose()
                .doOnSubscribe(s -> System.out.println("Server started"))
                .block();
    }

    @NotNull
    private static JavaAcceptorBuilder configureAcceptor(JavaAcceptorBuilder builder) {
        return builder
                /*Jackson codec. Also there can be cbor, protobuf etc*/
                .codecs(new Codecs().add(new ProtobufCodec()))
                /*ConnectionContext represents Metadata(key -> value) set by Client (Connection initiator)
                as metadata*/
                .services(ctx -> new Services().add(new SimpleServiceHandler()));
    }
}
