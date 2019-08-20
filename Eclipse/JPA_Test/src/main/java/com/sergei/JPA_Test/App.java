package com.sergei.JPA_Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	Student stud = new Student(159,"Vano",87);
    	
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestPersistence"); // data from persistence.xml
        EntityManager em= emf.createEntityManager();
       
        
        em.getTransaction().begin();
        Student st = em.find(Student.class,159 );
        if(st==null) {       
          em.persist(stud);
        }else {
            st.setMarks(78);
        }
        em.getTransaction().commit();
        
        System.out.println(st);
        
       
    }
}
