package com.exalt.tasks.springboot.person;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import localhost._8080.Person;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;
//@WebService(name = "Test" ,
//        targetNamespace = "http://localhost:8080")
public interface PersonInterface {

    @RequestMapping(value ="/",method= RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "Return all persons" , response = Person.class)
//    @WebMethod
    List<Person> getAllPersons();

//    @WebMethod
    @RequestMapping(value = "/{id}", method= RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "Get person by his ID" , response = Person.class)
    Person getPersonById(@ApiParam(value = "ID value for the person you want to retrieve" , required = true)
                         @PathVariable Long id);

//    @WebMethod
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "Add person" , response = Person.class)
    Person addPerson(@RequestBody Person person);
}
