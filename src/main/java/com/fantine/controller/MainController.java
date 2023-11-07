package com.fantine.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fantine.model.Bank;
import com.fantine.model.Customer;
import com.fantine.model.CustomerLoanRequest;
import com.fantine.model.Document;
import com.fantine.model.Employee;
import com.fantine.model.LoanPickUpAssign;
import com.fantine.model.LoanRequest;
import com.fantine.service.BankService;
import com.fantine.service.CustomerService;
import com.fantine.service.EmployeeService;
import com.fantine.service.LoanPickUpAssignService;
import com.fantine.service.LoanRequestService;


@Controller
public class MainController {

	@Autowired
	BankService bankService;
	//DepartmentService departmentService;

	@Autowired
	LoanPickUpAssignService loanPickUpAssignService;

	@Autowired
	LoanRequestService loanRequestService;

	@Autowired
	CustomerService customerService;

	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "/admin", method=RequestMethod.GET)
	public ModelAndView home() {

		return new ModelAndView("admin");

	}

	@RequestMapping(value = "/loanRequest", method=RequestMethod.GET)
	public ModelAndView loanRequest() {
		ModelAndView model = new ModelAndView("loanRequest");

		List<Bank> lstBank = bankService.getAllBanks();

		List<String> bnkNames = new ArrayList<>();
		for (Bank dpt : lstBank) 
		{
			bnkNames.add(dpt.getBankName()); 	

		}

		model.addObject("bnkNames",bnkNames);


		return model;

		//return new ModelAndView("loanRequest");

	}

	@RequestMapping(value = "/login", method=RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView model = new ModelAndView("login");

		return model;

	}

	@RequestMapping(value = "/", method=RequestMethod.GET)
	public ModelAndView index1() {
		ModelAndView model = new ModelAndView("loanRequest");

		return model;

	}

	@RequestMapping(value = "/loginSuccess", method=RequestMethod.POST)
	public ModelAndView loginSuccess(HttpServletRequest request, ModelMap map) {

		boolean ok = false;
		ModelAndView model = new ModelAndView();
		String identifier = request.getParameter("identifier");
		String pswd = request.getParameter("pswd");

		if(identifier.equals("admin") && pswd.equals("admin"))
		{
			return new ModelAndView("admin");
		}

		List<LoanRequest> loanRequests = new ArrayList<>();

		List<Employee> lst = employeeService.getAllEmployees();

		/***************************************CUSTOMER LOGIN****************************/


		List <Customer> cusLst = customerService.getAllCustomers();

		for(Customer c:cusLst) {
			
			if(Long.toString(c.getCustomerIdentifier()).equals(identifier) && c.getCustPWD().equals(pswd))

			{
				ok=true;
				List <LoanRequest> l = loanRequestService.getAllLoanRequests();
				List<LoanRequest> loanCustomerList = new ArrayList<>();
				for(LoanRequest l1:l) {

					if(l1.getCustomer().getCustId()==c.getCustId())
					{

						System.out.println("Customer found: "+c);
						ModelAndView mc = new ModelAndView("loginSuccessCustomer");
						loanCustomerList.add(l1);
						mc.addObject("loanList",loanCustomerList);
						return mc;
					}
			}
				
				
			}
		}
		/***************************************END OF CUSTOMER LOGIN****************************/


		for(Employee e: lst)
		{
			if(e.getEmpIdentifier()!=null && e.getEmpIdentifier().equals(identifier) && e.getEmpPswd()!=null && e.getEmpPswd().equals(pswd))

			{
				ok=true;
				List<LoanPickUpAssign> lrs;
				lrs = loanPickUpAssignService.getAllLoanPickUpAssigns();

				for(LoanPickUpAssign lpa: lrs)
				{
					if(e.getEmpId()==lpa.getEmpId())
					{
						int idLoan = lpa.getLoanId();
						LoanRequest loan = loanRequestService.getLoanRequestById(idLoan);
						loanRequests.add(loan);

						List<CustomerLoanRequest> clrs = new ArrayList<>();

						int empIdLoan = e.getEmpId();

						for(LoanRequest lr: loanRequests)
						{
							CustomerLoanRequest clr = new CustomerLoanRequest();
							List<String> dcmts = new ArrayList<>();
							List<Document> lstDoc;


							Customer cst = lr.getCustomer();
							clr.setCustomerIdentifier(cst.getCustomerIdentifier());
							clr.setLoanId(lr.getLoanId());
							clr.setLoanType(lr.getLoantype());
							clr.setBankName(lr.getBank());
							clr.setCustomerAddress(cst.getCustAddress());
							clr.setStatus(lr.getStatus());
							clr.setLoanDate(lr.getLoanDate());
							lstDoc = lr.getDocuments();
							for(Document d: lstDoc)
							{
								dcmts.add(d.getDocumentName());

							}
							clr.setDocumentsList(dcmts);
							clr.setEmpIdLoan(empIdLoan);

							clrs.add(clr);
						}

						model.addObject("loanList",clrs);

					}
				}

				if(e.getEmpDep().equalsIgnoreCase("PICKUP"))
				{
					model.setViewName("loginSuccessPickup");
				}

				if(e.getEmpDep().equalsIgnoreCase("VERIFICATION"))
				{
					model.setViewName("loginSuccessVerification");
				}

				if(e.getEmpDep().equalsIgnoreCase("LEGAL"))
				{
					model.setViewName("loginSuccessLegal");
				}

			}

		}


		if(ok==false)
		{
			return new ModelAndView("failLogin");
		}
		return model;

	}

	@RequestMapping(value = "/index", method=RequestMethod.GET)
	public ModelAndView index() {


		ModelAndView model = new ModelAndView();

		List<Bank> lstBank = bankService.getAllBanks();

		List<String> bnkNames = new ArrayList<>();
		for (Bank dpt : lstBank) 
		{
			bnkNames.add(dpt.getBankName()); 	

		}

		model.addObject("bnkNames",bnkNames);


		return model;
	}

}
