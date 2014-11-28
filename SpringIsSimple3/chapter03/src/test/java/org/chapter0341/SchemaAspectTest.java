package org.chapter0341;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SchemaAspectTest {
    private String configPath ="";
    private ApplicationContext ctx =null;


	@Before
	public void setUp() throws Exception {
        configPath = "conf/beans41.xml";
        ctx = new ClassPathXmlApplicationContext(configPath);
    }

	@Test
	public void test() {
		Waiter naiveWaiter = (Waiter) ctx.getBean("naiveWaiter");
		Waiter naughtyWaiter = (Waiter) ctx.getBean("naughtyWaiter");	
		Seller seller = (Seller) ctx.getBean("seller");
		naiveWaiter.greetTo("John");
		naughtyWaiter.greetTo("Tom");
		
		//后置增强
		((SmartSeller)seller).sell("Beer","John");
		
		//环境增强
		naiveWaiter.serveTo("John");
		
//		//抛出异常增强
//		((SmartSeller)seller).checkBill(1);
		
		//final增强
		naiveWaiter.greetTo("John");
		
		//引入增强
		((Seller)naiveWaiter).sell("Beer","John");
		((NaiveWaiter)naiveWaiter).smile("John", 2);
		
		//advisor
		naiveWaiter.greetTo("John");
		
	}
}
