package com.pglowaha.learning.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pglowaha.learning.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDetails user = new UserDetails();
		user.setUserId(1);
		user.setUserName("First User");
		user.setAddress("First users's address");
		user.setJoinedDate(new Date());
		user.setDescription("Description of user goes here");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		
		user = null;
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		user = (UserDetails) session.get(UserDetails.class, 1);
		System.out.println("User Name retrieved is " + user.getUserName());
		
		System.exit(0);
	}

}
