package com.sergei;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.sergei.entity.Factory;
import com.sergei.entity.Famely;
import com.sergei.entity.Role;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Role mama=new Role("Mama");
    	Role papa=new Role("Papa");
    	Role son=new Role("Son");
    	Role dother=new Role("Dother");
    	
    	
    	Famely irina = new Famely("Irina", mama);
    	Famely sergei = new Famely("Sergei",papa);
    	Famely vadim = new Famely("Vadim", son);
    	Famely anastasia = new Famely("Anastasia", dother);
    	
    	
    	
        SessionFactory sessionFactory=Factory.getFactory();
        Session session = sessionFactory.openSession();
        Transaction tr=session.beginTransaction();
       
        /*
        session.save(mama);
        session.save(papa);
        session.save(son);
        session.save(dother);
        
        session.save(irina);
        session.save(sergei);
        session.save(vadim);
        session.save(anastasia);
        */
        
      Query<Role> q=  session.createQuery("from Role",Role.class);
       
      List<Role> lst =  q.getResultList();
      
      lst.forEach(r->{
    	  System.out.println(r.getId()+" : "+r.getName());
    	Set<Famely> fm =  r.getFamely();
        fm.forEach(f->System.out.println( f.getId()+" "+f.getName()));
    	
      });
    
        
        tr.commit();
        session.close();
        
 
    }
}
