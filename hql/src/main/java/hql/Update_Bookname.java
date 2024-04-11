package hql;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Update_Bookname {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		System.out.println("enter Bookname : ");
		String  Bookname=sc.next();
		System.out.println("Enter Authorname");
		String Author= sc.next();
		System.out.println("enter price");
		int price = sc.nextInt();
		
		Query q = manager.createQuery("update Book b set b.author=?1, b.price=?2 where b.Bookname=?3 ");
		q.setParameter(1, Author);
		q.setParameter(2, price);
		q.setParameter(3, Bookname);
		
		transaction.begin();
		q.executeUpdate();
		transaction.commit();
	}

}
