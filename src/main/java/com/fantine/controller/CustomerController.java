package com.fantine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fantine.model.Bank;
import com.fantine.model.Customer;
import com.fantine.service.CustomerService;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
	
	
	@Autowired
	CustomerService customerService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list()
	{
		ModelAndView model = new ModelAndView("customer_list");
		List<Customer> customerList = customerService.getAllCustomers();
		model.addObject("customerList",customerList);
		
		
		return model;
	}
	
	@RequestMapping(value = "/addCustomer", method = RequestMethod.GET)
	public ModelAndView addBank()
	{
		ModelAndView model = new ModelAndView();
		Customer customer = new Customer();
		model.addObject("customerForm",customer);
		model.setViewName("bcustomer_form");
		
		return model;
	}
	
	@RequestMapping(value="/edit/{custId}", method=RequestMethod.GET)
    public ModelAndView editTeamPage(@PathVariable Integer custId) {
        ModelAndView modelAndView = new ModelAndView("edit_customer_form");
        Customer customer = customerService.getCustomerById(custId);
        modelAndView.addObject("customerEdit",customer);
        return modelAndView;
    }
	
	@RequestMapping(value = "/updateCustomer", method = RequestMethod.POST)
	public ModelAndView editBank(@ModelAttribute("customerEdit") Customer customer)
	{
		
		customerService.updateCustomer(customer);
		ModelAndView model = new ModelAndView("redirect:/customer/list");
		
		return model;
	}
	
	@RequestMapping(value = "/saveCustomer", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("customerForm") Customer customer)
	{
		
		customerService.addCustomer(customer);
		ModelAndView model = new ModelAndView("redirect:/customer/list");
	
		return model;
	}
	
	@RequestMapping(value = "/deleteCustomer/{custId}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable int custId)
	{
		
		customerService.deleteCustomer(custId);
		ModelAndView model = new ModelAndView("redirect:/customer/list");
	
		return model;
	}



}
