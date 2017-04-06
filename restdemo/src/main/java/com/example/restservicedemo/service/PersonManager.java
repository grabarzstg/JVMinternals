package com.example.restservicedemo.service;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.example.restservicedemo.domain.Person;

@Path("persons")
public class PersonManager {
	
	private Map<Long, Person> storage = new HashMap<Long, Person>();

	public PersonManager(){
		storage.put(1L, new Person("Bolek", 1967));
		storage.put(2L, new Person("Lolek", 1968));
		storage.put(3L, new Person("Tola", 1969));
	}
	
	@GET
	@Path("/{personId}")
	@Produces("application/json")
	public Person getPerson(@PathParam("personId") Long id){
		Person p = storage.get(id);
		if (p == null) return new Person();
		return p;
	}
	
	@GET
	@Path("/age/{personId}")
	@Produces("text/html")
	public String calculateAge(@PathParam("personId") Long id) throws InterruptedException{
		Thread.sleep(5000);
		return "100";
	}
	
	@GET
	@Path("/test")
	@Produces("text/html")
	public String test(){
		return "REST Service is running";
	}

}
