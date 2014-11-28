package org.chapter0332;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class PreGreetingAspect {
	@Before("execution(* greetTo(..))")
	public void beforeGreeting() {
		System.out.println("How are you");
	}
	@After("execution(* greetTo(..))")
	public void afterGreeting() {
		System.out.println("Good By！");
	}
}
