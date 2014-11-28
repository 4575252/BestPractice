package org.chapter0314;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;


public class TransactionManager implements MethodBeforeAdvice, AfterReturningAdvice, ThrowsAdvice {
    public void afterReturning(Object returnObj, Method method, Object[] args,
                               Object obj) throws Throwable {
        System.out.println("-----事务"+method.getName()+"开始------" + args[0]);
    }

    public void afterThrowing(Method method, Object[] args, Object target,
                              Exception ex) throws Throwable {
        System.out.println("-----"+method.getName()+"抛出错误------");
    }

	public void before(Method method, Object[] args, Object target)
			throws Throwable {
        System.out.println("-----事务"+method.getName()+"结束------" + args[0]);
	}
}
