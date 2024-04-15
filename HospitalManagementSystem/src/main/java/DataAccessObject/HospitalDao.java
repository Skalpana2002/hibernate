package DataAccessObject;

import java.util.List;

import DataTransforObject.Hospital;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;



public class HospitalDao {
	
	
			
		  EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
		  EntityManager manager=factory.createEntityManager();
		  EntityTransaction transaction=manager.getTransaction();
		
	
	public void createHospital(Hospital hospital)
	{
		
	
		transaction.begin();
		manager.persist(hospital);
		System.out.println(hospital.gethName()+"is updated");
		transaction.commit();
		
		
	}
	public void updateHospitalName(int id , String newName)
	{
		Hospital hospital1 = manager.find(Hospital.class,id);
		if(hospital1 != null)
		{
			transaction.begin();
			hospital1.sethName(newName);
			manager.merge(hospital1);
			System.out.println("HOspetal name updated successfully");
			transaction.commit();
			
		}
		else {
			System.out.println("Hospital name is not there");
		}
	}

	public void removeHospital(int id1)
	{
		Hospital hospital1 = manager.find(Hospital.class,id1);
		if(hospital1 != null)
		{
			transaction.begin();
	
			manager.remove(hospital1);
			System.out.println("HOspetal name removed successfully");
			transaction.commit();
			
		}
		else {
			System.out.println("Hospital does not exist");
		}
	}
	public void  viewHospitalByName(String name)
	{
		Query q=manager.createQuery("select h from Hospital h where h.name=?1");
		q.setParameter(1, name);
		List<Hospital> hospital1=q.getResultList();
		for(Hospital h:hospital1)
		{
			System.out.println(h.getHos_id());
			System.out.println(h.gethName());
			System.out.println(h.gethAddress());
			System.out.println(h.gethCity());

			
		}
	}
	
	public void viewallhospital()
	{
		Query q=manager.createQuery("select h from Hospital h");
		List<Hospital> hospitals=q.getResultList();
		for(Hospital h1:hospitals)
		{
			System.out.println(h1.getHos_id());
			System.out.println(h1.gethName());
			System.out.println(h1.gethAddress());
			System.out.println(h1.gethCity());

		}
	}


}

