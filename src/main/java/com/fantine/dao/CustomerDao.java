package com.fantine.dao;

import java.util.List;

import com.fantine.model.Customer;

public interface CustomerDao {
	public List<Customer> getAllCustomers();
	public Customer getCustomerById(int id);
	public void updateCustomer(Customer customer);
	public void addCustomer(Customer customer);
	public void deleteCustomer(int id);

}
