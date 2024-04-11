package com.jsp.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jspDTO.Hospital;

public class Create_Hospital {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction = manager.getTransaction();
	
	public void CreateHospital(Hospital hospital) {
		transaction.begin();
		manager.persist(hospital);
		transaction.commit();
		
	}
	
	public void updateHospitalName(int h_id, String newName) {
		System.out.println("Enter Hospital id");
		System.out.println("Enter hospital new name");
		Hospital hospital = manager.find(Hospital.class, h_id);
		if(hospital != null) {
			transaction.begin();
			hospital.setH_name(newName);
			manager.merge(hospital);
			System.out.println("The new Hospital name is "+hospital.getH_name());
			transaction.commit();
		}
		else {
			System.out.println("Hospital doesnot exist");
		}
		
	}
	
	public void removeHospital(int h_id) {
		System.out.println("Enter hospital id");
		Hospital hospital = manager.find(Hospital.class, h_id);
		
		if(hospital != null) {
			transaction.begin();
			manager.remove(hospital);
			System.out.println("hospital is removed");
			transaction.commit();
		}
		else {
			System.out.println("Hospital doses not exist");
		}
	}

	public void display_HospitalName(String h_name) {
		System.out.println("Enter Hospital name");
		Query q = manager.createQuery("select h from Hospital h where h_name=?1");
		q.setParameter(1, h_name);
		List<Hospital> hospitals = q.getResultList();
		
		for(Hospital h  :hospitals)
		{
			System.out.println(h.getH_id()+" "+h.getH_name()+" "+h.getH_city()+" "+h.getH_address());
			System.out.println("==============");
		}
	}
	
	public void display_Hospital() {
		Query q = manager.createQuery("select h from Hospital h ");
		List<Hospital> hospitals = q.getResultList();
		
		for(Hospital h  :hospitals)
		{
			System.out.println(h.getH_id()+" "+h.getH_name()+" "+h.getH_city()+" "+h.getH_address());
			System.out.println("==============");
		}
	}
}
