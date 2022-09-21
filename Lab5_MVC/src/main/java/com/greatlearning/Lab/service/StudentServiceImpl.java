package com.greatlearning.Lab.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.greatlearning.Lab.entity.Student;

@Repository
public class StudentServiceImpl implements StudentService{

	private SessionFactory sessionFactory;

	// create session
	private Session session;
	@Autowired
	StudentServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}

	}

	@Transactional
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		Transaction tx = session.beginTransaction();

		// find all the records from the database table
		List<Student> students = session.createQuery("from Student").list();

		tx.commit();

		return students;
	}

	@Transactional
	public Student findById(int theId) {
		// TODO Auto-generated method stub
		Student student = new Student();
		Transaction tx = session.beginTransaction();

		// find record with Id from the database table
		student = session.get(Student.class, theId);

		tx.commit();

		return student;
	}

	@Transactional
	public void save(Student theStudent) {
		// TODO Auto-generated method stub
		Transaction tx = session.beginTransaction();

		// save transaction
		session.saveOrUpdate(theStudent);

		tx.commit();
		
	}

	@Transactional
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		Transaction tx = session.beginTransaction();

		// get transaction
		Student student = session.get(Student.class, theId);

		// delete record
		session.delete(student);

		tx.commit();
		
	}

	@Transactional
	public void print(List<Student> students) {

		for (Student s : students) {
			System.out.println(s);
		}
	}

}
