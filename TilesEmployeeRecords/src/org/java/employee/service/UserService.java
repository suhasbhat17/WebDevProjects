package org.java.employee.service;

import org.java.employee.dao.UserDao;
import org.java.employee.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void createUserService(User user){
		System.out.println("in serv" + user);
		userDao.createUser(user);
		System.out.println("in serv" + user);
	}
}