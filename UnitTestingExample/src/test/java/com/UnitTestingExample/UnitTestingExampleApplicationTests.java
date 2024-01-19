package com.UnitTestingExample;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;



class UnitTestingExampleApplicationTests {
	
	private Calculator c = new Calculator();

	@Test
	void contextLoads() {
	}
	
	@Test
	void testSum() {
		int expectedResult = 17;
		
		int actualResult = c.doSum(12, 3, 2);
		
		assertThat(actualResult).isEqualTo(expectedResult);
		
	}
	
	@Test
	void testProduct() {
		//expected result 
		int expectedResult = 6;
		
		int actualResult = c.doProduct(3, 2);
		
		assertThat(actualResult).isEqualTo(expectedResult);
		
	}


	@Test
	void testCompareNums(){
		Boolean actualResult = c.compareTwoNums(3, 3);

		assertThat(actualResult).isEqualTo(true);

	}

}
