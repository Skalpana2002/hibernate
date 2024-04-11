package Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Inserting_Object {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		Student s= new Student();
		s.setStudent_id(1);
		s.setName("Rekha");
		s.setAge(22);
		s.setAddress("Tirupati");
		
		transaction.begin();
		manager.persist(s);
		transaction.commit();

	}

}
