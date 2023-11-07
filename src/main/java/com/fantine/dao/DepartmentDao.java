package com.fantine.dao;

import java.util.List;
import com.fantine.model.Department;

public interface DepartmentDao {
	
	public List<Department> getAllDepartments();
	public Department getDepartmentById(int id);
	public void updateDepartment(Department department);
	public void addDepartment(Department department);
	public void deleteDepartment(int id);

}
