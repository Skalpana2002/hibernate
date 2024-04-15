package com.OneToMany;



import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DisplayStudentFaculty {
	public static void main(String[] args)
	{
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
		EntityManager manager=factory.createEntityManager();
		
		Faculty f= manager.find(Faculty.class,1);
		System.out.println(f.getName()+" "+ f.getSubject());
		List<Student> Students = f.getStudents();
		for(Student s : Students)
		{
			System.out.println(s.getName()+" "+s.getPhone());
		}

}
}
