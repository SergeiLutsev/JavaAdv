package com.sergei.HibernateJPA_persistanseXML;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App {
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		
		Bank bank =new Bank("ScotiaBank");
		
		Cliet cl1=new Cliet("Tomas", bank);
		Cliet cl2=new Cliet("Jimmy", bank);
		Cliet cl3=new Cliet("Bob", bank);
		
		bank.getClients().add(cl1);
		bank.getClients().add(cl2);
		bank.getClients().add(cl3);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestJPA_Hibernate");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
//		em.persist(cl1);
//		em.persist(cl2);
//		em.persist(cl3);
//		
//		em.persist(bank);
		
		em.getTransaction().commit();

	}
}
