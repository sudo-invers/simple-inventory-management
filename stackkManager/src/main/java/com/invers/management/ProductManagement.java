package com.invers.management;


import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class ProductManagement {
	
	public static void register() {
		
		Scanner scan = new Scanner(System.in);
		
		String name;
		
		System.out.println("product register.\n\n");
		
		System.out.println("enter the product name . 0 for exit");
		name = scan.nextLine();
		if (name.equals("0")) {
			
			System.out.println("exited with success");
			scan.close();
				return;
			
		}
		
		name.toLowerCase();
		//the name and the today date and time, is seated automatically;
		Product product = new Product();
		product.setProductName(name);
		
		//register effectively the item in the database
		try (SessionFactory factory = new Configuration().addAnnotatedClass(com.invers.management.Product.class).configure().buildSessionFactory()) {
			
			Session session = factory.openSession();
			
			session.persist(product);
			Transaction transaction = session.beginTransaction();
			
			transaction.commit();
			
		}
		finally {
			scan.close();		
			
		}
		
		
	}
	
	public static void remove() {
		
	Scanner scan = new Scanner(System.in);
		
		String name;
		
		System.out.println("product delete.\n\n");
		
		System.out.println("enter the product name for delete. 0 for exit");
		name = scan.nextLine();

		if (name.equals("0")) {
			
			System.out.println("exited with success");
			scan.close();
				return;
			
		}
		name.toLowerCase();
		
		
		try (SessionFactory factory = new Configuration().addAnnotatedClass(com.invers.management.Product.class).configure().buildSessionFactory()) {
			
			Session session = factory.openSession();
			
			Query <?> query = session.createQuery("DELETE FROM product where ", String.class);
			query.executeUpdate();			
			System.out.println("removed = >>>  " + query);
		} finally {
			scan.close();
		}
		
		
		
	}
	
	public static void listAll() {
		
		try (SessionFactory factory = new Configuration().addAnnotatedClass(com.invers.management.Product.class).configure().buildSessionFactory()) {
			
			Session session = factory.openSession();
			
			Query <Product> query = session.createQuery("FROM Product", Product.class);
			List <Product> product = query.list();			
			
			for (Product s : product) {
				
				System.out.println(s);
				
			}
		}
		
	}
	
	public static void searchByName () {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("what name do you wanna search? ");
		
		String name = scan.nextLine();
		
			try (SessionFactory factory = new Configuration().addAnnotatedClass(com.invers.management.Product.class).configure().buildSessionFactory()) {
			
			Session session = factory.openSession();
			
			System.out.println(session.createSelectionQuery("WHERE productName like :name order by productDate", Product.class)
			.setParameter("name", name)
			.setMaxResults(100)
			.getResultList());
			
		}
		finally {
			scan.close();
		}
		
	}

}
