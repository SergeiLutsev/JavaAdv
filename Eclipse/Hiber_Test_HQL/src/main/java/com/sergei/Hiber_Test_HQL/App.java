package com.sergei.Hiber_Test_HQL;

import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	Random rnd = new Random();

    	Configuration conf= new Configuration().configure()
    											.addAnnotatedClass(Student.class);
    	ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
		SessionFactory sf = conf.buildSessionFactory(sr);
    	Session session = sf.openSession();
    	session.beginTransaction();
    
    	for(int i=1; i<=100; i++){
    		session.save(new Student(i, "Student #"+i, rnd.nextInt(100)+1));
    	}
    	
    	session.getTransaction().commit();
   
    	session.close();
    }
}
