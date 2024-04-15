package com.ManyToOne;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class PersonAccountDriver {
	
	public static void main(String[] args)
	{
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		
		
		PersonTable s= new PersonTable();
		s.setName("Teja");
		s.setPhno(9391593110l);
		
		BankAccount b=new BankAccount();
		b.setBname("SBI");
		b.setNumber(12345676788l);
		b.setS(s);
		
		
		BankAccount b1=new BankAccount();
		b1.setBname("ICICI");
		b1.setNumber(12345676788l);
		b1.setS(s);
		
		
		List<BankAccount> accounts = new ArrayList<BankAccount>();
		
		accounts.add(b);
		accounts.add(b1);
			
		s.setAccounts(accounts);
		transaction.begin();
	    manager.persist(b);
	    manager.persist(b1);
		manager.persist(s);
	    transaction.commit();
		
	}
}
