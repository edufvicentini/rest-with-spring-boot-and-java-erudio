package br.com.frota.services;

import java.util.concurrent.atomic.AtomicLong;

import java.util.logging.Logger;

import org.springframework.stereotype.Service;

@Service
public class PersonServices {
	
	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
}
