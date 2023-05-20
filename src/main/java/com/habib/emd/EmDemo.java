package com.habib.emd;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.habib.entity.Certificate;
import com.habib.entity.Student;

public class EmDemo {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("com/habib/cfgs/hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Student student1 = new Student();
		student1.setId(123);
		student1.setCity("Dhaka");
		student1.setName("Habibullah");
		student1.setCertificate(new Certificate("Android", "2 months"));
		
		Student student2 = new Student();
		student2.setId(135);
		student2.setCity("Dhaka");
		student2.setName("Habibullah");
		student2.setCertificate(new Certificate("Android", "2 months"));
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(student1);
		session.save(student2);
		
		tx.commit();
		factory.close();
		
		
	}
}
