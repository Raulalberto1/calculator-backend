package com.api.backend.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import com.api.backend.demo.controller.OperationController;
import com.api.backend.demo.model.Operation;
import com.api.backend.demo.model.OperationRequest;
import com.api.backend.demo.model.OperationResponse;

@SpringBootTest
public class OperationControllerTest {

	@Autowired
	OperationController controller;
	
	@Test
    @DisplayName("Value of returns a list of available operations")
    void findAll() {
    	ResponseEntity<List<Operation>> response = controller.findAll();
    	assertEquals(response.getBody().size()>0,true);
    }
	
	@Test
    @DisplayName("Value of returns ok response from a valid addition operation")
    void createAdditionOperation() {
    	OperationRequest operationRequest = new OperationRequest();
    	operationRequest.setN1(1.0);
    	operationRequest.setN2(1.0);
    	operationRequest.setOperationType("addition");
    	operationRequest.setUserId(1L);
    	ResponseEntity<OperationResponse> response = controller.processOperation(operationRequest);
    	assertEquals(response.getStatusCode(),HttpStatusCode.valueOf(200));
    }
	
	@Test
    @DisplayName("Value of returns ok response from a valid subtraction operation")
    void createSubtractionOperation() {
    	OperationRequest operationRequest = new OperationRequest();
    	operationRequest.setN1(1.0);
    	operationRequest.setN2(1.0);
    	operationRequest.setOperationType("subtraction");
    	operationRequest.setUserId(1L);
    	ResponseEntity<OperationResponse> response = controller.processOperation(operationRequest);
    	assertEquals(response.getStatusCode(),HttpStatusCode.valueOf(200));
    }
	
	@Test
    @DisplayName("Value of returns ok response from a valid multiplication operation")
    void createMultiplicationOperation() {
    	OperationRequest operationRequest = new OperationRequest();
    	operationRequest.setN1(1.0);
    	operationRequest.setN2(1.0);
    	operationRequest.setOperationType("multiplication");
    	operationRequest.setUserId(1L);
    	ResponseEntity<OperationResponse> response = controller.processOperation(operationRequest);
    	assertEquals(response.getStatusCode(),HttpStatusCode.valueOf(200));
    }
	
	@Test
    @DisplayName("Value of returns ok response from a valid division operation")
    void createDivisionOperation() {
    	OperationRequest operationRequest = new OperationRequest();
    	operationRequest.setN1(1.0);
    	operationRequest.setN2(1.0);
    	operationRequest.setOperationType("division");
    	operationRequest.setUserId(1L);
    	ResponseEntity<OperationResponse> response = controller.processOperation(operationRequest);
    	assertEquals(response.getStatusCode(),HttpStatusCode.valueOf(200));
    }
	
	@Test
    @DisplayName("Value of returns ok response from a valid sqrt operation")
    void createSqrtOperation() {
    	OperationRequest operationRequest = new OperationRequest();
    	operationRequest.setN1(1.0);
    	operationRequest.setN2(1.0);
    	operationRequest.setOperationType("sqrt");
    	operationRequest.setUserId(1L);
    	ResponseEntity<OperationResponse> response = controller.processOperation(operationRequest);
    	assertEquals(response.getStatusCode(),HttpStatusCode.valueOf(200));
    }
	
	@Test
    @DisplayName("Value of returns ok response from a valid randomString operation")
    void createRandomStringOperation() {
    	OperationRequest operationRequest = new OperationRequest();
    	operationRequest.setN1(1919494.0);
    	operationRequest.setN2(null);
    	operationRequest.setOperationType("randomString");
    	operationRequest.setUserId(1L);
    	ResponseEntity<OperationResponse> response = controller.processOperation(operationRequest);
    	assertEquals(response.getStatusCode(),HttpStatusCode.valueOf(200));
    }
}
