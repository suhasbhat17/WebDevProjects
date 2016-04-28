package org.suhas.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.suhas.model.Student;
import org.suhas.service.StudentService;

@Controller
public class UpdateController {
	
	@Autowired
	private StudentService studServ;

	@RequestMapping("/update")
	public String update(Model model){
		
		model.addAttribute("stud", new Student());
		return "update";
	}
	
	@RequestMapping("/doUpdate")
	public String doUpdate(HttpServletRequest req){
		
		String idStr = req.getParameter("id");
		int id = Integer.parseInt(idStr);
		Student student = studServ.getStudByIdService(id);
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		
		student.setName(name);
		student.setEmail(email);
		
		studServ.updateStudentService(student);
		return "updateSuccess";
	}
	
}
