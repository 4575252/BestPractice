package org.chapter0204.repeatDefenition;

import org.chapter02.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CarBeans {

    @Bean(name = "car")
    public Car buildCar() {
        Car car = new Car();
        car.setBrand("奇瑞qq");
        car.setMaxSpeed(333);
        return car;
    }
}
