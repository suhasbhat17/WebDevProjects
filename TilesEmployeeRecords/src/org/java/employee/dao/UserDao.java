package org.java.employee.dao;

import javax.sql.DataSource;

import org.java.employee.model.Employee;
import org.java.employee.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UserDao {
	
		private NamedParameterJdbcTemplate jdbc;

		@Autowired
		public void setJdbc(DataSource jdbc) {
			this.jdbc = new NamedParameterJdbcTemplate(jdbc);
		}
		
		@Transactional
		public boolean createUser(User user){
			System.out.println("in Dao" + user);
			BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(user);
			jdbc.update("INSERT INTO users(username, email, password,enabled) VALUES (:username,:email,:password,:enabled)", param);
			return jdbc.update("INSERT INTO authorities(username,authority) VALUES (:username,:authority)",param)==1;
		}

}
