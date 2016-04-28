package org.suhas.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.suhas.model.Student;



@Repository
@Transactional
public class StudentDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session session() {
		return sessionFactory.openSession();
	}
	
	@Transactional
	public void create(Student stud) {
		session().save(stud);
	}

	public List<Student> readAllStudents(){
		Query query = session().createQuery("from Student");
		return query.list();
	}
	
	/*public Student getStudentById(int id){
		System.out.println(id);
		Criteria criteria = session().createCriteria(Student.class);
		criteria.add(Restrictions.idEq(id));
		Student stud = (Student) criteria.uniqueResult();
		return stud;
	}*/
	
	public Student getById(int id){
		Criteria crit = session().createCriteria(Student.class);
		crit.add(Restrictions.idEq(id));
		Student stud = (Student) crit.uniqueResult();
		return stud;
		
	}
	
	public Student getStudentById(int id){
		Student stud = session().get(Student.class, id);
		return stud;
	}
	
	public void updateStudent(Student stud){
		System.out.println(stud);
		
		session().saveOrUpdate(stud);
		System.out.println(stud);
		
	}
	
	public void deleteStudent(int id){
		/*Student student = new  Student();
		student.setId(id);*/
		
		Query query = session().createQuery("delete from Student where id = :id");
		query.setInteger("id", id);
		query.executeUpdate();
		
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
