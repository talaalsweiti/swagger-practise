package com.exalt.tasks.springboot.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint //to registers the class with Spring WS as a Web Service Endpoint
public class PersonEndpoint {
    private static final String NAMESPACE_URI = "http://localhost:8080/";

    private PersonController personController;

    @Autowired
    public PersonEndpoint(PersonController personController){
        this.personController=personController;
    }

    @PayloadRoot(namespace = NAMESPACE_URI,localPart = "person") //defines the handler method according to the namespace and localPart attributes
    @ResponsePayload // indicates that this method returns a value to be mapped to the response payload
    //RequestPayload:  indicates that this method accepts a parameter to be mapped from the incoming request
    public GetPersonResponse getPerson(@RequestPayload GetPersonRequest request) {
        GetPersonResponse response = new GetPersonResponse();
        response.setPerson(personController.getPersonById(request.getId()));
        return response;
    }

}
