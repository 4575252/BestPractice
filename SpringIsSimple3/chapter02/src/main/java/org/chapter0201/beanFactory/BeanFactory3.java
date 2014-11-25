package org.chapter0201.beanFactory;

import java.io.IOException;

import org.chapter02.Car;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

@SuppressWarnings("deprecation")
public class BeanFactory3 {

	public Car getCarByBeanFactory(String path) throws IOException {
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		Resource res = resolver
				.getResource("classpath:"+path);
//		Resource res = resolver
//				.getResource("classpath:org/chapter0201/beanfactory/beans.xml");
		System.out.println(res.getURL());
		BeanFactory bf = new XmlBeanFactory(res);
		System.out.println("init BeanFactory.");

		Car car = bf.getBean("car", Car.class);
		return car;
	}

}
