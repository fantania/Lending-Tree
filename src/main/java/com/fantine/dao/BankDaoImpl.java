package com.fantine.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fantine.model.Bank;

@Repository
public class BankDaoImpl implements BankDao{
	
	@Autowired
    private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

	@Override
	@SuppressWarnings("unchecked")
	public List<Bank> getAllBanks() {
		List<Bank> lst = getCurrentSession().createQuery("from Bank").list();
			
		return lst;
	}

	@Override
	public Bank getBankById(int id) {
		
		Bank bank = (Bank) getCurrentSession().get(Bank.class, id);
        return bank;
	}
	@Override
	public void updateBank(Bank bank) {
		Bank bankToUpdate = getBankById(bank.getBankId());
		bankToUpdate.setBankName(bank.getBankName());
		bankToUpdate.setBankBranch(bank.getBankBranch());
		bankToUpdate.setBankAddress(bank.getBankAddress());
        getCurrentSession().update(bankToUpdate);
		
	}

	@Override
	public void addBank(Bank bank) {
		getCurrentSession().save(bank);		
	}

	

	@Override
	public void deleteBank(int id) {
		Bank bank = getBankById(id);
        if (bank != null)
            getCurrentSession().delete(bank);
		
	}

}



 
    