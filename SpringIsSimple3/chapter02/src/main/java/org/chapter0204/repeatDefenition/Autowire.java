package org.chapter0204.repeatDefenition;

import org.chapter02.Car;
import org.springframework.beans.factory.annotation.Autowired;

public class Autowire {
	@Autowired
	private Car car;
	public String getCarBrand(){
		return car.getBrand();
	}
}
