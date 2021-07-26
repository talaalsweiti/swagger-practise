package com.exalt.tasks.springboot.person;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/*
Create person class
 */
@ApiModel(description = "Details about the person")
public class Person {
    @ApiModelProperty(notes = "The unique id of the person")
    private long id ;

    @ApiModelProperty(notes = "The person's name")
    private String name ;

    public Person(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

