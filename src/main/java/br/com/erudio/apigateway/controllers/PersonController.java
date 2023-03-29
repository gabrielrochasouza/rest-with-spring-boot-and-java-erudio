package br.com.erudio.apigateway.controllers;

import br.com.erudio.apigateway.models.Person;

import br.com.erudio.apigateway.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    PersonServices services;

    private final AtomicLong counter = new AtomicLong();

    @GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findById (@PathVariable(value = "id") long id) {
        return services.findById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> findAll () {
        return services.findAll();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person create(@RequestBody() Person person) {
        return services.create(person);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person update(@RequestBody() Person person) {
        return services.update(person);
    }

    @DeleteMapping(value = "{id}")
    public void delete(@PathVariable("id") Long id) {

        services.delete(id);
    }

}
