package com.api.backend.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import com.api.backend.demo.controller.RecordController;

@SpringBootTest
public class RecordControllerTest {

	@Autowired
	private RecordController controller;
	
	@Test
    @DisplayName("Get balance of a user")
	void getBalance(){
		ResponseEntity<Double> response = controller.getBalance(1L);
		assertEquals(response.getStatusCode(),HttpStatusCode.valueOf(200));
	}
	
	@Test
    @DisplayName("Get zero balance of a user")
	void getBalanceZero(){
		ResponseEntity<Double> response = controller.getBalance(4L);
		assertEquals(response.getBody(), 0);
	}
	
	@Test
    @DisplayName("Get operations records of a user")
	void getRecords(){
		Page<com.api.backend.demo.model.Record> response = controller.getRecords(1L, 1,10);
		assertEquals(response.getSize()>0, true);
	}
	
	/*@Test
    @DisplayName("Delete record of a user")
	void softDeleteRecord(){
		controller.softDeleteRecord(195L);
	}*/
}
