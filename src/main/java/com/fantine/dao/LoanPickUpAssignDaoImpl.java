package com.fantine.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.fantine.model.LoanPickUpAssign;

@Repository
public class LoanPickUpAssignDaoImpl implements LoanPickUpAssignDao{

	
	@Autowired
    private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

	@Override
	@SuppressWarnings("unchecked")
	public List<LoanPickUpAssign> getAllLoanPickUpAssigns() {
		List<LoanPickUpAssign> lst = getCurrentSession().createQuery("from LoanPickUpAssign").list();
		
		return lst;
	}

	@Override
	public LoanPickUpAssign getLoanPickUpAssignById(int id) {
		LoanPickUpAssign loanPickUpAssign = (LoanPickUpAssign) getCurrentSession().get(LoanPickUpAssign.class, id);
        return loanPickUpAssign;
	}

	@Override
	public void updateLoanPickUpAssign(LoanPickUpAssign loanPickUpAssign) {
		
		LoanPickUpAssign loanPickUpAssignkToUpdate = getLoanPickUpAssignById(loanPickUpAssign.getId());
		loanPickUpAssignkToUpdate.setEmpId(loanPickUpAssign.getEmpId());
		loanPickUpAssignkToUpdate.setLoanId(loanPickUpAssign.getLoanId());
        getCurrentSession().update(loanPickUpAssignkToUpdate);
		
	}

	@Override
	public void addLoanPickUpAssign(LoanPickUpAssign loanPickUpAssign) {
		
		getCurrentSession().save(loanPickUpAssign);	
		
	}

	@Override
	public void deleteLoanPickUpAssign(int id) {
		
		LoanPickUpAssign loanPickUpAssign = getLoanPickUpAssignById(id);
        if (loanPickUpAssign != null)
            getCurrentSession().delete(loanPickUpAssign);
		
	}
	
	

}
