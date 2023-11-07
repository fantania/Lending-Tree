package com.fantine.model;

import java.util.List;

public class CustomerLoanRequest {
	
	private long customerIdentifier;
	private int empIdLoan;
	private String customerAddress;
	private int loanId;
	private String loanType;
	private String bankName;
	private String status;
	private String loanDate;
	
	private List<String> documentsList;
	
	public long getCustomerIdentifier() {
		return customerIdentifier;
	}
	public void setCustomerIdentifier(long customerIdentifier) {
		this.customerIdentifier = customerIdentifier;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public int getLoanId() {
		return loanId;
	}
	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public List<String> getDocumentsList() {
		return documentsList;
	}
	public void setDocumentsList(List<String> documentsList) {
		this.documentsList = documentsList;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLoanDate() {
		return loanDate;
	}
	public void setLoanDate(String loanDate) {
		this.loanDate = loanDate;
	}
	public int getEmpIdLoan() {
		return empIdLoan;
	}
	public void setEmpIdLoan(int empIdLoan) {
		this.empIdLoan = empIdLoan;
	}
	
	
	

}
