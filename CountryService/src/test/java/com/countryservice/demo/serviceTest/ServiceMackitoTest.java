package com.countryservice.demo.serviceTest;

import com.countryservice.demo.beans.Country;
import com.countryservice.demo.repository.CountryRepo;
import com.countryservice.demo.service.CountryService;


import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {ServiceMackitoTest.class})
public class ServiceMackitoTest {

    @Mock
    CountryRepo countryRepo;

    @InjectMocks
    CountryService countryService;



    @Test
    @Order(1)
    public void test_getAllCountry(){
        List<Country> countryList  = new ArrayList<>();
        countryList.add(new Country(1,"Delhi","India"));
        countryList.add(new Country(2,"Washington","USA"));

        when(countryRepo.findAll()).thenReturn(countryList); // Mocking
        assertEquals(2,countryService.getAllCountry().size());
    }

    @Test
    @Order(2)
    public void test_getById(){
        List<Country> countryList = new ArrayList<>();
        countryList.add(new Country(1,"Delhi","India"));
        countryList.add(new Country(2,"Washington","USA"));
        int countryId = 1;
        
        when(countryRepo.findAll()).thenReturn(countryList); // Mocking
        assertEquals(countryId, countryService.getById(countryId).getId());
    }
    
    @Test
    @Order(3)
    public void test_getCountryName() {
        List<Country> countryList = new ArrayList<>();
        countryList.add(new Country(1,"Delhi","India"));
        countryList.add(new Country(2,"Washington","USA"));
        
        String countryName = "India";
        
        when(countryRepo.findAll()).thenReturn(countryList);
        assertEquals(countryName, countryService.getCountrybyName(countryName).getCountryName());
    	
    }
    
    @Test
    @Order(4)
    public void test_addCountry() {
    	Country country = new Country(3,"Germany" , "Berlin");
    	
    	when(countryRepo.save(country)).thenReturn(country);
    	assertEquals(country, countryService.saveCountry(country));
    }

    @Test
    @Order(5)
    public void test_updateCountry() {
    	Country country = new Country(3,"Germany" , "Berlin");
    	
    	when(countryRepo.save(country)).thenReturn(country);
    	assertEquals(country, countryService.updateCountry(country));
    }
    
    @Test
    @Order(6)
    public void test_deleteCountry() {
    	Country country = new Country(3,"Germany" , "Berlin");
    	
    	
    	countryService.deleteCountry(country);
    	verify(countryRepo,times(1)).delete(country);
    }


}
