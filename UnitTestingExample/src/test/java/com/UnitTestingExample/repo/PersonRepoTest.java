package com.UnitTestingExample.repo;

import com.UnitTestingExample.entity.Person;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PersonRepoTest {
@Autowired
    private PersonRepo personRepo;
    @Test
    void isPersonExitsById() {
        Person person = new Person(123,"Muklesh","Delhi");
        personRepo.save(person);
        Boolean actualResult = personRepo.isPersonExitsById(1);
        assertThat(actualResult).isTrue();
    }

    @AfterEach
    void tearDown() {
        System.out.println("tearing down");
    }

    @BeforeEach
    void setUp() {
        System.out.println("tearing up");
    }
    
//    @AfterAll
//    public void afterAll() {
//    	System.out.println("all test cases complete");
//    }
  
}