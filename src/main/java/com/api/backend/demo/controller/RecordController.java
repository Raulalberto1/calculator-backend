package com.api.backend.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.backend.demo.service.RecordService;

@RestController
@RequestMapping("/api/record")
@CrossOrigin(origins = "http://localhost:3000")
public class RecordController {

	@Autowired
	private RecordService recordService;
	
	@GetMapping("/balance")
	public ResponseEntity<Double> getBalance(@RequestParam Long userId) {
		Double balance = recordService.getBalance(userId);
		return ResponseEntity.ok(balance);
	}
	
	@GetMapping
    public Page<com.api.backend.demo.model.Record> getRecords(@RequestParam Long userId,
                                   @RequestParam int page,
                                   @RequestParam int size) {
        return recordService.getRecords(userId, page, size);
    }
	
	@DeleteMapping("/{id}")
    public ResponseEntity<Void> softDeleteRecord(@PathVariable Long id) {
        recordService.softDeleteRecord(id);
        return ResponseEntity.noContent().build();
    }
}
