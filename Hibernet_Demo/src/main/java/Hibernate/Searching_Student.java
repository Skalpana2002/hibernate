package Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Searching_Student {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		
		Student s= manager.find(Student.class,1);
		
		if(s != null)
		{
			System.out.println(s.getName()+" "+s.getAddress());
		}
		else
		{
			System.out.println("Student is not present");
		}
	}
}
