package org.suhas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.suhas.dao.StudentDao;
import org.suhas.model.Student;
import org.suhas.service.StudentService;

@Controller
public class CreateController {

	@Autowired
	private StudentService studServ;

	@RequestMapping("/create")
	public String create(Model model) {

		model.addAttribute("stud", new Student());
		return "create";

	}

	@RequestMapping(value = "/doCreate", method = RequestMethod.POST)
	public String doCreate(Model model, @Valid Student stud, BindingResult result) {

		model.addAttribute("stud", new Student());
		if (result.hasErrors()) {
			System.out.println("Form not validated");
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError error : errors) {
				System.out.println(error.getDefaultMessage());
			}
			return "create";
		}

		studServ.createStudService(stud);
		return "createSuccess";
	}

}
