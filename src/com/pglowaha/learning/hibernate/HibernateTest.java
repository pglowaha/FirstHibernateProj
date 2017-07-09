package com.pglowaha.learning.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pglowaha.learning.dto.Address;
import com.pglowaha.learning.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		user.setUserName("First User");
		
		Address addr = new Address();
		addr.setStreet("Street name");
		addr.setCity("City nam");
		
		user.setHomeAddress(addr);
		
		Address addr2 = new Address();
		addr2.setStreet("Second Street name");
		addr2.setCity("Second City nam");
		
		user.setOfficeAddress(addr2);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		
		sessionFactory.close();
	}

}
