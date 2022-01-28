package org.efjava.spring;

import org.efjava.spring.entity.Person;
import org.efjava.spring.entity.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

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
      repository.save(new Person("Jolene", "Chen"));
      repository.save(new Person("Shaoyang", "Wang"));
      repository.save(new Person("Xiaochen", "Wang"));
      repository.save(new Person("Andreina", "Castillo"));

      log.info("Verify that these people are in the database");
      log.info("--------------------------------------------");
      for (Person p: repository.findAll()) {
        log.info(p.toString());
      }

      log.info("");
      log.info("Verify that findById works");
      log.info("--------------------------------------------");
      Person p1 = repository.findById(3L);
      log.info(p1.toString());

      log.info("");
      log.info("Verify that findByLastName works");
      log.info("--------------------------------------------");
      List<Person> lastNameWang = repository.findByLastNameStartingWith("C");
      for(Person p: lastNameWang) {
        log.info(p.toString());
      }
    };
  }

}
