package com.countryservice.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.countryservice.demo.beans.Country;
import com.countryservice.demo.service.CountryService;

@RestController
public class CountryController {
	
	@Autowired
	CountryService countryService;
	
	@GetMapping("/getCountries")
	public ResponseEntity<List<Country>> getCountry(){
		try {
			List<Country> allCountry = countryService.getAllCountry();
			return new ResponseEntity<>(allCountry,HttpStatus.FOUND);
			
		}catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getCountries/{id}")
	public ResponseEntity<Country> getCountryId(@PathVariable int id){
		try {
			Country byId = countryService.getById(id);
			return new ResponseEntity<Country>(byId ,HttpStatus.FOUND);
		}catch(Exception ex) {
			return new ResponseEntity<Country>(HttpStatus.NOT_FOUND);
		}
	}
}
