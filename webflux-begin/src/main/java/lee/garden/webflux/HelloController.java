package lee.garden.webflux;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public Mono<HelloWorld> hello() {
        HelloWorld helloWorld = new HelloWorld(1L, "hello");
        return Mono.just(helloWorld);
    }
}
