package hql;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InsertingBook {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		Scanner sc= new Scanner(System.in);
		System.out.println("how many books you want to add ?");
		int ch = sc.nextInt();
		for(int i=1; i<=ch;i++)
		{
		System.out.println("enter the book name : ");
		String bookname= sc.next();
		System.out.println("enter the book price : ");
		int price= sc.nextInt();
		System.out.println("enter the author name : ");
		String Authorname= sc.next();
		
		Book book = new Book();
		book.setBookname(bookname);
		book.setPrice(price);
		book.setAuthor(Authorname);
		
		transaction.begin();
		manager.persist(book);
		transaction.commit();
		}
	}
}
