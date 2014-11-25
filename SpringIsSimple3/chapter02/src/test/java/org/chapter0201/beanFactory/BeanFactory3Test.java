package org.chapter0201.beanFactory;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.chapter02.Car;
import org.chapter0201.beanFactory.BeanFactory3;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BeanFactory3Test {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		BeanFactory3 b = new BeanFactory3();
		try {
			Car car = b.getCarByBeanFactory("conf/01/beans.xml");
			assertEquals(car.getBrand(),"红旗CA72");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
