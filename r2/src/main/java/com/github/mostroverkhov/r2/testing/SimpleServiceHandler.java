package com.github.mostroverkhov.r2.testing;

import reactor.core.publisher.Mono;

public class SimpleServiceHandler implements SimpleService {

    @Override
    public Mono<SimpleResponse> request(SimpleRequest simpleRequest) {

        SimpleResponse response = SimpleResponse.newBuilder()
                .setResponseMessage(simpleRequest.getRequestMessage())
                .build();

        return Mono.just(response);
    }
}
