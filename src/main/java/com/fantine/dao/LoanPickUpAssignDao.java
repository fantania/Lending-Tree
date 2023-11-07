package com.fantine.dao;

import java.util.List;

import com.fantine.model.LoanPickUpAssign;



public interface LoanPickUpAssignDao {
	
	public List<LoanPickUpAssign> getAllLoanPickUpAssigns();
	public LoanPickUpAssign getLoanPickUpAssignById(int id);
	public void updateLoanPickUpAssign(LoanPickUpAssign loanPickUpAssign);
	public void addLoanPickUpAssign(LoanPickUpAssign loanPickUpAssign);
	public void deleteLoanPickUpAssign(int id);


}
