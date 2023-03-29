package br.com.erudio.apigateway.services;

import br.com.erudio.apigateway.exceptions.NotFoundException;
import br.com.erudio.apigateway.models.Person;
import br.com.erudio.apigateway.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {
    @Autowired
    PersonRepository repository;

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());
    public Person findById(long id) {
        logger.info("Finding person");
        Person person = repository.findById(id).orElseThrow(() -> new NotFoundException("Not Found"));
        return person;
    }

    public List<Person> findAll() {
        logger.info("Finding all");
        List<Person> persons = repository.findAll();
        return persons;
    }

    public Person create(Person person) {
        logger.info("Creating");
        Person createdPerson = repository.save(person);
        return createdPerson;
    }

    public Person update(Person person) {
        logger.info("Updating");
        Person personInDatabase = repository.findById(person.getId()).orElseThrow(() -> new NotFoundException("Not Found"));

        personInDatabase.setName(person.getName());
        personInDatabase.setAddress(person.getAddress());
        personInDatabase.setGender(person.getGender());

        Person update = repository.save(personInDatabase);
        return update;
    }

    public void delete(long id) {
        logger.info("Deleting");
        Person person = repository.findById(id).orElseThrow(() -> new NotFoundException("Not Found"));
        repository.delete(person);
    }

}
