package org.tiwari;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateTest {
	public static void main(String[] args) {

		System.out.println("test of hibernate..");
		Configuration cfg = new Configuration();
		cfg.configure("org/tiwari/hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tr = session.beginTransaction();
		Query que = session.createQuery("insert into Item(id,name)select p.pid,p.name from Product p "
				+ "where p.pid=:pid");
		que.setParameter("pid", 8);
		que.executeUpdate();
		//Transaction tr = session.beginTransaction();
		tr.commit();
		// comment
		System.out.println("program end");

	}

 }
/*
 * Query qur =session.createQuery("update Product p set p.name=? where p.id =?");
		qur.setParameter(0, "Rajesh Tiwari");
		qur.setParameter(1, 8);
		int  i = qur.executeUpdate();
		/*Transaction tr = session.beginTransaction();
		tr.commit();
		System.out.println("no of record updated"+ i);
		/*Iterator<?> itr = l.iterator();
		while(itr.hasNext()){
			Integer p = (Integer)itr.next();
			System.out.println(p);
			
		}*/
 
