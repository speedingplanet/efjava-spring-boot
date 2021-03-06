package org.efjava.spring.entity;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long> {
  // This is sort of a DAO

  List<Person> findByLastName(String lastName);
  List<Person> findByLastNameStartingWith(String prefix);
  Person findById(long id);
}
