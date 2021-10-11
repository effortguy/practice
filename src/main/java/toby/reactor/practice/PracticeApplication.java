package toby.reactor.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Flow;

import static java.util.concurrent.Flow.Subscription;

@SpringBootApplication
public class PracticeApplication {

    @RestController
    public static class Controller {

        @GetMapping("/hello")
        public Flow.Publisher<String> hello(String name) {
            return subscriber -> subscriber.onSubscribe(new Subscription() {
                @Override
                public void request(long n) {
                    subscriber.onNext("Hello " + name);
                    subscriber.onComplete();
                }

                @Override
                public void cancel() {
                }
            });
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(PracticeApplication.class, args);
    }

}
