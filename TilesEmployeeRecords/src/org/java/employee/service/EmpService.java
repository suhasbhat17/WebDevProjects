package org.java.employee.service;

import java.util.List;

import org.java.employee.dao.EmployeeDao;
import org.java.employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpService {
	
	@Autowired
	private EmployeeDao empDao;

	public void setEmpDao(EmployeeDao empDao) {
		this.empDao = empDao;
	}
	
	
	public List<Employee> readService(){
		return  empDao.readAll();
	}
	
	public void createService(Employee emp){
		System.out.println(emp);
		empDao.createEmp(emp);

	}
	
	public void updateService(Employee emp){
		empDao.updateEmp(emp);
	}
	
	public void deleteService(int id){
		empDao.deleteEmp(id);
	}
	
	

}
