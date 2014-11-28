package org.chapter0313;

import org.aopalliance.aop.Advice;
import org.chapter0312.NaiveWaiter;
import org.chapter0312.Waiter;
import org.junit.Before;
import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;

public class GreetingInterceptorTest {

    private Waiter target;
    private Advice advice;
    private ProxyFactory pf;
    
	@Before
	public void setUp() throws Exception {
        target = new NaiveWaiter();
        advice = new GreetingInterceptor();
        //①Spring提供的代理工厂
        pf = new ProxyFactory();
        // ②设置代理目标
        pf.setTarget(target);
        //③为代理目标添加增强
        pf.addAdvice(advice);
    
	}

	@Test
	public void test() {
        Waiter proxy = (Waiter) pf.getProxy();
        proxy.greetTo("John");
        proxy.serveTo("Tom");
    }

}
