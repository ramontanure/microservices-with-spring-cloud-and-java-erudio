package br.com.ramontanure.services;

import br.com.ramontanure.model.Person;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public Person findById(String id) {
        logger.info("Finding one Person!");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Ramon");
        person.setLastName("Tanure");
        person.setAddress("Curvelo MG");
        person.setGender("Male");
        return person;
    }

}
