package org.java.employee.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.java.employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDao {
	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setJdbc(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	
//	CRUD Operations
	
//	Create
	public void createEmp(Employee emp){
		System.out.println(emp);
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(emp);
		jdbc.update("INSERT INTO employee(id,name,email,role) VALUES (:id,:name,:email,:role)", param);
	}
	
	
//	Read Records
	public List<Employee> readAll(){
		return jdbc.query("select * from employee", new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet rs, int resNum) throws SQLException {
				Employee emp = new Employee();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setEmail(rs.getString("email"));
				emp.setRole(rs.getString("role"));
				return emp;
			}
			
		});
	}
	
	public void updateEmp(Employee emp){
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(emp);
		jdbc.update("UPDATE employee SET name=:name, email=:email,role=:role WHERE id=:id", param);
	}
	
	public void deleteEmp(int id) {
		MapSqlParameterSource param = new MapSqlParameterSource("id", id);
		jdbc.update("DELETE FROM employee WHERE id = :id", param);
	}

}
