package com.exalt.tasks.springboot.person;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.util.List;

public interface PersonInterface {
    @RequestMapping(value ="/",method= RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "Return all persons" , response = Person.class)
    List<Person> getAllPersons();

    @RequestMapping(value = "/{id}", method= RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "Get person by his ID" , response = Person.class)
    Person getPersonById(@ApiParam(value = "ID value for the person you want to retrieve" , required = true)
                         @PathVariable Long id);

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "Add person" , response = Person.class)
    Person addPerson(@RequestBody Person person);
}
