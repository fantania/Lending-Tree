package com.fantine.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fantine.dao.EmployeeDao;
import com.fantine.model.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
    private EmployeeDao employeeDao;

	@Override
	public List<Employee> getAllEmployees() {

		List<Employee> lst = employeeDao.getAllEmployees();
		return lst;
	}

	@Override
	public Employee getEmployeeById(int id) {
		Employee employee = employeeDao.getEmployeeById(id);
		return employee;
	}

	@Override
	public void updateEmployee(Employee employee) {
		
		employeeDao.updateEmployee(employee);
		
	}

	@Override
	public void addEmployee(Employee employee) {
		employeeDao.addEmployee(employee);
		
	}

	@Override
	public void deleteEmployee(int id) {
		employeeDao.deleteEmployee(id);
		
	}

}
