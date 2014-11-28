# 【Spring 3.0 就这么简单】 第3章 要点
* aop多样增强方式介绍
* 切点PointCut编程介绍
* 基于@AspectJ配置切面，需项目支持jdk5.0
* 基于schema配置切面，项目不支持jdk5.0时使用

## 1.aop多样增强方式介绍
* 前置增强
* 后置增强
* 环绕增强
* 异常增强
###	1.1 前置增强
		使用ProxyFactory填充目标类，再引入增强，但目标类被执行时增强自动触发（本例子全切面触发）,使用MethodBeforeAdvice接口
		Waiter target;
		BeforeAdvice advice;
		ProxyFactory pf;
        target = new NaiveWaiter();
        advice = new GreetingBeforeAdvice();
        //①Spring提供的代理工厂
        pf = new ProxyFactory();
        // ②设置代理目标
        pf.setTarget(target);
        //③为代理目标添加增强
        pf.addAdvice(advice);
    
        Waiter proxy = (Waiter) pf.getProxy();
        proxy.greetTo("John");
        proxy.serveTo("Tom");
###	1.2 后置增强
		测试同1.1，使用AfterReturningAdvice接口
		xml运行效果相同
		
### 1.3 环融增强
		测试同1.1，使用MethodInterceptor接口
		xml运行效果相同，并测试了1.1和1.2的组合与环绕测试效果相同
		
### 1.3 异常增强
		测试代码和效果没什么特别的，不过一个异常增强类如果同时实现前后置增强，则处理顺序会有问题，可在xml中使用多个独立的增强类或仅使用环绕增强再强化异常捕捉处理
		spring4.0以后有专门的事务控制注解
        
## 2.切点PointCut编程介绍
* spring支持静态方法匹配器和动态方法匹配器
* 共有六种切点类型

### 2.1 静态方法切点
		通过继承StaticMethodMatcherPointcutAdvisor使用classFilter和matches方法定位具体的方法并进行增强
		
		public class GreetingAdvisor extends StaticMethodMatcherPointcutAdvisor {
		
			private static final long serialVersionUID = 1L;
		
			public boolean matches(Method method, Class<?> clazz) {
		        return "greetTo".equals(method.getName());
		    }
		
		    public ClassFilter getClassFilter() {
		        return new ClassFilter() {
		            public boolean matches(Class<?> clazz) {
		                return Waiter.class.isAssignableFrom(clazz);
		            }
		        };
		    }
		}
### 2.2 正则表达式切点
		主要在于xml配置，代码量相对2.1较少,省去匹配器的java开发
		<!-- 正则表达式方法名匹配切面 -->
		<bean id="regexpAdvisor"
			class="org.springframework.aop.support.RegexpMethodPointcutAdvisor"
			p:advice-ref="greetingAdvice">
			<property name="patterns">
				<list>
					<value>.*greet.*</value>
				</list>
			</property>
		</bean>
		<bean id="waiter" class="org.springframework.aop.framework.ProxyFactoryBean"
			p:interceptorNames="regexpAdvisor" p:target-ref="waiterTarget"
			p:proxyTargetClass="true" />
### 2.3 动态方法切点
		通过继承DynamicMethodMatcherPointcut使用classFilter和matches方法定位具体的方法并进行增强
		
### 2.4 控制流程切点
		配置ControlFlowPointcut的实现类和方法，当该类被激活使用时触发
		
### 2.5 复合切点
		使用默认的切点配置，配合表达式定位和java复合切点进行增强
		<bean id="composableAdvisor" class="org.springframework.aop.support.DefaultPointcutAdvisor"
			p:pointcut="#{gcp.intersectionPointcut}" p:advice-ref="greetingAdvice" />
		public Pointcut getIntersectionPointcut() {
		    ComposablePointcut cp = new ComposablePointcut();
		    Pointcut pt1 = new ControlFlowPointcut(WaiterDelegate.class, "service");
		    NameMatchMethodPointcut pt2 = new NameMatchMethodPointcut();
		    pt2.addMethodName("greetTo");
		    return cp.intersection(pt1).intersection((Pointcut) pt2);
		}

### 2.6 引介切点
		使用DefaultIntroductionAdvisor引介增强处理，配合多线程和静态记录器，统计函数执行效率（时间）
		
## 3.基于@AspectJ配置切面
注：使用AspectJ的难点主要在于aop表达式的编写～
* 简单例子（纯注解+代理工厂)
* 简单例子（注解+Xml自动代理)
* 无继承关系的父类增强转换
* 复合使用、多种注解使用

### 3.1 简单例子（纯注解+代理)
		通过纯注解、代理工厂类和绑定类类型的方式来进行切点增强
		
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
### 3.2 简单例子（注解+Xml自动代理)
注解使用同3.1，本例的注解主要在于使用@Before和@After对方法是用前后的增强，并且使用aop表达式进行切点增强
xml配置
		<aop:aspectj-autoproxy/>
		<bean id="waiter" class="org.chapter0332.NaiveWaiter" />
		<bean class="org.chapter0332.PreGreetingAspect" />

java调用
		@Before
		public void setUp() throws Exception {
		    configPath = "conf/beans32.xml";
		    ctx = new ClassPathXmlApplicationContext(configPath);
		}
		
		@Test
		public void test() {
			Waiter waiter = (Waiter)ctx.getBean("waiter");
			waiter.greetTo("John");
			waiter.serveTo("John");
			waiter.toString();
### 3.3 无继承关系的父类增强转换
xml自动代理配置同3.2 不再赘述
切面增强如下，增强了继承关系，试过将NaiveWaiter换成Waiter发现不能多层继承，只能直接/单级集成，该场景估计会适用于一些适配器的使用
		@Aspect
		public class EnableSellerAspect {
		   @DeclareParents(value="org.chapter0333.NaiveWaiter",
				   defaultImpl=SmartSeller.class)
		   public  Seller seller;
		}
### 3.4 复合使用、多种注解使用
因文章没有具体介绍，代码有多种实例，这里不做练习，待找到其他合适的书籍再做实验。
   
## 4.基于schema配置切面
通过xml配置，将之上大部分的测试进行了配置，详见xml配置

## 小结
		横切编程就是整合aop联盟思想和语法，依托jdk提供的反射、横切支持、注解等技术汇集而成
		常用于在项目需要做性能监控、权限控制、事务处理、异常捕捉、日志处理等模板性代码
		集合了java的纵向抽象和横切编程才有办法完美解决重复代码的出现。
