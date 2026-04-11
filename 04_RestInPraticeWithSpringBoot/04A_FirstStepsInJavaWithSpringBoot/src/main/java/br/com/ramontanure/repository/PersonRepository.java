package br.com.ramontanure.repository;

import br.com.ramontanure.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
