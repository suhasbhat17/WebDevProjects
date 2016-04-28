package org.suhas.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.suhas.model.Student;
import org.suhas.service.StudentService;

@Controller
public class ReadController {
	
	@Autowired
	private StudentService studServ;
	
	@RequestMapping("/read")
	public String readAll(Model model){
		List<Student> studList = studServ.readAllStudService();
		model.addAttribute("studs", studList);
		return "ReadAll";
	}
	
	@RequestMapping("/ReadOne")
		public String readOne(Model model){
			model.addAttribute("studId", new Student());
			return "ReadOne";
		}
	
	
	@RequestMapping("/doReadOne")
	public String readOne(HttpServletRequest req,Model model){
		String str = req.getParameter("id");
		int id = Integer.parseInt(str);
		Student stud = studServ.getStudByIdService(id);
		model.addAttribute("student", stud);
		return "readSuccess";
	}
}
