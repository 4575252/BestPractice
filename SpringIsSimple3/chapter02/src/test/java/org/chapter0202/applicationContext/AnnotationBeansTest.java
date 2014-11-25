package org.chapter0202.applicationContext;

import static org.junit.Assert.*;

import org.chapter02.Car;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationBeansTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext("org.chapter0202.applicationContext");
		Car c = (Car) ctx.getBean("car");
		assertEquals(c.getBrand(), "红旗CCC");
	}

}
