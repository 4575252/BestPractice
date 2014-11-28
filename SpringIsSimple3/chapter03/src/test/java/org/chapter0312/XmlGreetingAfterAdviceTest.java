package org.chapter0312;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlGreetingAfterAdviceTest {
	@Test
	public void test() {
        String configPath = "conf/beans12.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        Waiter waiter = (Waiter) ctx.getBean("waiter");
        waiter.greetTo("John");
        waiter.greetTo("Tom");
    }

}
