package com.api.backend.demo.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "record")
public class Record {

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "id_operation")
	private Long idOperation;
	
	@Column(name = "id_user")
	private Long idUser;
	
	private Double amount;
	
	@Column(name = "user_balance")
	private Double userBalance;
	
	@Column(name = "operation_response")
	private String operationResponse;
	
	@Column(name = "operation_timestamp")
	private LocalDateTime date;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdOperation() {
		return idOperation;
	}
	public void setIdOperation(Long idOperation) {
		this.idOperation = idOperation;
	}
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Double getUserBalance() {
		return userBalance;
	}
	public void setUserBalance(Double userBalance) {
		this.userBalance = userBalance;
	}
	public String getOperationResponse() {
		return operationResponse;
	}
	public void setOperationResponse(String operationResponse) {
		this.operationResponse = operationResponse;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
}
