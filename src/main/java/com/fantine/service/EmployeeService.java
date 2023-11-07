package com.fantine.service;

import java.util.List;

import com.fantine.model.Employee;

public interface EmployeeService {
	public List<Employee> getAllEmployees();
	public Employee getEmployeeById(int id);
	public void updateEmployee(Employee employee);
	public void addEmployee(Employee employee);
	public void deleteEmployee(int id);

}
