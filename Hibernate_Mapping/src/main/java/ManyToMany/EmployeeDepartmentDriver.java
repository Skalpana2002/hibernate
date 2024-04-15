package ManyToMany;

import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class EmployeeDepartmentDriver {
	
	public static void main(String[] args)
	{
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		
		
		Department d=new Department();
		d.setName("Account");
		
		Employee e=new Employee();
		e.setName("ram");
		e.setEmail("ram@gmail.com");
		
		Employee e1=new Employee();
		e1.setName("sam");
		e1.setEmail("sam@gmail.com");
		
		List<Employee> list = new ArrayList<Employee>();
		list.add(e);
		list.add(e1);

		//setting employee list to department
		d.setEmployee(list);
		
		//setting department to employee
		e.setDepartment(d);
		e1.setDepartment(d);
		
		transaction.begin();
		manager.persist(d);
	    manager.persist(e);
	    manager.persist(e1);
	    transaction.commit();
		

		
		
	}

}
