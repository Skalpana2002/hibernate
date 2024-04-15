package com.OneToOne;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class QuestionPaperMain {
	
	public static void main(String[] args)
	{
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		
		
		//create a question
		Question q2=new Question();
		q2.setQ_id(1);
		q2.setQuestion_name("what is java?");
		
		//create a answer
		Answer a1=new Answer();
		a1.setA_id(121);
		a1.setAnswer_name("java is a programming language");
		
		
		
		//setting answer a1 to the question q1
		
		q2.setAnswer(a1);
		
		//storing all data to DB
		transaction.begin();
		manager.persist(q2);
		manager.persist(a1);
		transaction.commit();
		
		
		
	}

}
