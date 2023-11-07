package com.fantine.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bank")
public class Bank {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE) SEQUENCE is used in oracle
	@GeneratedValue(strategy = GenerationType.IDENTITY) // IDENTITY usd in MySql
	private int bankId;
	private String bankName;
	private String bankBranch;
	private String bankAddress;
	
	


	public int getBankId() {
		return bankId;
	}
	public void setBankId(int bankId) {
		this.bankId = bankId;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankBranch() {
		return bankBranch;
	}
	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
	}
	public String getBankAddress() {
		return bankAddress;
	}
	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}
	@Override
	public String toString() {
		return "Bank [bankId=" + bankId + ", bankName=" + bankName + ", bankBranch=" + bankBranch + ", bankAddress="
				+ bankAddress + "]";
	}
	
	

}
