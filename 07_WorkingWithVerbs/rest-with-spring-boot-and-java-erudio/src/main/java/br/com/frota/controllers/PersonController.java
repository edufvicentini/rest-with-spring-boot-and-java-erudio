package br.com.frota.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.frota.services.PersonServices;

@RestController
public class PersonController {
	
	@Autowired
	private PersonServices service;
	
	@RequestMapping(value = "/{operator}/{pathNumbers}", method = RequestMethod.GET)
	public Double calculate(
			@PathVariable(value = "operator") String operator,
			@PathVariable(value = "pathNumbers") String pathNumbers
		) throws Exception {		


		return 0D;
	
	}
}
