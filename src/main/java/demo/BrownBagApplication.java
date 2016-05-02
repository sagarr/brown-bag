package demo;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.Value;

@SpringBootApplication
@EnableMongoRepositories(considerNestedRepositories = true)
public class BrownBagApplication {

    public static void main(final String[] args) {
        SpringApplication.run(BrownBagApplication.class, args);
    }

    @Controller
    public class BrownBagController {

        final BrownBagRepository repo;

        @Autowired
        public BrownBagController(final BrownBagRepository repo) {
            this.repo = repo;
        }

        @ResponseBody
        @RequestMapping("/api/brownbags")
        public Collection<BrownBag> getAllBrownBags() {
            return repo.findAll();
        }
    }

    @Value
    @Document
    public class BrownBag {

        private String speaker;
        private String topic;

    }

    @Repository
    public interface BrownBagRepository extends MongoRepository<BrownBag, String> {

        Collection<BrownBag> findBySpeaker(String speaker);
    }

    @Bean
    public CommandLineRunner init(final BrownBagRepository repo) {
        return args -> {
            repo.save(new BrownBag("Sandy", "Spring in Action"));
            repo.save(new BrownBag("Milind", "Spring Boot"));
            // repo.findAll().forEach(System.err::println);
            repo.findBySpeaker("Sandy").forEach(System.err::println);
        };
    }
}
