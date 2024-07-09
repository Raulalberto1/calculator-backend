package com.api.backend.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.api.backend.demo.repository.RecordReposiroty;

@Service
public class RecordService {

	@Autowired
	private RecordReposiroty recordReposiroty;
	
	public Double getBalance(Long userId) {
		List<com.api.backend.demo.model.Record> recordLst = recordReposiroty.findByIdUserOrderByIdDesc(userId);
		if(!recordLst.isEmpty()) {
			return recordLst.get(0).getUserBalance();
		}
		return 0.0;
	}
	
	public Page<com.api.backend.demo.model.Record> getRecords(Long userId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return recordReposiroty.findByUserIdAndNotDeleted(userId, pageable);
    }
	
	public void softDeleteRecord(Long recordId) {
		recordReposiroty.deleteById(recordId);
    }
}
