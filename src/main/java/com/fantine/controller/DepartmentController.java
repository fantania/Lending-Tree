package com.fantine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fantine.model.Department;
import com.fantine.service.DepartmentService;

@Controller
@RequestMapping(value = "/department")
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list()
	{
		ModelAndView model = new ModelAndView("department_list");
		List<Department> departmentList = departmentService.getAllDepartments();
		model.addObject("departmentList",departmentList);
		
		
		return model;
	}
	
	@RequestMapping(value = "/addDepartment", method = RequestMethod.GET)
	public ModelAndView addArticle()
	{
		ModelAndView model = new ModelAndView();
		Department department = new Department();
		model.addObject("departmentForm",department);
		model.setViewName("department_form");
		
		return model;
	}
	
	@RequestMapping(value="/edit/{depId}", method=RequestMethod.GET)
    public ModelAndView editTeamPage(@PathVariable Integer depId) {
        ModelAndView modelAndView = new ModelAndView("edit_department_form");
        Department department = departmentService.getDepartmentById(depId);
        modelAndView.addObject("departmentEdit",department);
        return modelAndView;
    }
	
	@RequestMapping(value = "/updateDepartment", method = RequestMethod.POST)
	public ModelAndView editBank(@ModelAttribute("departmentEdit") Department department)
	{
		
		departmentService.updateDepartment(department);
		ModelAndView model = new ModelAndView("redirect:/department/list");
		
		return model;
	}
	
	@RequestMapping(value = "/saveDepartment", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("departmentForm") Department department)
	{
		
		departmentService.addDepartment(department);
		ModelAndView model = new ModelAndView("redirect:/department/list");
	
		return model;
	}
	
	@RequestMapping(value = "/deleteDepartment/{depId}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable int depId)
	{
		
		departmentService.deleteDepartment(depId);
		ModelAndView model = new ModelAndView("redirect:/department/list");
	
		return model;
	}

}




