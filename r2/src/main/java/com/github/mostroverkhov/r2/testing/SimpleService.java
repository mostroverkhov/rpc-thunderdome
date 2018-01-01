package com.github.mostroverkhov.r2.testing;

import com.github.mostroverkhov.r2.core.contract.RequestResponse;
import com.github.mostroverkhov.r2.core.contract.Service;
import reactor.core.publisher.Mono;

@Service("svc")
public interface SimpleService {

    @RequestResponse("request")
    Mono<SimpleResponse> request(SimpleRequest simpleRequest);
}
