package com.sergei.HiberDemo_test_1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       
//    	Laptop dell=new Laptop();
//    	dell.setLid(101);
//    	dell.setBrand("DELL");
//    	dell.setPrice(830);
//    	
//    	Laptop assus=new Laptop();
//    	assus.setLid(102);
//    	assus.setBrand("Assus");
//    	assus.setPrice(1000);
//    	
//    	Laptop samsung=new Laptop();
//    	samsung.setLid(103);
//    	samsung.setBrand("Samsung");
//    	samsung.setPrice(1000);
//    	
//    	Laptop apple=new Laptop();
//    	apple.setLid(104);
//    	apple.setBrand("Apple");
//    	apple.setPrice(2500);
//    	
//    	Laptop ascer=new Laptop();
//    	ascer.setLid(105);
//    	ascer.setBrand("Ascer");
//    	ascer.setPrice(1200);
//    	
//    	
//    	Alien al1=new Alien();
//    	al1.setAid(1);
//    	al1.setAname("Navin");
//    	al1.getLaptop().add(dell);
//    	al1.getLaptop().add(assus);
//    	al1.getLaptop().add(samsung);
//    	
//    	dell.setAlien(al1);
//    	assus.setAlien(al1);
//    	samsung.setAlien(al1);
//    	
//    	Alien al2=new Alien();
//    	al2.setAid(2);
//    	al2.setAname("Rahul");
//    	al2.getLaptop().add(dell);
//    	
//    	Alien al3=new Alien();
//    	al3.setAid(3);
//    	al3.setAname("Manyak");
//    	al3.getLaptop().add(apple);
//    	al3.getLaptop().add(ascer);
//    	
//    	ascer.setAlien(al3);
//    	apple.setAlien(al3);
    	
    	// connect o db
    	Configuration conf = new Configuration().configure()
    											.addAnnotatedClass(Alien.class)
    											.addAnnotatedClass(Laptop.class);
    	SessionFactory sf=conf.buildSessionFactory();
    	Session session = sf.openSession();
    	session.beginTransaction();
    	
//    	session.save(al1);
//    	session.save(al2);
//    	session.save(al3);
//    	
//    	session.save(dell);
//    	session.save(assus);
//    	session.save(ascer);
//    	session.save(apple);
//    	session.save(samsung);
    	
	Alien a1 = (Alien)session.get(Alien.class, 1);
    	
    	System.out.println(a1.getAname());
    	//a1.getLaptop().forEach(e -> System.out.println(e));
    	
    	session.getTransaction().commit();
    	
    	
    
    	
    	
    	
    }
}
