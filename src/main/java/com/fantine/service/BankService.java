package com.fantine.service;

import java.util.List;

import com.fantine.model.Bank;

public interface BankService {
	
	public List<Bank> getAllBanks();
	public Bank getBankById(int id);
	public void updateBank(Bank bank);
	public void addBank(Bank bank);
	public void deleteBank(int id);

}
