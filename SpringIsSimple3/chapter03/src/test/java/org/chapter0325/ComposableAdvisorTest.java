package org.chapter0325;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ComposableAdvisorTest {
    private String configPath ="";
    private ApplicationContext ctx =null;

	@Before
	public void setUp() throws Exception {
        configPath = "conf/beans25.xml";
        ctx = new ClassPathXmlApplicationContext(configPath);
	}

	@Test
	public void test() {
		Waiter waiter = (Waiter) ctx.getBean("waiter");
		WaiterDelegate wd = new WaiterDelegate();
        wd.setWaiter(waiter);
		waiter.serveTo("Peter");
		waiter.greetTo("Peter");
		wd.service("Peter");
	}

}
