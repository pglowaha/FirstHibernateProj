package com.pglowaha.learning.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pglowaha.learning.Address;
import com.pglowaha.learning.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		user.setUserName("First User");
		
		Address addr = new Address();
		addr.setStreet("Street name");
		addr.setCity("City nam");
		
		user.setAddress(addr);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		
		sessionFactory.close();
	}

}
