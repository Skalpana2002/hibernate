package com.OneToMany;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class FacultyStudentDriver {
	public static void main(String[] args)
	{
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		
		
		Faculty f=new Faculty();
		f.setName("teja");
		f.setSubject("English");
		
		
		Student s=new Student();
		s.setName("dhanu");
		s.setPhone(9391593110l);
		
		Student s1=new Student();
		s1.setName("ram");
		s1.setPhone(7780472055l);
		
		List<Student> list = new ArrayList<Student>();
		list.add(s);
		list.add(s1);
		
		f.setStudents(list);
		
		//persist () can only accepts only one object but list is multiple objects
		transaction.begin();
		manager.persist(f);
	    manager.persist(s);
	    manager.persist(s1);
	    transaction.commit();
		
		

}
}
