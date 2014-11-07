package com.webFrame.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.webFrame.bean.User;

public class SpringTest {
	private static ApplicationContext ac;

	@BeforeClass
	public static void testAc() {
		ac = new ClassPathXmlApplicationContext(new String[] {
				"classpath:spring.xml", "classpath:spring-hibernate.xml" });
	}

	// 测试sessionFactory
	@Test
	public void testSessionFactory() {
		SessionFactory sessionFactory = (SessionFactory) ac
				.getBean("sessionFactory");
		System.out.println(sessionFactory);
	}

	// 测试事务
	@Test
	public void testTransaction() {
		SessionFactory sessionFactory = (SessionFactory) ac
				.getBean("sessionFactory");
		// 获取或打开session
		Session session = sessionFactory.openSession();
		// 开启事务处理
		Transaction ts = session.beginTransaction();
		User u = new User();
		u.setId(null);
		u.setName("小明");
		session.save(u);
		ts.commit();
		session.cancelQuery();
	}
	
}
