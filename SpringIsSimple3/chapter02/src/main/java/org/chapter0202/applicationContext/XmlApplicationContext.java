package org.chapter0202.applicationContext;

import org.chapter02.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class XmlApplicationContext {

	public Car getCarByClassPathXml(String path) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(path);
		Car car = ctx.getBean("car", Car.class);
		return car;
	}

	public Car getCarByClassPathXml2(String[] xmls) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(xmls);
		Car car = ctx.getBean("car", Car.class);
		return car;
	}

	public Car getCarByFileSystemXml(String path) {
		ApplicationContext ctx = new FileSystemXmlApplicationContext(path);
		Car car = ctx.getBean("car", Car.class);
		return car;
	}
}
