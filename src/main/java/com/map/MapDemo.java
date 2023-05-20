package com.map;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("com/habib/cfgs/hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		// Creating Question
		Question q1 = new Question();
		q1.setQuestionId(44);
		q1.setQuestion("What is java?");
		
		
		// creating answer
		Answer a1 = new Answer();
		a1.setAnswerId(21);
		a1.setAnswer("Hello");
		a1.setQuestion(q1);
		
		// creating answer
		Answer a2 = new Answer();
		a2.setAnswerId(41);
		a2.setAnswer("Hellolia");
		a2.setQuestion(q1);
		
		List<Answer> list = new ArrayList<Answer>();
		
		list.add(a1);
		list.add(a2);
		
		q1.setAnswers(list);
		
		// session
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		// save
		
		
		session.save(q1);
		session.save(a1);
		session.save(a2);
		
		tx.commit();
		
		// fetching...........
		Answer newQ = session.get(Answer.class, 41);
		System.out.println(newQ.getQuestion().getAnswers());
		
		session.close();
		factory.close();
	}
}
