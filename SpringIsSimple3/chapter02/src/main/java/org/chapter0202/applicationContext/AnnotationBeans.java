package org.chapter0202.applicationContext;

import org.chapter02.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnnotationBeans {

    @Bean(name = "car")
    public Car buildCar() {
        Car car = new Car();
        car.setBrand("红旗CCC");
        car.setMaxSpeed(333);
        return car;
    }
}
