package org.chapter0202.applicationContext;


import org.chapter02.Car;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("car")) {
            Car car = (Car) bean;
//            if (car.getColor() == null) {
            car.setColor("黑色");
            System.out.println("调用MyBeanPostProcessor.postProcessBeforeInitialization()，设置为默认"+car.getColor());
//            }
        }else{
        	System.err.println("调用MyBeanPostProcessor.postProcessBeforeInitialization()，但没有进入。");
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("car")) {
            Car car = (Car) bean;
            if (car.getMaxSpeed() >= 200) {
            	car.setMaxSpeed(200);
                System.out.println("调用MyBeanPostProcessor.postProcessAfterInitialization()，将maxSpeed调整为"+car.getMaxSpeed());
            }
        }else{
        	System.err.println("调用MyBeanPostProcessor.postProcessAfterInitialization()，但没有进入。");
        }
        return bean;
    }
}
