package com.api.backend.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.backend.demo.model.Operation;
import com.api.backend.demo.model.OperationRequest;
import com.api.backend.demo.model.OperationResponse;
import com.api.backend.demo.service.OperationService;

@RestController
@RequestMapping("/api/operation")
@CrossOrigin(origins = "http://localhost:3000")
public class OperationController {

	@Autowired
	private OperationService operationService;
	
	@GetMapping
	public ResponseEntity<List<Operation>> findAll(){
		return operationService.findAll();
	}
	
	@PostMapping
	public ResponseEntity<OperationResponse> processOperation(@RequestBody OperationRequest operationRequest){
		return operationService.createOperation(operationRequest);
	}
}
