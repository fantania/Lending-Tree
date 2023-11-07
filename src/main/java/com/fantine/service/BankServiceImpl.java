package com.fantine.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fantine.dao.BankDao;
import com.fantine.model.Bank;


@Service
@Transactional
public class BankServiceImpl implements BankService{
	

	@Autowired
    private BankDao bankDao;
	
	@Override
	public List<Bank> getAllBanks() {
		
		List<Bank> lst = bankDao.getAllBanks();
		
		return lst;
	}

	@Override
	public Bank getBankById(int id) {
		Bank bank = bankDao.getBankById(id);
		return bank;
	}

	@Override
	public void updateBank(Bank bank) {
		bankDao.updateBank(bank);
		
	}

	@Override
	public void addBank(Bank bank) {
		bankDao.addBank(bank);
		
	}

	@Override
	public void deleteBank(int id) {
		bankDao.deleteBank(id);
		
	}
	
	

}
