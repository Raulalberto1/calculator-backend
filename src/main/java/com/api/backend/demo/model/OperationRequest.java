package com.api.backend.demo.model;

public class OperationRequest {

	private String operationType;
	private Double n1;
	private Double n2;
	private Long userId;
	
	public String getOperationType() {
		return operationType;
	}
	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}
	public Double getN1() {
		return n1;
	}
	public void setN1(Double n1) {
		this.n1 = n1;
	}
	public Double getN2() {
		return n2;
	}
	public void setN2(Double n2) {
		this.n2 = n2;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
