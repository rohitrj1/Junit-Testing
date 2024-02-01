package com.countryservice.demo.ControllerTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.countryservice.demo.beans.Country;
import com.countryservice.demo.controller.CountryController;
import com.countryservice.demo.service.CountryService;


@SpringBootTest(classes = {ControllerMackitoTest.class})
public class ControllerMackitoTest {
	
	@Mock
	CountryService countryService;
	
	@InjectMocks
	CountryController countryController;
	
	@Test
	@Order(1)
	public void test_getAllCountry() {
		
		 List<Country> countryList = new ArrayList<>();
	        countryList.add(new Country(1,"Delhi","India"));
	        countryList.add(new Country(2,"Washington","USA"));
	        
	        when(countryService.getAllCountry()).thenReturn(countryList);  // Mocking
	        ResponseEntity<List<Country>> country = countryController.getCountry();
	        
	        assertEquals(HttpStatus.FOUND, country.getStatusCode());
	        assertEquals(2, country.getBody().size());
	}

}
