package com.Hibernet.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernetConnection {
	public static Session session=null;
	public static SessionFactory sessionFactory=null;
	static
	{	try{
			Configuration cfg=new Configuration();
			cfg.configure("hibernet.cfg.xml");
			sessionFactory=cfg.buildSessionFactory();
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static  void closeConnection(Session sessionobj)
	{
		sessionobj.close();
	}
	public static Session openConnection()
	{
		session=sessionFactory.openSession();
		return session;
		
	}
	public static void closeConnectSessionFactory()
	{
		sessionFactory.close();
		
	}
}
