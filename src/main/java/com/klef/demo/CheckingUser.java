package com.klef.demo;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.*;
public class CheckingUser 
{
	public boolean checkUser(String email, String password)
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Query qry2=session.createQuery("from Users where emailid=:v and password=:m");
		qry2.setParameter("v",email);
		qry2.setParameter("m", password);
		List<Users> list2=qry2.list();
		System.out.println("Total Records="+list2.size());
		if (list2.size() == 1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public List<Users> getUserObject(String email, String password)
	{

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Query qry2=session.createQuery("from Users where emailid=:v and password=:m");
		System.out.println(qry2);
		System.out.println("getuserobject method" + qry2.getClass());
		qry2.setParameter("v",email);
		qry2.setParameter("m", password);
		List<Users> list2=qry2.list();
		System.out.println(list2.get(0));
		return list2;
	}
	

}
