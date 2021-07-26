package com.exalt.tasks.springboot.person;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    public void createPerson() {
        persons.putIfAbsent(1L, new Person(1L,"Ahmad"));
        persons.putIfAbsent(2L, new Person(2L,"Mohd"));
        persons.putIfAbsent(3L, new Person(3L,"Sami"));
    }




}
