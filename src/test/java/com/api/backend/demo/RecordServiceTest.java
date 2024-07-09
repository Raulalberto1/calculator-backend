package com.api.backend.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import com.api.backend.demo.service.RecordService;

@SpringBootTest
public class RecordServiceTest {

	@Autowired
	private RecordService service;
	
	@Test
    @DisplayName("Get zero balance of a user")
	void getBalanceZero(){
		Double response = service.getBalance(4L);
		assertEquals(response, 0);
	}
	
	@Test
    @DisplayName("Get operations records of a user")
	void getRecords(){
		Page<com.api.backend.demo.model.Record> response = service.getRecords(1L, 1,10);
		assertEquals(response.getSize()>0, true);
	}
}
