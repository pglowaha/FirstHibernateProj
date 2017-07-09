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
		addr.setPincode("12654");
		addr.setState("State First");
		
		Address addr2 = new Address();
		addr2.setStreet("Second Street name");
		addr2.setCity("Second City nam");
		addr2.setPincode("333333333");
		addr2.setState("State Secodn");
		
		user.getListOfAddresses().add(addr);
		user.getListOfAddresses().add(addr2);

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		
		user = null;
		
		session = sessionFactory.openSession();
		user = (UserDetails) session.get(UserDetails.class, 1);
		session.close();
		System.out.println(user.getListOfAddresses().size());
		sessionFactory.close();
	}

}
