package com.hibernate.main;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.model.Nominee;
import com.hibernate.model.User;
import com.hibernate.util.HibernateAnnotationUtil;
/**
 * @author Jeevan
*/
public class HibernateManyToManyAnnotationMain {

	public static void main(String[] args) {
		User user1 = new User();
		user1.setMobile("9589589856");
		user1.setName("shyam");
		
		User user2 = new User();
		user2.setMobile("8985898985");
		user2.setName("gopal");
		
		Set<User> set1 = new HashSet<User>();
		set1.add(user1); 
		set1.add(user2);
		
		Nominee nominee1 = new Nominee();
		nominee1.setName("Ram");	
		
		Nominee nominee2 = new Nominee();
		nominee2.setName("ajay");	
		
		Set<Nominee> set2= new HashSet<Nominee>();
		set2.add(nominee1);
		set2.add(nominee2);
		
		nominee1.setUser(set1);
		nominee2.setUser(set1);
		
		SessionFactory sessionFactory = null;
		try{
		sessionFactory = HibernateAnnotationUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(nominee1);
		session.save(nominee2);
		System.out.println("Before committing transaction");
		tx.commit();
		sessionFactory.close();
		
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(sessionFactory != null && !sessionFactory.isClosed()) sessionFactory.close();
		}
	}

}
