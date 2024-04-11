package Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdationEmployee {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		Employee e= manager.find(Employee.class, 1);
		if(e != null)
		{
			transaction.begin();
			e.setDesignation("hr");
			e.setSalary(20000);
			manager.merge(e);
			transaction.commit();
		}
		else
		{
			System.out.println("Employee is not present");
		}
	}

}
