package com.fantine.dao;

import java.util.List;


import com.fantine.model.LoanRequest;

public interface LoanRequestDao {
	public List<LoanRequest> getAllLoanRequests();
	public LoanRequest getLoanRequestById(int id);
	public void updateLoanRequest(LoanRequest loanRequest);
	public void addLoanRequest(LoanRequest loanRequest);
	public void deleteLoanRequest(int id);

}
