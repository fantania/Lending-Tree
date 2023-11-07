package com.fantine.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fantine.model.Customer;
import com.fantine.model.CustomerLoanRequest;
import com.fantine.model.Document;
import com.fantine.model.Employee;
import com.fantine.model.IdGenerator;
import com.fantine.model.LoanPickUpAssign;
import com.fantine.model.LoanRequest;
import com.fantine.service.BankService;
import com.fantine.service.CustomerService;
import com.fantine.service.DocumentService;
import com.fantine.service.EmployeeService;
import com.fantine.service.LoanPickUpAssignService;
import com.fantine.service.LoanRequestService;

@Controller
@RequestMapping(value = "/loanRequest")
public class LoanRequestController {

	@Autowired
	CustomerService customerService;

	@Autowired
	DocumentService documentService;

	@Autowired
	LoanRequestService loanRequestrService;

	@Autowired
	BankService bankService;

	@Autowired
	EmployeeService employeeService;

	@Autowired
	LoanPickUpAssignService loanPickUpAssignService;

	@RequestMapping(value = "/saveLoan", method = RequestMethod.POST)
	public ModelAndView save(HttpServletRequest request, ModelMap map)
	{


		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		int phone = Integer.parseInt(request.getParameter("phone"));
		int ssn = Integer.parseInt(request.getParameter("ssn"));
		String loanType = request.getParameter("loanType");
		String[] documents = request.getParameterValues("documents");
		String bank = request.getParameter("bank");

		String pswd=name.substring(0, 2)+email.substring(0, 2)+"2018";


		Customer customer =new Customer();
		customer.setCustName(name);
		customer.setCustEmail(email);
		customer.setCustAddress(address);
		customer.setCustPhone(phone);
		customer.setCustSNN(ssn);
		customer.setCustPWD(pswd);
		long customerIdentifier = IdGenerator.getID();
		customer.setCustomerIdentifier(customerIdentifier);
		List<Document> documentsList = new ArrayList<>();

		for(int i=0;i<documents.length;i++)
		{
			System.out.println(documents[i]);
			Document document = new Document();
			document.setDocumentName(documents[i]);
			documentsList.add(document);
			//document.setCustomer(customer);
			documentService.addDocument(document);
		}

		//ADD DATE HERE IN LOAN REQUEST TABLE
		// Create an instance of SimpleDateFormat used for formatting 
		// the string representation of date (month/day/year)
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

		// Get the date today using Calendar object.
		Date today = Calendar.getInstance().getTime();        
		// Using DateFormat format method we can create a string 
		// representation of a date with the defined format.
		String reportDate = df.format(today);


		LoanRequest loan = new LoanRequest();
		loan.setLoantype(loanType);
		loan.setStatus("new");
		loan.setLoanDate(reportDate);
		loan.setCustomer(customer);
		loan.setBank(bank);
		loan.setDocuments(documentsList);

		loanRequestrService.addLoanRequest(loan);


		map.addAttribute("email",email);
		map.addAttribute("pswd",pswd);
		map.addAttribute("name",name);
		map.addAttribute("cid",customerIdentifier);

		return new ModelAndView("loanSuccess");
	}

	@RequestMapping(value = "/loanRequestList", method = RequestMethod.GET)
	public ModelAndView list()
	{
		ModelAndView model = new ModelAndView();
		model.setViewName("loanRequestList");
		List<LoanRequest> loanRequests = loanRequestrService.getAllLoanRequests();
		List<CustomerLoanRequest> clrs = new ArrayList<>();



		for(LoanRequest lr: loanRequests)
		{
			CustomerLoanRequest clr = new CustomerLoanRequest();
			List<String> dcmts = new ArrayList<>();
			List<Document> lstDoc = new ArrayList<>();

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

			clrs.add(clr);
		}

		model.addObject("loanList",clrs);



		return model;
	}

	@RequestMapping(value = "/loanAssign/{loanId}", method = RequestMethod.GET)
	public ModelAndView assign(@PathVariable ("loanId") Integer loanId)
	{
		ModelAndView model = new ModelAndView();
		model.setViewName("loanAssign");

		LoanRequest lr = loanRequestrService.getLoanRequestById(loanId);
		Customer cst = lr.getCustomer();
		String location = cst.getCustAddress();
		List<Employee> emps;
		List<Employee> empsAssignPickup = new ArrayList<>();
		List<Employee> empsAssignVerification = new ArrayList<>();
		List<Employee> empsAssignLegal = new ArrayList<>();

		emps = employeeService.getAllEmployees();
		String empDeptPickup ="PICKUP";
		String empDeptVerification ="VERIFICATION";
		String empDeptLegal ="LEGAL";
		int verifyDept = 0;

		for(Employee e:emps)
		{

			//if(e.getEmpDep().equalsIgnoreCase(empDeptPickup) && e.getEmpAddress().equals(location) && lr.getStatus().equals("new"))
			if(e.getEmpDep().equalsIgnoreCase(empDeptPickup) && lr.getStatus().equals("new"))
			{

				empsAssignPickup.add(e);
				verifyDept = 1;
			}

			if(e.getEmpDep().equalsIgnoreCase(empDeptVerification) && lr.getStatus().equals("uploaded"))
			{
				empsAssignVerification.add(e);
				verifyDept = 2;
			}
			if(e.getEmpDep().equalsIgnoreCase(empDeptLegal) && lr.getStatus().equals("verified"))
			{
				empsAssignLegal.add(e);
				verifyDept = 3;
			}

		}


		if(verifyDept==1)
		{
			model.addObject("empsAssign",empsAssignPickup);
		}

		if(verifyDept==2)
		{
			model.addObject("empsAssign",empsAssignVerification);
		}
		
		if(verifyDept==3)
		{
			model.addObject("empsAssign",empsAssignLegal);
		}

		model.addObject("loanRequest",lr);

		return model;

	}

	@RequestMapping("/loanPickUp/{empid}/{loanid}")
	public ModelAndView pickSuccess(@PathVariable("empid") int empid,@PathVariable("loanid") int loanid)
	{
		//ADD DATE HERE IN LOAN REQUEST TABLE
		// Create an instance of SimpleDateFormat used for formatting 
		// the string representation of date (month/day/year)
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

		// Get the date today using Calendar object.
		Date today = Calendar.getInstance().getTime();        
		// Using DateFormat format method we can create a string 
		// representation of a date with the defined format.
		String reportDate = df.format(today);


		LoanRequest lr = loanRequestrService.getLoanRequestById(loanid);
		
		

		loanRequestrService.updateLoanRequest(lr);
		LoanPickUpAssign lpa = new LoanPickUpAssign();
		lpa.setLoanId(loanid);
		lpa.setEmpId(empid);
		lpa.setDateAssign(reportDate);

		Employee emp = employeeService.getEmployeeById(empid);	
		
		if(emp.getEmpDep().equals("PICKUP"))
		{
			lr.setStatus("Assigned for pickup");
		}
		if(emp.getEmpDep().equals("VERIFICATION"))
		{
			lr.setStatus("Assigned for verification");
		}
		if(emp.getEmpDep().equals("LEGAL"))
		{
			lr.setStatus("Assigned for legal");
		}
		
		emp.setEmpWorkLoad(emp.getEmpWorkLoad()+1);
		
		employeeService.updateEmployee(emp);
		loanRequestrService.updateLoanRequest(lr);

		loanPickUpAssignService.addLoanPickUpAssign(lpa);

		String name=employeeService.getEmployeeById(empid).getEmpName();
		return new ModelAndView("pickupsuccess","msg","Loan Id: "+loanid+" Assigned to  Employee "+name);

	}

}
