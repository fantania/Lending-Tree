package com.fantine.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fantine.dao.DepartmentDao;
import com.fantine.model.Department;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
    private DepartmentDao departmentDao;

	@Override
	public List<Department> getAllDepartments() {
		List<Department> lst = departmentDao.getAllDepartments();

		return lst;
	}

	@Override
	public Department getDepartmentById(int id) {
		Department department = departmentDao.getDepartmentById(id);
		return department;
	}

	@Override
	public void updateDepartment(Department department) {
		departmentDao.updateDepartment(department);
		
	}

	@Override
	public void addDepartment(Department department) {
		
		departmentDao.addDepartment(department);
	}

	@Override
	public void deleteDepartment(int id) {
		departmentDao.deleteDepartment(id);
		
	}
	
	

}
