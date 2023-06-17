package com.hibernate.main;

import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.hibernate.model.Policy;
import com.hibernate.model.User;
import com.hibernate.util.HibernateAnnotationUtil;
/**
 * @author Jeevan
 */
public class HibernateOneToManyAnnotationMain {

	public static void main(String[] args) {

		User user = new User();
		
		Policy policy1 = new Policy("J10", "CarInsurance","DeActive", user);
		Policy policy2 = new Policy("J11", "HealthInsurance","DeActive", user);
		Set<Policy> policySet = new HashSet<Policy>();
		policySet.add(policy1); 
		policySet.add(policy2);
		user.setPolicy(policySet);
		user.setName("sandip");
		user.setEmail("sandip@gmail.com");
		
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try{
		//Get Session
		sessionFactory = HibernateAnnotationUtil.getSessionFactory();
		session = sessionFactory.getCurrentSession();
		System.out.println("Session created");
		//start transaction
		tx = session.beginTransaction();
		//Save the Model object
		session.save(user);
		session.save(policy1);
		session.save(policy2);
		//Commit transaction
		tx.commit();
		System.out.println("User ID="+user.getId());
		System.out.println("Policy1 ID="+policy1.getId()+", Foreign Key User ID="+policy1.getUser().getId());
		System.out.println("Policy2 ID="+policy2.getId()+", Foreign Key User ID="+policy1.getUser().getId());
		
		}catch(Exception e){
			System.out.println("Exception occured. "+e.getMessage());
			e.printStackTrace();
		}finally{
			if(!sessionFactory.isClosed()){
				System.out.println("Closing SessionFactory");
				sessionFactory.close();
			}
		}
	}

}
