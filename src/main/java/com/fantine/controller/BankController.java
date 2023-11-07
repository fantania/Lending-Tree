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
import com.fantine.service.BankService;



@Controller
@RequestMapping(value = "/bank")
public class BankController {
	
	@Autowired
	BankService bankService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list()
	{
		
		ModelAndView model = new ModelAndView("bank_list");
		List<Bank> bankList = bankService.getAllBanks();
		model.addObject("bankList",bankList);
		
		
		return model;
	}
	
	@RequestMapping(value = "/addBank", method = RequestMethod.GET)
	public ModelAndView addBank()
	{
		ModelAndView model = new ModelAndView();
		Bank bank = new Bank();
		model.addObject("bankForm",bank);
		model.setViewName("bank_form");
		
		return model;
	}
	
	@RequestMapping(value="/edit/{bankId}", method=RequestMethod.GET)
    public ModelAndView editTeamPage(@PathVariable Integer bankId) {
        ModelAndView modelAndView = new ModelAndView("edit_bank_form");
        Bank bank = bankService.getBankById(bankId);
        modelAndView.addObject("bankEdit",bank);
        return modelAndView;
    }
	
	@RequestMapping(value = "/updateBank", method = RequestMethod.POST)
	public ModelAndView editBank(@ModelAttribute("bankEdit") Bank bank)
	{
		
		bankService.updateBank(bank);
		ModelAndView model = new ModelAndView("redirect:/bank/list");
		
		return model;
	}
	
	@RequestMapping(value = "/saveBank", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("bankForm") Bank bank)
	{
		
		bankService.addBank(bank);
		ModelAndView model = new ModelAndView("redirect:/bank/list");
	
		return model;
	}
	
	@RequestMapping(value = "/deleteBank/{bankId}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable int bankId)
	{
		
		bankService.deleteBank(bankId);
		ModelAndView model = new ModelAndView("redirect:/bank/list");
	
		return model;
	}


}
