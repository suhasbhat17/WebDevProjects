package org.java.employee.controller;

import java.util.List;

import org.java.employee.dao.EmployeeDao;
import org.java.employee.model.Employee;
import org.java.employee.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReadController {
	
	@Autowired
	private EmpService eserv;

	@RequestMapping("/read")
	public String showEmps(Model model){
		
		List<Employee> emp = eserv.readService();
		System.out.println(emp);
		model.addAttribute("employee", emp);
		return "read";
	}

	public void setEserv(EmpService eserv) {
		this.eserv = eserv;
	}

	
	
}
