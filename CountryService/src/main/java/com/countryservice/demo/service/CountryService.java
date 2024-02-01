package com.countryservice.demo.service;

import com.countryservice.demo.beans.Country;
import com.countryservice.demo.repository.CountryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepo countryRepo;

    public List<Country> getAllCountry(){
        return countryRepo.findAll();
    }

    public Country saveCountry(Country country){
        return countryRepo.save(country);
    }

    public Country getById(Integer id){
    	List<Country> countries = countryRepo.findAll();
    	Country country = null;
    	for(Country con : countries) {
    		if(con.getId() == id) {
    			country = con;
    		}
    	}
    	return country;
    }


    
    public Country getCountrybyName(String countryName) {
    	List<Country> countries = countryRepo.findAll();
    	Country country = null;
    	for(Country con : countries) {
    		if(con.getCountryName().equalsIgnoreCase(countryName))
    			country = con;
    	}
    	return country;
    }
    
    public Country addCountry(Country country) {
    	return countryRepo.save(country);
    }
    
    public Country updateCountry(Country country) {
    	return countryRepo.save(country);
    }
    
    public void deleteCountry(Country country) {
    	countryRepo.delete(country);
    }


}
