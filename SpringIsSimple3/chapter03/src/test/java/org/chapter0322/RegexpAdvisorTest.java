package org.chapter0322;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class RegexpAdvisorTest {
    private String configPath ="";
    private ApplicationContext ctx =null;

	@Before
	public void setUp() throws Exception {
        configPath = "conf/beans22.xml";
        ctx = new ClassPathXmlApplicationContext(configPath);
	}

	@Test
	public void test() {
		Waiter waiter = (Waiter)ctx.getBean("waiter");
		waiter.greetTo("John");
		waiter.serveTo("John");
	}

}
