package org.chapter0203.javaConfig;

import static org.junit.Assert.*;

import org.chapter02.Car;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigBeanTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigBean.class);
		Service s = ctx.getBean(Service.class);
		assertNotNull(s);
	}

}
