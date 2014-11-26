package org.chapter0204.repeatDefenition;

import static org.junit.Assert.*;

import org.chapter02.Car;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutowireTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext("org.chapter0204");
		Car c = (Car) ctx.getBean("car");
		assertEquals(c.getBrand(), "红旗CCC");
		System.err.println(ctx.getBeanDefinitionCount());
		for (String s : ctx.getBeanDefinitionNames()) {
			System.out.println(s);
		}
	}

}
