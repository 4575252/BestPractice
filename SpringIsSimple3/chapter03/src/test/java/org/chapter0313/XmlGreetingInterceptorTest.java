package org.chapter0313;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlGreetingInterceptorTest {

	@Test
	public void test() {
        String configPath = "conf/beans13.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        Waiter waiter = (Waiter) ctx.getBean("waiter");
        waiter.greetTo("John");
        waiter.greetTo("Tom");
    }


	@Test
	public void test2() {
        String configPath = "conf/beans13.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        Waiter waiter = (Waiter) ctx.getBean("waiter2");
        waiter.greetTo("John");
        waiter.greetTo("Tom");
    }

}
