package com.exalt.tasks.springboot;

import com.exalt.tasks.springboot.person.PersonController;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.ws.Endpoint;



@SpringBootApplication
public class SpringBootRestAppApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringBootRestAppApplication.class, args);

	}

}
