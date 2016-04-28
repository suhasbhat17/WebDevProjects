package org.java.employee.controller;

import javax.validation.Valid;

import org.java.employee.model.Employee;
import org.java.employee.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CreateController {
	
	@Autowired
	private EmpService serv;

	@RequestMapping("/create")
	public String createEmployee(Model model) {
		
		model.addAttribute("emp", new Employee());
		return "create";
	}

	@RequestMapping("/doCreate")
	public String doCreate(Model model, Employee emp) {
			
		System.out.println(emp);
			serv.createService(emp);
			return "success";
	}

	public void setServ(EmpService serv) {
		this.serv = serv;
	}
}
