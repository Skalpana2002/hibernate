package com.OneToOneAadhar;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DisplayAadharPerson {
	public static void main(String[] args)
	{
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
		EntityManager manager=factory.createEntityManager();
		
		System.out.println("Using person getting aadhar details:");
		Person p=manager.find(Person.class, 1);
		System.out.println(p.getP_id()+" "+p.getAddress());
		System.out.println(p.a.getA_number());
		
		
		System.out.println("Using aadhar getting person details:");
		Aadhar a=manager.find(Aadhar.class, 1);
		System.out.println(a.p.getP_name()+" "+a.p.getAddress());
		System.out.println(a.getA_number());
		
		

		}

}
