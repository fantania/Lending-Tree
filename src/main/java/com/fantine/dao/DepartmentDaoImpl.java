package com.fantine.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.fantine.model.Department;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {
	
	@Autowired
    private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

	@Override
	@SuppressWarnings("unchecked")
	public List<Department> getAllDepartments() {
		
		List<Department> lst = getCurrentSession().createQuery("from Department").list();
		
		return lst;
	}

	@Override
	public Department getDepartmentById(int id) {
		Department department = (Department) getCurrentSession().get(Department.class, id);
        return department;
	}

	@Override
	public void updateDepartment(Department department) {
		Department departmentToUpdate = getDepartmentById(department.getDepId());
		departmentToUpdate.setDepName(department.getDepName());
        getCurrentSession().update(departmentToUpdate);
		
	}

	@Override
	public void addDepartment(Department department) {
		getCurrentSession().save(department);	
		
	}

	@Override
	public void deleteDepartment(int id) {
		
		Department department = getDepartmentById(id);
        if (department != null)
            getCurrentSession().delete(department);
		
	}

}
