package com.fantine.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fantine.model.Department;
import com.fantine.model.Employee;
import com.fantine.model.IdGenerator;
import com.fantine.service.DepartmentService;
import com.fantine.service.EmployeeService;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	DepartmentService departmentService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list()
	{
		ModelAndView model = new ModelAndView("employee_list");
		List<Employee> employeeList = employeeService.getAllEmployees();
		model.addObject("employeeList",employeeList);
		
		
		return model;
	}
	
	@RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
	public ModelAndView addEmployee()
	{
		
		ModelAndView model = new ModelAndView();
		Employee employee = new Employee();
		
		model.addObject("employeeForm",employee);
		List<Department> lstDpt = departmentService.getAllDepartments();
		List<String> dptNames = new ArrayList<>();
		for (Department dpt : lstDpt) {
			dptNames.add(dpt.getDepName()); 		
		}
		model.addObject("dptNames",dptNames);
		model.setViewName("employee_form");
		
		return model;
	}
	
	@RequestMapping(value="/edit/{empId}", method=RequestMethod.GET)
    public ModelAndView editTeamPage(@PathVariable Integer empId) {
        ModelAndView modelAndView = new ModelAndView("edit_employee_form");
        Employee employee = employeeService.getEmployeeById(empId);
        modelAndView.addObject("employeeEdit",employee);
        List<Department> lstDpt = departmentService.getAllDepartments();
		List<String> dptNames = new ArrayList<>();
		for (Department dpt : lstDpt) {
			dptNames.add(dpt.getDepName()); 		
		}
		modelAndView.addObject("dptNames",dptNames);
        return modelAndView;
    }
	
	@RequestMapping(value = "/updateEmployee", method = RequestMethod.POST)
	public ModelAndView editEmployee(@ModelAttribute("employeeEdit") Employee employee)
	{
		
		employeeService.updateEmployee(employee);
		ModelAndView model = new ModelAndView("redirect:/employee/list");
		
		return model;
	}
	
	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("employeeForm") Employee employee)
	{
		
		
		String empIdentifier = IdGenerator.generateId();
		String empName = employee.getEmpName();
		String empEmail = employee.getEmpEmail();
		String empPswd = empName.substring(0, 2)+empEmail.substring(0, 2)+"2018";
		employee.setEmpIdentifier(empIdentifier);
		employee.setEmpPswd(empPswd);
		employeeService.addEmployee(employee);
		ModelAndView model = new ModelAndView("redirect:/employee/list");
	
		return model;
	}
	
	@RequestMapping(value = "/deleteEmployee/{empId}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable int empId)
	{
		
		employeeService.deleteEmployee(empId);
		ModelAndView model = new ModelAndView("redirect:/employee/list");
	
		return model;
	}


}



