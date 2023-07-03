package br.com.frota.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.frota.model.Person;

@Repository
public interface personRepository extends JpaRepository<Person, Long>{}
