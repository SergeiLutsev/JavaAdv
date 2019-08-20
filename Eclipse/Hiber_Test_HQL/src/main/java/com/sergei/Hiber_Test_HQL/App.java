package com.sergei.Hiber_Test_HQL;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import antlr.collections.impl.LList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	//workStudent();
    	workLaptop();
    	
    }

	private static void workLaptop() {
		
		Configuration conf = new Configuration().configure()
				.addAnnotatedClass(Laptop.class);
		ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
		SessionFactory sf = conf.buildSessionFactory(sr);
		Session sesion = sf.openSession();
		Transaction tr = sesion.beginTransaction();
//-----------------------------------------------------
	
		Query query=sesion.createQuery("from Laptop where lid=50");
		
		Laptop lp=(Laptop) query.uniqueResult();
		
		System.out.println(lp);
		
		sesion.delete(lp);
		
		
////////////////////////////////////////////////////////////		
		
		tr.commit();
		sesion.close();
		
	}

	private static void generateLaptope(Session sesion) {

			Random rnd = new Random();
			
			for(int i=1; i<=100; i++) {
				double price =((int)(rnd.nextInt(3000)+rnd.nextDouble())*100)/100.0;
				
				sesion.save(new Laptop(i, "LAp top #"+rnd.nextInt(10000), price));
			}
	}

	private static void workStudent() {
		Random rnd = new Random();

    	Configuration conf= new Configuration().configure()
    											.addAnnotatedClass(Student.class);
    	ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
		SessionFactory sf = conf.buildSessionFactory(sr);
    	Session session = sf.openSession();
    	session.beginTransaction();

    	//**************List result**************
    	Query q = session.createQuery("from Student where marks<=10");
    	List<Student> students = q.list();   
    	System.out.println("**************List result**************");
    	students.forEach(e->System.out.println(e));
    	
    	//***********UNIQ result************
    	q=session.createQuery("from Student where rollno=7");
    	Student stud=(Student) q.uniqueResult();
    	System.out.println("***********UNIQ result************");
    	System.out.println(stud);
    	
    	//***********how to use fields***********
    	q=session.createQuery("select rollno, name from Student where rollno=7");
    	Object[] st = (Object[]) q.uniqueResult();
    	System.out.println("***********how to use fields***********");
    	System.out.println(Arrays.toString(st));
    	
    	//************how to get list of field********
    	q = session.createQuery("select rollno, marks, name from Student where marks>=75");
    	List<Object[]> lstObj = q.list();
    	System.out.println("************how to get list of field********");
    	lstObj.forEach(e -> System.out.println(Arrays.toString(e)));
    	
    	//***********use varible******
    	int mk = 60;
    	
    	q=session.createQuery("select sum(marks) from Student where marks>=?");
    	q.setParameter(0, mk);
    	//  or
    	// q=session.createQuery("select sum(marks) from Student where marks>=:mkr");
    	// q.setParameter("mkr", mk);
    	Long sum = (Long) q.uniqueResult();
    	System.out.println("***********use varible******");
    	System.out.println("Summ of marks : "+sum);
    	
    	
    	//-------------------------------------------------------------------
    	//
    	//				SQL
    	//
    	//--------------------------------------------------------------------
    	
    	System.out.println("SQL query: ");
    	SQLQuery sqlQ = session.createSQLQuery("select * from student where marks>90");
    	sqlQ.addEntity(Student.class);
    	List<Student> lst = sqlQ.list();
    	lst.forEach(e->System.out.println(e));
    	
    	///   SQL fiekd
    	System.out.println("----------SQL field----------------");
    	SQLQuery sQuery = session.createSQLQuery("select name, marks from student where marks>88");
    	sQuery.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
    	List lstStud = sQuery.list();
    	
    	for(Object o: lstStud) {
    		Map m=(Map)o;
    		System.out.println("----------  "+m.get("name")+"   :   "+m.get("marks"));
    	}
    	
    	session.getTransaction().commit();
   
    	session.close();
		
	}
}
