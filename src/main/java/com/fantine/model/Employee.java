package com.fantine.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empId;
	private String empName;
	private String empDep;
	private String empEmail;
	private String  empAddress;
	private int empPhone;
	private int empWorkLoad;
	private String empIdentifier;
	private String empPswd;
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpDep() {
		return empDep;
	}
	public void setEmpDep(String empDep) {
		this.empDep = empDep;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public String getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}
	public int getEmpPhone() {
		return empPhone;
	}
	public void setEmpPhone(int empPhone) {
		this.empPhone = empPhone;
	}
	
	public int getEmpWorkLoad() {
		return empWorkLoad;
	}
	public void setEmpWorkLoad(int workLoad) {
		this.empWorkLoad = workLoad;
	}
	public String getEmpIdentifier() {
		return empIdentifier;
	}
	public void setEmpIdentifier(String empIdentifier) {
		this.empIdentifier = empIdentifier;
	}
	public String getEmpPswd() {
		return empPswd;
	}
	public void setEmpPswd(String empPswd) {
		this.empPswd = empPswd;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empDep=" + empDep + ", empEmail=" + empEmail
				+ ", empAddress=" + empAddress + ", empPhone=" + empPhone + ", empWorkLoad=" + empWorkLoad
				+ ", empIdentifier=" + empIdentifier + ", empPswd=" + empPswd + "]";
	}
	
	
	
	
	

}
