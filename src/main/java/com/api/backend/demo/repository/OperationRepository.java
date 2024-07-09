package com.api.backend.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.backend.demo.model.Operation;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long>{

	Optional<Operation> findByType(String type);
}
