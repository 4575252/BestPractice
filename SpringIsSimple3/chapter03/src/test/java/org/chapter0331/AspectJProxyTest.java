package org.chapter0331;

import org.junit.Before;
import org.junit.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

public class AspectJProxyTest {
    AspectJProxyFactory factory =null;

	@Before
	public void setUp() throws Exception {
        Waiter target = new NaiveWaiter();
        factory = new AspectJProxyFactory();
        factory.setTarget(target);
        factory.addAspect(PreGreetingAspect.class);
    }

	@Test
	public void test() {
		Waiter proxy = factory.getProxy();
		proxy.greetTo("John");
		proxy.serveTo("John");
	}
}
