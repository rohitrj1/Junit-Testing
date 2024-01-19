package com.UnitTestingExample.service;

import com.UnitTestingExample.entity.Person;
import com.UnitTestingExample.repo.PersonRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @Mock
    private PersonRepo personRepo;

    private PersonService personService;

    @BeforeEach
    void setUp() {
        this.personService = new PersonService(this.personRepo);
    }

    @Test
    void getAllPerson() {
       personService.getAllPerson();
        Mockito.verify(personRepo).findAll();
    }


}