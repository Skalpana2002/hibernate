package Hibernate;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Establish_connection {
	public static void main(String[] args) {
		EntityManagerFactory  factory = Persistence.createEntityManagerFactory("dev");
		System.out.println(factory);
		System.out.println("connection established");
	}
}
