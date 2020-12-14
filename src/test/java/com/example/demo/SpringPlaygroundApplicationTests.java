package com.example.demo;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest
class SpringPlaygroundApplicationTests {

	@Autowired
	WordCounter wordCounter;

	@Test
	public void testWordCounter() {
		assertThat(wordCounter.getWords(), equalTo(""));
	}

	@Test
	void contextLoads() {
	}

}
