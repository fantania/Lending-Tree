package com.fantine.dao;

import java.util.List;

import com.fantine.model.Bank;

public interface BankDao {
	
	public List<Bank> getAllBanks();
	public Bank getBankById(int id);
	public void updateBank(Bank bank);
	public void addBank(Bank bank);
	public void deleteBank(int id);

}

