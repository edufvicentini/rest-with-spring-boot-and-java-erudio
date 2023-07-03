package br.com.frota.services;

import java.util.List;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.frota.data.vo.v1.PersonVO;
import br.com.frota.data.vo.v2.PersonVOV2;
import br.com.frota.exceptions.ResourceNotFoundException;
import br.com.frota.mapper.DozerMapper;
import br.com.frota.mapper.custom.PersonMapper;
import br.com.frota.model.Person;
import br.com.frota.repositories.personRepository;

@Service
public class PersonServices {

	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	@Autowired
	personRepository repository;
	
	@Autowired
	PersonMapper mapper;
	
	public List<PersonVO> findAll() {
		return DozerMapper.parseListObjects(repository.findAll(), PersonVO.class) ;
	}
	
	public PersonVO findById(Long id) {
		logger.info("Finding one person!");
		var entity = repository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		return DozerMapper.parseObject(entity, PersonVO.class);
	}
	
	public PersonVO create(PersonVO person) {
		logger.info("Creating one person!");
		
		var entity = DozerMapper.parseObject(person, Person.class);
		var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}
	
	public PersonVOV2 createV2(PersonVOV2 person) {
		logger.info("Creating one person with V2!");
		
		var entity = mapper.convertVoToEntity(person);
		var vo = mapper.convertEntityToVO(repository.save(entity));
		return vo;
	}
	
	public PersonVO update(PersonVO person) {
		logger.info("Updating one person!");
		var entity = repository.findById(person.getId())
					.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
		
		return vo;
	}
	
	public void delete(Long id) {
		logger.info("Deleting one person!");
		var entity =  repository.findById(id)
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
