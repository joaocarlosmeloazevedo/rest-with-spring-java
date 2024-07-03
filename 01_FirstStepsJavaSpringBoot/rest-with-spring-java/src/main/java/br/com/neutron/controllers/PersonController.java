package br.com.neutron.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

//import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.neutron.model.Person;
import br.com.neutron.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired //Instanciação da classe via Annotation AUTOWIRED.
	private PersonServices service;
	
	@RequestMapping(value = "/{id}", 
					method=RequestMethod.GET,
					produces = MediaType.APPLICATION_JSON_VALUE)
	public Person findById (@PathVariable(value = "id") String id)throws Exception{
		return service.findById(id);
	}
}
