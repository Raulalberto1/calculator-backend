package com.api.backend.demo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.backend.demo.model.Operation;
import com.api.backend.demo.model.OperationRequest;
import com.api.backend.demo.model.OperationResponse;
import com.api.backend.demo.model.Record;
import com.api.backend.demo.repository.OperationRepository;
import com.api.backend.demo.repository.RecordReposiroty;
import com.api.backend.demo.utils.Constants;

@Service
public class OperationService {

	@Autowired
	private RecordReposiroty recordReposiroty;
	
	@Autowired
	private OperationRepository operationRepository;
	
	@Autowired
	private RecordService recordService;
	
	public ResponseEntity<OperationResponse> createOperation(OperationRequest operationRequest) {
		Double result = 0.0;
		Record record = new Record();
		switch (operationRequest.getOperationType()) {
	      case Constants.ADDITION:
	        result = operationRequest.getN1() + operationRequest.getN2();
	        record.setOperationResponse("Addition operation");
	        break;
	      case Constants.SUBTRACTION:
	        result = operationRequest.getN1() - operationRequest.getN2();
	        record.setOperationResponse("Subtraction operation");
	        break;
	      case Constants.MULTIPLICATION:
	        result = operationRequest.getN1() * operationRequest.getN2();
	        record.setOperationResponse("Multiplication operation");
	        break;
	      case Constants.DIVISION:
	    	if(operationRequest.getN2()==0)
    		  throw new ArithmeticException("Division by zero is not allowed.");
	        result = operationRequest.getN1() / operationRequest.getN2();
	        record.setOperationResponse("Division operation");
	        break;
	      case Constants.SQRT:
	    	  if(operationRequest.getN1()<0)
	    		  throw new ArithmeticException("Cannot calculate the square root of a negative number.");
	        result = Math.sqrt(operationRequest.getN1());
	        record.setOperationResponse("Sqrt operation");
	        break;
	      case Constants.RANDOM_STRING:
	        result = operationRequest.getN1();
	        record.setOperationResponse("Random operation");
	        break;
	    }
		
		Double currentBalace = recordService.getBalance(operationRequest.getUserId());
		Operation operation = operationRepository.findByType(operationRequest.getOperationType()).get();
		record.setAmount(operation.getCost());
		record.setDate(LocalDateTime.now());
		record.setIdOperation(operation.getId());
		record.setIdUser(operationRequest.getUserId());
		record.setUserBalance(currentBalace-operation.getCost());
		recordReposiroty.save(record);
		OperationResponse operationResponse = new OperationResponse();
		operationResponse.setResult(result);
		operationResponse.setBalance(recordService.getBalance(operationRequest.getUserId()));
		return ResponseEntity.ok(operationResponse);
	}
	
	public ResponseEntity<List<Operation>> findAll(){
		List<Operation>lstOperation = operationRepository.findAll();
		return ResponseEntity.ok(lstOperation);
	}
}
