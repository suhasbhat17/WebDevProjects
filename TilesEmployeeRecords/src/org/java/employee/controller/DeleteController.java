package org.java.employee.controller;

import org.java.employee.model.Employee;
import org.java.employee.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class DeleteController {
	
	@Autowired
	private EmpService serv;
	
	@RequestMapping("/delete")
	public String deleteEmpl(Model model){
		
		model.addAttribute("emp",new Employee());
		return "delete";
	}
	
	@RequestMapping("/doDelete")
	public String doDelete(Employee emp){
		serv.deleteService(emp.getId());
		return "deleteSuccess";
	}

	public void setServ(EmpService serv) {
		this.serv = serv;
	}
	
}
