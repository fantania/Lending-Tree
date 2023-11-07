package com.fantine.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.fantine.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{
	
	@Autowired
    private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }


	@Override
	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployees() {
		List<Employee> lst = getCurrentSession().createQuery("from Employee").list();
		
		return lst;
		
	}

	@Override
	public Employee getEmployeeById(int id) {
		Employee employee = (Employee) getCurrentSession().get(Employee.class, id);
        return employee;
	}

	@Override
	public void updateEmployee(Employee employee) {
		Employee employeeToUpdate = getEmployeeById(employee.getEmpId());
		employeeToUpdate.setEmpName(employee.getEmpName());
		employeeToUpdate.setEmpDep(employee.getEmpDep());
		employeeToUpdate.setEmpEmail(employee.getEmpEmail());
		employeeToUpdate.setEmpPhone(employee.getEmpPhone());
		employeeToUpdate.setEmpWorkLoad(employee.getEmpWorkLoad());
		employeeToUpdate.setEmpPswd(employee.getEmpPswd());
		employeeToUpdate.setEmpAddress(employee.getEmpAddress());
		employeeToUpdate.setEmpIdentifier(employee.getEmpIdentifier());
        getCurrentSession().update(employeeToUpdate);
		
	}

	@Override
	public void addEmployee(Employee employee) {
		getCurrentSession().save(employee);	
		
	}

	@Override
	public void deleteEmployee(int id) {
		Employee employee = getEmployeeById(id);
        if (employee != null)
            getCurrentSession().delete(employee);
	}

}
