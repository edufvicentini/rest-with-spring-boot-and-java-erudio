package br.com.frota.services;

import java.util.List;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.frota.exceptions.ResourceNotFoundException;
import br.com.frota.model.Person;
import br.com.frota.repositories.personRepository;

@Service
public class PersonServices {

	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	@Autowired
	personRepository repository;
	
	public List<Person> findAll() {
		return repository.findAll() ;
	}
	
	public Person findById(Long id) {
		logger.info("Finding one person!");
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
	}
	
	public Person create(Person person) {
		logger.info("Creating one person!");
		return repository.save(person);
	}
	
	public Person update(Person person) {
		logger.info("Updating one person!");
		Person entity = repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		return repository.save(person);
	}
	
	public void delete(Long id) {
		logger.info("Deleting one person!");
		Person entity =  repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		repository.delete(entity);
	}
	
//	private Person mockPerson(Long i) {
//	logger.info("Finding all people");
//	Person person = new Person();
//	person.setId(i);
//	person.setFirstName("Person name " + i);
//	person.setLastName("Last name " + i);
//	person.setAddress("Some address " + i);
//	person.setGender("Male");
//	return person;
//}

}
