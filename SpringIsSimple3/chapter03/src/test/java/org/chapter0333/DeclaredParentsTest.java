package org.chapter0333;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DeclaredParentsTest {
    private String configPath ="";
    private ApplicationContext ctx =null;


	@Before
	public void setUp() throws Exception {
        configPath = "conf/beans33.xml";
        ctx = new ClassPathXmlApplicationContext(configPath);
    }

	@Test
	public void test() {
		Waiter waiter = (Waiter)ctx.getBean("waiter");
		waiter.greetTo("John");
		Seller seller = (Seller)waiter;
		seller.sell("Beer", "John");
	}
}
