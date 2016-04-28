package org.java.employee.controller;

import org.java.employee.model.Employee;
import org.java.employee.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UpdateController {

	@Autowired
	private EmpService serv;
	
	@RequestMapping("/update")
	public String updateEmpl(Model model){
		
		model.addAttribute("emp", new Employee());
		return "update";
		
	}
	
	@RequestMapping("/doUpdate")
	public String doUpdate(Employee emp){
		serv.updateService(emp);
		return "updateSuccess";
	}

	public void setServ(EmpService serv) {
		this.serv = serv;
	}
}
