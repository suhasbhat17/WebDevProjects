package org.suhas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.suhas.dao.StudentDao;
import org.suhas.model.Student;

@Service
public class StudentService {

	@Autowired
	private StudentDao studdao;

	@Transactional
	public void createStudService(Student stud) {
		studdao.create(stud);
	}
	
	@Transactional
	public List<Student> readAllStudService(){
		return studdao.readAllStudents();
	}
	
	@Transactional
	public void updateStudentService(Student stud){
		studdao.updateStudent(stud);
	}
	
	@Transactional
	public Student getStudByIdService(int id){
		System.out.println(id);
		return studdao.getStudentById(id);
	}
	
	@Transactional
	public void deleteStudentService(int id){
		 studdao.deleteStudent(id);
		System.out.println("success");
	}

}
