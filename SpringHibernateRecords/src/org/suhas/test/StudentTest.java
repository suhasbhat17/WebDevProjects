package org.suhas.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.suhas.dao.StudentDao;
import org.suhas.model.Student;
import org.suhas.service.StudentService;

public class StudentTest {
	
	
	private static StudentService studServ = new StudentService();
	private static StudentDao studDao = new StudentDao();

	public static void main(String[] args){
		System.out.println("hello");
		int id = 3;
		Student stud = studDao.getStudentById(id);
		System.out.println(stud);
	}
}
