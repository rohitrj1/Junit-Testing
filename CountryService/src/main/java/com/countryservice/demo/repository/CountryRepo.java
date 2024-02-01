package com.countryservice.demo.repository;

import com.countryservice.demo.beans.Country;


import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepo extends JpaRepository<Country,Integer> {
	
	Country getById(int id);
}
