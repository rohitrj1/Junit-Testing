package com.countryservice.demo.controllermvcTest;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.countryservice.demo.beans.Country;
import com.countryservice.demo.controller.CountryController;
import com.countryservice.demo.service.CountryService;

@ContextConfiguration
@AutoConfigureMockMvc
@ComponentScan(basePackages = "com.countryservice.demo")
@SpringBootTest(classes = {ControllerMvcMockitoTest.class})
public class ControllerMvcMockitoTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@Mock
	CountryService countryService;
	
	@InjectMocks
	CountryController countryController;
	
	@BeforeEach
	public void SetUp() {
		mockMvc  = MockMvcBuilders.standaloneSetup(countryController).build();
	}
	
	@Test
	@Order(1)
	public void test_getAllCountry() throws Exception {
		 List<Country> countryList = new ArrayList<>();
	        countryList.add(new Country(1,"Delhi","India"));
	        countryList.add(new Country(2,"Washington","USA"));
	        
	        when(countryService.getAllCountry()).thenReturn(countryList);
	        this.mockMvc.perform(get("/getCountries"))
	        .andExpect(status().isFound())
	        .andDo(print());
	}
	
	

}
