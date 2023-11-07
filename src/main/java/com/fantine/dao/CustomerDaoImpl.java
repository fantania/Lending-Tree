package com.fantine.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fantine.model.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao{
	
	@Autowired
    private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

	@Override
	@SuppressWarnings("unchecked")
	public List<Customer> getAllCustomers() {
		List<Customer> lst = getCurrentSession().createQuery("from Customer").list();
		
		return lst;
		
	}

	@Override
	public Customer getCustomerById(int id) {
		Customer customer = (Customer) getCurrentSession().get(Customer.class, id);
        return customer;
	}

	@Override
	public void updateCustomer(Customer customer) {
		Customer customerToUpdate = getCustomerById(customer.getCustId());
		customerToUpdate.setCustName(customer.getCustName());
		customerToUpdate.setCustPWD(customer.getCustPWD());
		customerToUpdate.setCustPhone(customer.getCustPhone());
		customerToUpdate.setCustAddress(customer.getCustAddress());
		customerToUpdate.setCustSNN(customer.getCustSNN());
		
		
	}

	@Override
	public void addCustomer(Customer customer) {
		
		getCurrentSession().save(customer);		
	}

	@Override
	public void deleteCustomer(int id) {
		
		Customer customer = getCustomerById(id);
        if (customer != null)
            getCurrentSession().delete(customer);
		
	}

}
