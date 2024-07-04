package br.com.neutron.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.neutron.model.Person;

@Service //Instanciação da classe via Annotation SERVICE.
public class PersonServices {
	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	public List<Person> findAll (String id) {
		List<Person> persons = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		return persons;
		
	}
	private Person mockPerson(int i) {
		// TODO Auto-generated method stub
		return null;
	}
	public Person findById (String id) {
		
		logger.info("Finding one person");
		
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Joao");
		person.setLastName("Azevedo");
		person.setAddress("SP São Paulo");
		person.setGender("Masculino");
		return person;
	}
}
