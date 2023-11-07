package com.fantine.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fantine.dao.CustomerDao;
import com.fantine.model.Customer;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerDao customerDao;

	@Override
	public List<Customer> getAllCustomers() {
		
		List<Customer> lst = customerDao.getAllCustomers();
		return lst;
	}

	@Override
	public Customer getCustomerById(int id) {
		Customer customer = customerDao.getCustomerById(id);
		return customer;
	}

	@Override
	public void updateCustomer(Customer customer) {
		customerDao.updateCustomer(customer);
		
	}

	@Override
	public void addCustomer(Customer customer) {
		
		customerDao.addCustomer(customer);
		
	}

	@Override
	public void deleteCustomer(int id) {
		customerDao.deleteCustomer(id);
		
	}

}
