package com.exalt.tasks.springboot.person;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;


@RestController
@RequestMapping("/persons")
public class PersonController implements PersonInterface {


    ConcurrentHashMap<Long,Person> persons= new ConcurrentHashMap<>();

    @Override
    public List<Person> getAllPersons() {
        createPerson();
        return new ArrayList<>(persons.values());
    }

    @Override
    public Person getPersonById( Long id) {
        return persons.get(id);
    }

    @Override
    public Person addPerson(Person person) {
        persons.putIfAbsent(person.getId(), person);
        return person;
    }
    @PostConstruct
    public void createPerson() {
        Person Ahmad = new Person();
        Ahmad.setName("Ahmad");
        Ahmad.setId(1L);
        persons.putIfAbsent(1L,Ahmad);
    }




}
