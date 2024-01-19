package com.UnitTestingExample.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UnitTestingExample.entity.Person;
import com.UnitTestingExample.repo.PersonRepo;

import java.util.List;

@Service
public class PersonService {

@Autowired
    private PersonRepo repo;



    public List<Person> getAllPerson() {
        return this.repo.findAll();
    }

    public PersonService(PersonRepo repo) {
        this.repo = repo;
    }
}
