package com.fantine.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fantine.dao.LoanRequestDao;
import com.fantine.model.LoanRequest;



@Service
@Transactional
public class LoanRequestServiceImpl implements LoanRequestService{
	
	@Autowired
	LoanRequestDao loanRequestDao;

	@Override
	public List<LoanRequest> getAllLoanRequests() {
		
		List<LoanRequest> lst = loanRequestDao.getAllLoanRequests();
		return lst;
	}

	@Override
	public LoanRequest getLoanRequestById(int id) {
		
		LoanRequest loanRequest = loanRequestDao.getLoanRequestById(id);
		return loanRequest;
		
	}

	@Override
	public void updateLoanRequest(LoanRequest loanRequest) {
		
		loanRequestDao.updateLoanRequest(loanRequest);
		
	}

	@Override
	public void addLoanRequest(LoanRequest loanRequest) {
		
		loanRequestDao.addLoanRequest(loanRequest);
		
	}

	@Override
	public void deleteLoanRequest(int id) {
		
		loanRequestDao.deleteLoanRequest(id);
		
	}

	

}
