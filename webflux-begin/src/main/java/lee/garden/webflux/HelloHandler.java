package lee.garden.webflux;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class HelloHandler {

    public Mono<ServerResponse> hello(ServerRequest request) {
        Mono<HelloWorld> helloWorldMono = Mono.just(new HelloWorld(1L, "hello"));
        log.info("Hello WebFlux!");
        return ServerResponse.ok().body(helloWorldMono, HelloWorld.class);
    }
}
