package com.OneToOne;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class GetQuestionAnswer {
	
	public static void main(String[] args)
	{
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
		EntityManager manager=factory.createEntityManager();
		
		
		//accessing question table and answer table using question object
		Question q=manager.find(Question.class,1);
		if(q != null)
		{
			System.out.println(q.getQ_id());
			System.out.println(q.getQuestion_name());
			System.out.println(q.getAnswer().getAnswer_name());
		}
		else
		{
			System.out.println("Question is not found....");
		}
	}

}
