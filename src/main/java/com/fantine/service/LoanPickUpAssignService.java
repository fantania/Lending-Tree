package com.fantine.service;

import java.util.List;

import com.fantine.model.LoanPickUpAssign;

public interface LoanPickUpAssignService {
	
	public List<LoanPickUpAssign> getAllLoanPickUpAssigns();
	public LoanPickUpAssign getLoanPickUpAssignById(int id);
	public void updateLoanPickUpAssign(LoanPickUpAssign loanPickUpAssign);
	public void addLoanPickUpAssign(LoanPickUpAssign loanPickUpAssign);
	public void deleteLoanPickUpAssign(int id);

}
