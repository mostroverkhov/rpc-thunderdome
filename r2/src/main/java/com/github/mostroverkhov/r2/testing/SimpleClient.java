package com.github.mostroverkhov.r2.testing;

import com.github.mostroverkhov.r2.ProtobufCodec;
import com.github.mostroverkhov.r2.core.requester.RequesterFactory;
import com.github.mostroverkhov.r2.java.R2Client;
import io.rsocket.RSocketFactory;
import io.rsocket.transport.netty.client.TcpClientTransport;
import org.HdrHistogram.Histogram;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class SimpleClient {
    private static final int port = 8081;
    private static final int warmupCount = 1_000_000;
    private static final int testCount = 1_000_000;
    private static final int concurrency = 16;

    public static void main(String[] args) {

        SimpleService service =
                clientRequester()
                        .map(factory -> factory.create(SimpleService.class))
                        .block();

        System.out.println("starting warmup...");
        Flux.range(0, warmupCount)
                .flatMap(__ -> {
                    SimpleRequest request = SimpleRequest
                            .newBuilder()
                            .setRequestMessage("hello")
                            .build();

                    return service.request(request);
                }).doOnError(Throwable::printStackTrace)
                .blockLast();
        System.out.println("warmup complete");

        long start = System.nanoTime();
        Histogram histogram = new Histogram(3600000000000L, 3);
        System.out.println("starting test - sending " + testCount);

        Flux.range(0, testCount)
                .flatMap(__ -> {
                    long s = System.nanoTime();

                    SimpleRequest request = SimpleRequest
                            .newBuilder()
                            .setRequestMessage("hello")
                            .build();

                    return service.request(request).doFinally(
                            simpleResponse -> {
                                histogram.recordValue(System.nanoTime() - s);
                            });
                }, concurrency).doOnError(Throwable::printStackTrace)
                .blockLast();
        histogram.outputPercentileDistribution(System.out, 1000.0d);
        double completedMillis = (System.nanoTime() - start) / 1_000_000d;
        double rps = testCount / ((System.nanoTime() - start) / 1_000_000_000d);
        System.out.println("test complete in " + completedMillis + "ms");
        System.out.println("test rps " + rps);
        System.out.println();
    }

    private static Mono<RequesterFactory> clientRequester() {
        return new R2Client()
                .connectWith(RSocketFactory.connect())
                .configureRequester(b -> b.codec(new ProtobufCodec()))
                .transport(TcpClientTransport.create(port))
                .start();
    }
}
