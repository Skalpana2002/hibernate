package Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdatingStudent {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		Student s= manager.find(Student.class,1);
		if(s != null)
		{
			transaction.begin();
			s.setAddress("banglore");
			s.setName("rohitha");
			manager.merge(s);
			transaction.commit();
		}
		else
		{
			System.out.println("Student is not present");
		}
	}

}
