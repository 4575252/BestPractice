# 【Spring 3.0 就这么简单】 第1章 要点
* Spring web project 搭建
* 配置文件介绍，包括项目架构、web.xml、spring上下文配置、spring视图解析器配置等

## 项目搭建说明
* 通过myeclipse+maven+github搭建
* 主要jar：springFrameWork、common-dbcp、aspectjweaver、cglib及web基础lib如jstl、servlet、jsp-api等
* 项目整合：通过web.xml的监听器初始化上下文环境，装载、填充bean。通过视图解析器viewspace/servlet配置了ModelAndView解析为目标jsp的功能
* Spring上下文装载，依赖上面的xml配置，加载xml配置文件，组装数据源，构建jdbc模板，并提供事务处理机制

## 配置文件介绍
### 1.项目架构概览
		+---main
		|   +---java
		|   |   \---com
		|   |       \---smart
		|   |           +---dao
		|   |           |       LoginLogDao.java
		|   |           |       UserDao.java
		|   |           |       
		|   |           +---domain
		|   |           |       LoginLog.java
		|   |           |       User.java
		|   |           |       
		|   |           +---service
		|   |           |       UserService.java
		|   |           |       
		|   |           \---web
		|   |                   LoginCommand.java
		|   |                   LoginController.java
		|   |                   
		|   +---resources
		|   |       applicationContext.xml
		|   |       log4j.properties
		|   |       
		|   +---schema
		|   |       sampledb.sql
		|   |       
		|   \---webapp
		|       |   index.jsp
		|       |   
		|       \---WEB-INF
		|           |   baobaotao-servlet.xml
		|           |   viewspace-servlet.xml
		|           |   web.xml
		|           |   
		|           \---jsp
		|                   login.jsp
		|                   main.jsp
### 2.web.xml配置
		<context-param>
		    <param-name>contextConfigLocation</param-name>
		    <param-value>classpath:applicationContext.xml</param-value>
		</context-param>
		<listener>
		    <listener-class>
		        org.springframework.web.context.ContextLoaderListener
		    </listener-class>
		</listener>
		
		<servlet>
		    <servlet-name>viewspace</servlet-name>
		    <servlet-class>
		        org.springframework.web.servlet.DispatcherServlet
		    </servlet-class>
		    <load-on-startup>3</load-on-startup>
		</servlet>
		
		<servlet-mapping>
		    <servlet-name>viewspace</servlet-name>
		    <url-pattern>*.html</url-pattern>
		</servlet-mapping>
### 3.applicationContent.xml
	    <!-- 扫描类包，将标注Spring注解的类自动转化Bean，同时完成Bean的注入 -->
	    <context:component-scan base-package="com.smart.dao"/>
	    <context:component-scan base-package="com.smart.service"/>
	    
	    <!-- 配置数据源 -->
		<bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource"
			destroy-method="close" 
			p:driverClassName="com.mysql.jdbc.Driver"
			p:url="jdbc:mysql://localhost:3306/sampledb31"
			p:username="root"
			p:password="root" />
	
		<!-- 配置Jdbc模板  -->
		<bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate"
			p:dataSource-ref="dataSource" />
			
		<!-- 配置事务管理器 -->
		<bean id="transactionManager"
			class="org.springframework.jdbc.datasource.DataSourceTransactionManager"
			p:dataSource-ref="dataSource" />
			
		<!-- 通过AOP配置提供事务增强，让service包下所有Bean的所有方法拥有事务 -->
		<aop:config proxy-target-class="true">
			<aop:pointcut id="serviceMethod"
				expression=" execution(* com.smart.service..*(..))" />
			<aop:advisor pointcut-ref="serviceMethod" advice-ref="txAdvice" />
		</aop:config>
		<tx:advice id="txAdvice" transaction-manager="transactionManager">
			<tx:attributes>
				<tx:method name="*" />
			</tx:attributes>
		</tx:advice>
### 4.viewspace-servlet.xml
	    <!-- 扫描web包，应用Spring的注解 -->
	    <context:component-scan base-package="com.smart.web"/>
	
	    <bean id="defaultAnnotationHandlerMapping"
	          class="org.springframework.web.servlet.mvc.annotation.DefaultAnnotationHandlerMapping" />
	    <bean id="annotationMethodHandlerAdapter"
	          class="org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter" />
	
	    <!-- 配置视图解析器，将ModelAndView及字符串解析为具体的页面 -->
	    <bean
	            class="org.springframework.web.servlet.view.InternalResourceViewResolver"
	            p:viewClass="org.springframework.web.servlet.view.JstlView"
	            p:prefix="/WEB-INF/jsp/"
	            p:suffix=".jsp"/>
	            