package com.OneToOneAadhar;

import com.OneToOne.Question;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class PersonAadharDriver {
	
	public static void main(String[] args)
	{
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		
		//create person
		Person p1=new Person();
		//p1.setP_id(1);
		p1.setP_name("udaya");
		p1.setAddress("Nemalivaram");
		
		//create Aadhar
		Aadhar a1=new Aadhar();
		
		//a1.setA_id(121);
		a1.setA_number(62086318l);
		
		//setting person p1 to Aadhar a1
		
		p1.setA(a1);
		
		//setting Aadhar a1 to person p1
		a1.setP(p1);
		
		//storing all data to DB
				transaction.begin();
				manager.persist(p1);
				manager.persist(a1);
				transaction.commit();
				
		
		
	}

}
