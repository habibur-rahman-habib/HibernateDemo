package com.habib.manytomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("com/habib/cfgs/hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		
		Employee e1 = new Employee();
		Employee e2 = new Employee();
		
		e1.setEid(255);
		e1.setName("Habibullah");
		
		e2.setEid(265);
		e2.setName("Sakibullah");
		
		Project p1 = new Project();
		Project p2 = new Project();
		
		p1.setPid(121251);
		p1.setProjectName("Library Management");
		
		p2.setPid(122152);
		p1.setProjectName("To do App");
		
		List<Employee> employees = new ArrayList<Employee>();
		List<Project> projects = new ArrayList<Project>();
		
		employees.add(e1);
		employees.add(e2);
		
		projects.add(p1);
		projects.add(p2);
		
		e1.setProjects(projects);
		
		p2.setEmployees(employees);
		
		session.save(e1);
		session.save(e2);
		
		session.save(p1);
		session.save(p2);
		
		tx.commit();
		session.close();
		factory.close();
	}

}
