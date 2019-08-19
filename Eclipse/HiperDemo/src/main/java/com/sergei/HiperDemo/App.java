package com.sergei.HiperDemo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App {
	public static void main(String[] args) {

		// testAlien();

		// testStudentsAndLaptop();

		testCahe();
	}

	private static void testCahe() {

		Alien a = null;

		Configuration conf = new Configuration().configure().addAnnotatedClass(Alien.class);
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(conf.getProperties())
				.buildServiceRegistry();
		SessionFactory sesFactory = conf.buildSessionFactory(serviceRegistry);
//--------------------------------------------------------------------------------
		Session session1 = sesFactory.openSession();
		session1.beginTransaction();
		
		Query q1 = session1.createQuery("from Alien where aid = 110");
		q1.setCacheable(true);
		a = (Alien)q1.uniqueResult();
		//System.out.println("****** "+a);
		//a = (Alien) session1.get(Alien.class, 110);
		System.out.println(a);
		session1.getTransaction().commit();
		session1.close();
//--------------------------------------------------------------------------------------
		Session session2 = sesFactory.openSession();
		session2.beginTransaction();
		Query q2 = session2.createQuery("from Alien where aid = 110");
		q2.setCacheable(true);
		a = (Alien) q2.uniqueResult();
		//a = (Alien) session2.get(Alien.class, 110);
		System.out.println(a);

		session2.getTransaction().commit();
		session2.close();

	}

	private static void testStudentsAndLaptop() {

		Laptop dell = new Laptop();
		dell.setLid(101);
		dell.setLname("Dell");

		Laptop hp = new Laptop();
		hp.setLid(102);
		hp.setLname("HP");

		Student student = new Student();
		student.setRollno(1);
		student.setName("Navin");
		student.setMarks(50);
		student.getLaptop().add(dell);
		student.getLaptop().add(hp);

		dell.getStudent().add(student);
		hp.getStudent().add(student);

		Configuration conf = new Configuration().configure().addAnnotatedClass(Student.class)
				.addAnnotatedClass(Laptop.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
		SessionFactory sf = conf.buildSessionFactory(reg);
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		session.save(dell);
		session.save(hp);
		session.save(student);

		tx.commit();

	}

	private static void testAlien() {
//      Alien telisco = new Alien();
//      telisco.setAid(102);
//      telisco.setAname("Mudilo");
//      telisco.setColor("Blue");

		// for getting from database
		// Alien huisko = null;

		Alien slava = new Alien();
		AlienName name = new AlienName();
		name.setFname("Slava");
		name.setLname("Gabitov");
		name.setMname("Ivanovich");
		slava.setAid(110);
		slava.setColor("BLue");
		slava.setAname(name);

		Alien kosta = new Alien();
		name = new AlienName();
		name.setFname("Konstantin");
		name.setLname("Penzin");
		name.setMname("Petrovich");
		kosta.setAid(120);
		kosta.setColor("Green");
		kosta.setAname(name);

		Alien semen = new Alien();
		name = new AlienName();
		name.setFname("Semen");
		name.setLname("Semenov");
		name.setMname("Semenovich");
		semen.setAid(140);
		semen.setColor("Yellow");
		semen.setAname(name);

		// ****************************************************************************************************************
		Configuration conf = new Configuration().configure().addAnnotatedClass(Alien.class);

		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();

		SessionFactory sf = conf.buildSessionFactory(reg);

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		// session.save(telisco);
		// huisko =(Alien) session.get(Alien.class, 102);
		session.save(slava);
		session.save(kosta);
		session.save(semen);

		tx.commit();
		// ****************************************************************************************************************
		// System.out.println(huisko);

	}
}
