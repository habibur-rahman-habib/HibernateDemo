package com.habib.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.habib.entity.*;

public class Test {

	public static void main(String[] args) throws IOException {
		
		Configuration cfg = new Configuration();
		cfg.configure("com/habib/cfgs/hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		// creating student
//		Student st = new Student();
//		st.setId(101);
//		st.setName("Habibullah Habib");
//		st.setCity("Dhaka");
//		
//		System.out.println(st);
//		
//		session.save(st);
		
		// Creating object of Address Class
		Address ad = new Address();
		ad.setStreet("street1");
		ad.setCity("DELHI");
		ad.setOpen(true);
		ad.setAddedDate(new Date(1));
		ad.setX(10);
		session.save(ad);
		
		// Reading image
		FileInputStream fis = new FileInputStream("src/main/java/com/habib/images/star.png");
		byte[] data = new byte[fis.available()];
		fis.read(data);
		ad.setImage(data);
		
		System.out.println(ad);
		
		tx.commit();
		session.close();
	}

}
