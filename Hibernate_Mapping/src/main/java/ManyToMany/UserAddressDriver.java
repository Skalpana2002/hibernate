package ManyToMany;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class UserAddressDriver {
	public static void main(String[] args)
	{
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		
		
		//User
		User u=new User();
		u.setName("ram");
		u.setAge(18);
		
		User u1=new User();
		u1.setName("sam");
		u1.setAge(28);
		
		
		List<User> list = new ArrayList<User>();
		list.add(u);
		list.add(u1);
		
		//Addresses
		Address a=new Address();
		a.setCity("atp");
		a.setState("AP");
		
		Address a1=new Address();
		a1.setCity("kdp");
		a1.setState("AP");
		
		List<Address> list1=new ArrayList<Address>();
		list1.add(a);
		list1.add(a1);
		
		//setting address to user
		u.setAddresses(list1);
		u1.setAddresses(list1);
		
		//setting user to address
		
		a.setUsers(list);
		a1.setUsers(list);
		
		
		
		transaction.begin();
		manager.persist(u);
		manager.persist(u1);
	    manager.persist(a);
	    manager.persist(a1);
	    transaction.commit();
		
		
		
	}

}
