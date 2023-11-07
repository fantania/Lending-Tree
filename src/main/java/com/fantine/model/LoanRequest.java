package com.fantine.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="loanRequest")
public class LoanRequest {


	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int loanId;
	private String loantype;
	private String status;
	private String bank;
	private String loanDate;
	
	
	//
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)//mappedBy = "loanid"
	@JoinColumn(name = "loanid")
	private List<Document> documents = new ArrayList<>();

	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="CUSTOMER_ID")
    private Customer customer;

	

	public int getLoanId() {
		return loanId;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}

	public String getLoantype() {
		return loantype;
	}

	public void setLoantype(String loantype) {
		this.loantype = loantype;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
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

	public void setLoanDate(String date) {
		this.loanDate = date;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}
	
	
	
	


}
