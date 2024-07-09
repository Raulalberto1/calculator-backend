package com.api.backend.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit4.SpringRunner;

import com.api.backend.demo.model.Operation;
import com.api.backend.demo.model.OperationRequest;
import com.api.backend.demo.model.OperationResponse;
import com.api.backend.demo.repository.OperationRepository;
import com.api.backend.demo.repository.RecordReposiroty;
import com.api.backend.demo.repository.UserRepository;
import com.api.backend.demo.service.OperationService;
import com.api.backend.demo.service.RecordService;

//@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class OperationServiceTest {

	public OperationServiceTest() {
        MockitoAnnotations.initMocks(this);
    }
	
	/*@Mock
	private RecordReposiroty recordReposiroty;
	
	@Mock
	private OperationRepository operationRepository;*/
	
	/*@InjectMocks
    private OperationService operationService;
	
	@InjectMocks
	private RecordService recordService;*/

	@Autowired
    private OperationService service;
    
    @Test
    @DisplayName("Value of returns ok response from a valid operation")
    void createOperation() {
    	OperationRequest operationRequest = new OperationRequest();
    	operationRequest.setN1(1.0);
    	operationRequest.setN2(1.0);
    	operationRequest.setOperationType("addition");
    	operationRequest.setUserId(1L);
    	ResponseEntity<OperationResponse> response = service.createOperation(operationRequest);
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
    	ResponseEntity<OperationResponse> response = service.createOperation(operationRequest);
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
    	ResponseEntity<OperationResponse> response = service.createOperation(operationRequest);
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
    	ResponseEntity<OperationResponse> response = service.createOperation(operationRequest);
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
    	ResponseEntity<OperationResponse> response = service.createOperation(operationRequest);
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
    	ResponseEntity<OperationResponse> response = service.createOperation(operationRequest);
    	assertEquals(response.getStatusCode(),HttpStatusCode.valueOf(200));
    }
    
    @Test
    @DisplayName("Value of returns a list of available operations")
    void findAll() {
    	ResponseEntity<List<Operation>> response = service.findAll();
    	assertEquals(response.getBody().size()>0,true);
    }
}
