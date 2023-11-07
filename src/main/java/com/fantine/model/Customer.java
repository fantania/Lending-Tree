package com.fantine.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CUSTOMER_ID")
	private int custId;
	private String custEmail;
	private String custName;
	
	@Column(name = "CUSTPWD", unique = true)
	private String custPWD;
	private int custPhone;
	private String custAddress;
	private int custSNN;
	private long customerIdentifier;
	
	
	
	
	/*@OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="CUSTOMER_ID")
    private Set<Document> documents;
	
	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="CUSTOMER_ID")
    private Set<LoanRequest> loans;
	
	public Set<LoanRequest> getLoans() {
		return loans;
	}
	public void setLoans(Set<LoanRequest> loans) {
		this.loans = loans;
	}
	public Set<Document> getDocuments() {
		return documents;
	}
	public void setDocuments(Set<Document> documents) {
		this.documents = documents;
	}*/
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustEmail() {
		return custEmail;
	}
	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustPWD() {
		return custPWD;
	}
	public void setCustPWD(String custPWD) {
		this.custPWD = custPWD;
	}
	public int getCustPhone() {
		return custPhone;
	}
	public void setCustPhone(int custPhone) {
		this.custPhone = custPhone;
	}
	public String getCustAddress() {
		return custAddress;
	}
	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}
	public int getCustSNN() {
		return custSNN;
	}
	public void setCustSNN(int custSNN) {
		this.custSNN = custSNN;
	}
	
	public long getCustomerIdentifier() {
		return customerIdentifier;
	}
	public void setCustomerIdentifier(long customerIdentifier) {
		this.customerIdentifier = customerIdentifier;
	}
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custEmail=" + custEmail + ", custName=" + custName + ", custPWD="
				+ custPWD + ", custPhone=" + custPhone + ", custAddress=" + custAddress + ", custSNN=" + custSNN
				+ ", customerIdentifier=" + customerIdentifier + "]";
	}
	
	
	

}
