package Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InsertingEmployeeObject {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		Employee e= new Employee();
		e.setId(1);
		e.setName("rekha");
		e.setSalary(25000);
		e.setDesignation("SDE");
		
		transaction.begin();
		manager.persist(e);
		transaction.commit();
	}

}
