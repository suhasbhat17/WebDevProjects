package org.java.employee.controller;

import javax.validation.Valid;

import org.java.employee.model.User;
import org.java.employee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@Autowired
	private UserService userServ;

	@RequestMapping("/loginform")
	public String loginForm() {
		return "loginform";
	}

	@RequestMapping("/createlogin")
	public String showLogin(Model model) {
		model.addAttribute("user", new User());
		return "createlogin";
	}

	@RequestMapping("/doSignUp")
	public String doSignUp(@Valid User user, BindingResult result) {
		
		if(result.hasErrors()){
			return "createlogin";
		}else{
			
		try {
			user.setAuthority("admin");
			user.setEnabled(true);
			userServ.createUserService(user);
		} catch (DataAccessException e) {
			e.getClass();
			result.rejectValue("username", "DuplicateKey.user.username");
		}
		}
		return "userSuccess";
	}
	
	@RequestMapping("/loggedout")
	public String showLogOut(){
		return "loggedout";
	}
}
