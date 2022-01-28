package org.efjava.spring;

import org.efjava.spring.entity.Person;
import org.efjava.spring.entity.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

  private static final Logger log = LoggerFactory.getLogger(Application.class);

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Bean
  public CommandLineRunner demoJPA(PersonRepository repository) {
    return (args) -> {
      repository.save(new Person("John", "Paxton"));
      repository.save(new Person("Haoyang", "Chen"));
      repository.save(new Person("Harshini", "Kanaparthi"));

      log.info("Verify that these people are in the database");
      log.info("--------------------------------------------");
      for (Person p: repository.findAll()) {
        log.info(p.toString());
      }
    };
  }

}
