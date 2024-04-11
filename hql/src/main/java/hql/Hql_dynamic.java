package hql;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Hql_dynamic {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		System.out.println("enter price : ");
		int  price=sc.nextInt();
		Query q = manager.createQuery("select b from Book b where b.price=?1 ");
		q.setParameter(1, price);
		List<Book> books = q.getResultList();
		for(Book b :books)
		{
			System.out.println(b.getId()+" "+b.getBookname()+" "+b.getPrice()+" "+b.getAuthor());
			System.out.println("==============");
		}
	}

}
