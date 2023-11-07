package com.fantine.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fantine.dao.LoanPickUpAssignDao;
import com.fantine.model.LoanPickUpAssign;

@Service
@Transactional
public class LoanPickUpAssignServiceImpl implements LoanPickUpAssignService{
	
	@Autowired
    private LoanPickUpAssignDao loanPickUpAssignDao;

	@Override
	public List<LoanPickUpAssign> getAllLoanPickUpAssigns() {
		
		List<LoanPickUpAssign> lst = new ArrayList<>();
		lst = loanPickUpAssignDao.getAllLoanPickUpAssigns();
		return lst;
	}

	@Override
	public LoanPickUpAssign getLoanPickUpAssignById(int id) {
		
		LoanPickUpAssign lpa = loanPickUpAssignDao.getLoanPickUpAssignById(id);
		return lpa;
		
	}

	@Override
	public void updateLoanPickUpAssign(LoanPickUpAssign loanPickUpAssign) {
		loanPickUpAssignDao.updateLoanPickUpAssign(loanPickUpAssign);
		
	}

	@Override
	public void addLoanPickUpAssign(LoanPickUpAssign loanPickUpAssign) {
		loanPickUpAssignDao.addLoanPickUpAssign(loanPickUpAssign);
		
	}

	@Override
	public void deleteLoanPickUpAssign(int id) {
		loanPickUpAssignDao.deleteLoanPickUpAssign(id);
		
	}

}
