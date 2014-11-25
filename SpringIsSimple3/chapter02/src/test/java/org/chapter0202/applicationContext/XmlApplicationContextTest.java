package org.chapter0202.applicationContext;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.chapter02.Car;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class XmlApplicationContextTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test1() {
		XmlApplicationContext x = new XmlApplicationContext();
		Car car = x.getCarByClassPathXml("conf/02/beans1.xml");
		assertEquals(car.getBrand(), "红旗CA73");
		assertNull(car.getColor());
		assertEquals(car.getMaxSpeed(), 400);
	}

	@Test
	public void test2() {
		XmlApplicationContext x = new XmlApplicationContext();
		Car car = x.getCarByClassPathXml2(new String[] { "conf/02/beans1.xml",
				"conf/02/beans2.xml" });
		assertEquals(car.getBrand(), "奇瑞QQ");
		assertEquals(car.getColor(), "黑色");
		assertEquals(car.getMaxSpeed(), 200);
	}

	@Test
	public void test3() {
		XmlApplicationContext x = new XmlApplicationContext();
		Car car = x.getCarByFileSystemXml("D:/github/BestPractice/SpringIsSimple3/chapter02/target/test-classes/conf/02/beans1.xml");
		assertEquals(car.getBrand(), "红旗CA73");
		assertNull(car.getColor());
		assertEquals(car.getMaxSpeed(), 400);
	}

	@Test
	public void test4() {
		XmlApplicationContext x = new XmlApplicationContext();
		Car car = x.getCarByFileSystemXml("target/test-classes/conf/02/beans1.xml");
		assertEquals(car.getBrand(), "红旗CA73");
		assertNull(car.getColor());
		assertEquals(car.getMaxSpeed(), 400);
	}

}
