package com.deppon.test03.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Assert;
import org.junit.Test;

import com.deppon.test03.util.HibernateUtil;
import com.deppon.test03.util.Supplier;

public class ModelTest {
	
	@Test
	public void testGetSession() {
		Session session = HibernateUtil.getSession();
		
		Assert.assertNotNull(session);
		
		HibernateUtil.closeSession();
	}
	
	@Test
	public void testExport() {
		new SchemaExport(new Configuration().configure()).create(true , true);
	}
	
	@Test
	public void testSave() {
		Supplier person = new Supplier();
		person.setId("0000000000001");
		person.setName("路飞");
		
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		session.save(person);
		
		tx.commit();
		HibernateUtil.closeSession();
	}
	
	@Test
	public void testQuery() {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		
		@SuppressWarnings("unchecked")
		List<Supplier> personList = session.createQuery("select p from Supplier p").list();
		
		for(Supplier eachPerson : personList) {
			System.out.println(eachPerson);
		}
		
		session.getTransaction().commit();
		HibernateUtil.closeSession();
	}
	
}
