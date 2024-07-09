package com.api.backend.demo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordReposiroty extends JpaRepository<com.api.backend.demo.model.Record, Long>{

	List<com.api.backend.demo.model.Record> findByIdUserOrderByIdDesc(Long userId);
	
	@Query("SELECT r FROM Record r WHERE r.idUser = :userId order by r.id desc")
	Page<com.api.backend.demo.model.Record> findByUserIdAndNotDeleted(@Param("userId") Long userId, Pageable pageable);
}
