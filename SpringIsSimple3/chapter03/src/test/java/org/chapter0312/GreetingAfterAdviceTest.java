package org.chapter0312;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.aop.AfterAdvice;
import org.springframework.aop.framework.ProxyFactory;

public class GreetingAfterAdviceTest {

    private Waiter target;
    private AfterAdvice advice;
    private ProxyFactory pf;
    
	@Before
	public void setUp() throws Exception {
        target = new NaiveWaiter();
        advice = new GreetingAfterAdvice();
        //①Spring提供的代理工厂
        pf = new ProxyFactory();
        // ②设置代理目标
        pf.setTarget(target);
        //③为代理目标添加增强
        pf.addAdvice(advice);
    
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
        Waiter proxy = (Waiter) pf.getProxy();
        proxy.greetTo("John");
        proxy.serveTo("Tom");
    }

}
