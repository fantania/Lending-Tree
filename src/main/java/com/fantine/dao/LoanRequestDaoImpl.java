package com.fantine.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fantine.model.LoanRequest;

@Repository
public class LoanRequestDaoImpl implements LoanRequestDao{

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<LoanRequest> getAllLoanRequests() {
		List<LoanRequest> lst = getCurrentSession().createQuery("from LoanRequest").list();

		return lst;
	}

	@Override
	public LoanRequest getLoanRequestById(int id) {
		
		LoanRequest loanRequest = (LoanRequest) getCurrentSession().get(LoanRequest.class, id);
        return loanRequest;
	}

	@Override
	public void updateLoanRequest(LoanRequest loanRequest) {
		LoanRequest loanRequestToUpdate = getLoanRequestById(loanRequest.getLoanId());
		loanRequestToUpdate.setLoantype(loanRequest.getLoantype());
		loanRequestToUpdate.setStatus(loanRequest.getStatus());
       

	}

	@Override
	public void addLoanRequest(LoanRequest loanRequest) {
		getCurrentSession().save(loanRequest);

	}

	@Override
	public void deleteLoanRequest(int id) {
		LoanRequest loanRequest = getLoanRequestById(id);
        if (loanRequest != null)
            getCurrentSession().delete(loanRequest);

	}

}
