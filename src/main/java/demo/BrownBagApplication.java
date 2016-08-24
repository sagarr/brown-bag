package demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class BrownBagApplication {

    public static void main(final String[] args) {
        SpringApplication.run(BrownBagApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(final BrownBagRepository repo) {
        return args -> {
            repo.save(new BrownBag("Sandy", "Spring in Action"));
            repo.save(new BrownBag("Milind", "Spring Boot"));
            repo.findBySpeaker("Sandy").forEach(System.err::println);
        };
    }
}
