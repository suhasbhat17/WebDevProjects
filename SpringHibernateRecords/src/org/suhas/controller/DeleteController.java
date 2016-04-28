package org.suhas.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.suhas.model.Student;
import org.suhas.service.StudentService;

@Controller
public class DeleteController {
	
	@Autowired
	private StudentService studServ;
	
	@RequestMapping("/delete")
	public String delete(Model model){
		model.addAttribute("stud", new Student());
		return "delete";
	}
	
	@RequestMapping("/doDelete")
	public String doDelete(HttpServletRequest req){
		String str = req.getParameter("id");
		int id = Integer.parseInt(str);
		studServ.deleteStudentService(id);
		return "deleteSuccess";
	}
	
}
