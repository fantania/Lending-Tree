package com.fantine.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fantine.model.Document;
import com.fantine.model.Employee;
import com.fantine.model.LoanRequest;
import com.fantine.model.MyFileUpload;
import com.fantine.service.EmployeeService;
import com.fantine.service.LoanPickUpAssignService;
import com.fantine.service.LoanRequestService;

@Controller
public class MyFileUploadController {

	@Autowired
	LoanRequestService loanRequestrService;

	@Autowired
	EmployeeService employeeService;

	@Autowired
	LoanPickUpAssignService loanPickUpAssignService;

	@RequestMapping(value = "/upLoadDocs/{empid}/{loanid}", method = RequestMethod.GET)
	public ModelAndView myDisplayForm(@PathVariable("empid") int empid,@PathVariable("loanid") int loanid)
	{

		ModelAndView model = new ModelAndView();
		model.setViewName("uploadfile");

		Employee e = employeeService.getEmployeeById(empid);
		LoanRequest lr = loanRequestrService.getLoanRequestById(loanid);

		List<Document> lstDocs = new ArrayList<>();
		lstDocs = lr.getDocuments();

		//System.out.println("Employee: "+e);

		model.addObject("employee",e);
		model.addObject("loan",lr);
		model.addObject("listDocs",lstDocs);


		return model;
	}


	@RequestMapping(value = "/verifyLoan/{empid}/{loanid}", method = RequestMethod.GET)
	public ModelAndView verifyLoan(@PathVariable("empid") int empid,@PathVariable("loanid") int loanid)
	{

		ModelAndView model = new ModelAndView();
		model.setViewName("verifyfile");

		Employee e = employeeService.getEmployeeById(empid);
		LoanRequest lr = loanRequestrService.getLoanRequestById(loanid);

		List<Document> lstDocs = new ArrayList<>();
		lstDocs = lr.getDocuments();

		//System.out.println("Employee: "+e);

		model.addObject("employee",e);
		model.addObject("loan",lr);
		model.addObject("listDocs",lstDocs);


		return model;
	}


	@RequestMapping(value = "/legalLoan/{empid}/{loanid}", method = RequestMethod.GET)
	public ModelAndView legalLoan(@PathVariable("empid") int empid,@PathVariable("loanid") int loanid)
	{

		ModelAndView model = new ModelAndView();
		model.setViewName("legalfile");

		Employee e = employeeService.getEmployeeById(empid);
		LoanRequest lr = loanRequestrService.getLoanRequestById(loanid);

		List<Document> lstDocs = new ArrayList<>();
		lstDocs = lr.getDocuments();

		//System.out.println("Employee: "+e);

		model.addObject("employee",e);
		model.addObject("loan",lr);
		model.addObject("listDocs",lstDocs);


		return model;
	}

	@RequestMapping(value = "/savefiles", method = RequestMethod.POST)
	public String crunchifySave(
			@ModelAttribute("uploadForm") MyFileUpload uploadForm,
			Model map, HttpServletRequest request) throws IllegalStateException, IOException {


		int empId = Integer.parseInt(request.getParameter("empId"));
		int loanId = Integer.parseInt(request.getParameter("loanId"));
		//String loaded = request.getParameter("loaded");

		Employee e = employeeService.getEmployeeById(empId);
		e.setEmpWorkLoad(e.getEmpWorkLoad()-1);

		loanPickUpAssignService.deleteLoanPickUpAssign(loanId);

		employeeService.updateEmployee(e);

		/*LoanRequest loan = loanRequestrService.getLoanRequestById(loanId);
		if(loaded.equals("loaded"))
			loan.setStatus("uploaded");
		else 
			loan.setStatus("Missing Documents");
		loanRequestrService.updateLoanRequest(loan);*/
		
		LoanRequest loan = loanRequestrService.getLoanRequestById(loanId);
		
		loan.setStatus("uploaded");
		loanRequestrService.updateLoanRequest(loan);

		String saveDirectory = "D:\\LendingTreeProject\\LendingTreeFiles";

		List<MultipartFile> myFiles = uploadForm.getMyFiles();

		if(myFiles==null)
			System.out.println("My files list is empty!!!");

		List<String> fileNames = new ArrayList<String>();

		if (myFiles!=null && myFiles.size() > 0) {
			for (MultipartFile multipartFile : myFiles) {

				String fileName = multipartFile.getOriginalFilename();
				if (!"".equalsIgnoreCase(fileName)) {

					multipartFile
					.transferTo(new File(saveDirectory + fileName));
					fileNames.add(fileName);
				}
				else System.out.println("No such File Name!!!");
			}

		}
		else  System.out.println("List of Files is Empty!!!");


		map.addAttribute("files", fileNames);
		//map.addAttribute("loan",loan);
		return "uploadfilesuccess";
	}



	@RequestMapping(value = "/verifyfiles", method = RequestMethod.POST)
	public String verifyFiles(Model map, HttpServletRequest request) {


		int empId = Integer.parseInt(request.getParameter("empId"));
		int loanId = Integer.parseInt(request.getParameter("loanId"));
		//String verify = request.getParameter("verify");

		Employee e = employeeService.getEmployeeById(empId);
		e.setEmpWorkLoad(e.getEmpWorkLoad()-1);

		loanPickUpAssignService.deleteLoanPickUpAssign(loanId);

		employeeService.updateEmployee(e);

		LoanRequest loan = loanRequestrService.getLoanRequestById(loanId);
		//if(verify.equals("verified"))
			loan.setStatus("verified");
		/*else
			loan.setStatus("not clear");*/

		loanRequestrService.updateLoanRequest(loan);

		map.addAttribute("loan",loan);
		return "verifysuccess";
	}

	@RequestMapping(value = "/legalfiles", method = RequestMethod.POST)
	public String legalFiles(Model map, HttpServletRequest request) {


		int empId = Integer.parseInt(request.getParameter("empId"));
		int loanId = Integer.parseInt(request.getParameter("loanId"));
		//String legalverify = request.getParameter("legalverify");

		Employee e = employeeService.getEmployeeById(empId);
		e.setEmpWorkLoad(e.getEmpWorkLoad()-1);

		loanPickUpAssignService.deleteLoanPickUpAssign(loanId);

		employeeService.updateEmployee(e);

		LoanRequest loan = loanRequestrService.getLoanRequestById(loanId);
		//if(legalverify.equals("approved"))
			loan.setStatus("approved");
		/*else
			loan.setStatus("not approved");*/

		loanRequestrService.updateLoanRequest(loan);

		map.addAttribute("loan",loan);
		return "legalsuccess";
	}
}


