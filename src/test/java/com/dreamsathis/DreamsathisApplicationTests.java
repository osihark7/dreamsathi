package com.dreamsathis;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DreamsathisApplicationTests {
	
	private Calculator c = new Calculator();

	@Test
	void contextLoads() {
	}

	
	@Test
	void doSum() {
		//expected result
		int expected = 60;
		
		//actual result
		int actualResult = c.doSum(20, 20, 20);
		assertThat(actualResult).isEqualTo(expected);
	}
	
	@Test
	void doMult() {
		//expected result
		int expected = 400;
		
		//actual result
		int actualResult = c.doMult(20, 20);
		assertThat(actualResult).isEqualTo(expected);
		
	
		
	}
}
