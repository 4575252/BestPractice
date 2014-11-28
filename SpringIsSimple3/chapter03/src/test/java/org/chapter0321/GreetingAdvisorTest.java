package org.chapter0321;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetingAdvisorTest {
    private String configPath ="";
    private ApplicationContext ctx =null;

	@Before
	public void setUp() throws Exception {
        configPath = "conf/beans21.xml";
        ctx = new ClassPathXmlApplicationContext(configPath);
	}

	@Test
	public void test() {
		Waiter waiter = (Waiter)ctx.getBean("waiter");
		Seller seller = (Seller)ctx.getBean("seller");
		waiter.greetTo("John");
		waiter.serveTo("John");
		seller.greetTo("John");	
	}

}
