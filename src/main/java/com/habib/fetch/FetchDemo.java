package com.habib.fetch;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.habib.entity.Address;
import com.habib.entity.Student;

public class FetchDemo {
	public static void main(String[] args) {
		// get and load example
		
		Configuration cfg = new Configuration();
		cfg.configure("com/habib/cfgs/hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = factory.openSession();
		
//		// get-student 101
//		Student student = session.load(Student.class, 101);
//		
//		System.out.println(student);
//		
		// get-address 1
		Address address = session.load(Address.class, 1);
		
//		System.out.println(address);
		System.out.println(address.getStreet());
		
		factory.close();
	}
}
