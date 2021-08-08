package com.exalt.tasks.springboot.controller;

import com.exalt.tasks.springboot.person.PersonDTO;
import com.exalt.tasks.springboot.person.PersonInterface;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/person")
@Component

public class PersonController implements PersonInterface {

    ConcurrentHashMap<Long, PersonDTO> persons = new ConcurrentHashMap<>();

    @PostConstruct
    public void createPerson( ) {
        PersonDTO person = new PersonDTO();
        person.setName("Ahmad");
        person.setId(1L);
        persons.putIfAbsent(1L, person);
    }

    @Override
    public List<PersonDTO> getAllPersons() {
        createPerson( );

        return  new ArrayList<>(persons.values());
     }

    @Override
    public PersonDTO getPersonById(Long id) {
        return persons.get(id);
    }

    @Override
    public PersonDTO addPerson(PersonDTO person) {
        persons.putIfAbsent(person.getId(), person);
        return person;
    }
}