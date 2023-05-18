package com.habib.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.habib.entity.*;

public class Test {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("com/habib/cfgs/hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		// creating student
		Student st = new Student();
		st.setId(101);
		st.setName("Habibullah Habib");
		st.setCity("Dhaka");
		
		System.out.println(st);
		
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();
		session.save(st);
		tx.commit();
		
		session.close();
	}

}
