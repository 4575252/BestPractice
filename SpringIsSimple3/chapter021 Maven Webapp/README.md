# 【Spring 3.0 就这么简单】 第2章 补充1
* 补充第2章第2点中关于WebApplicationContext加载器的使用方法
* spring提供了ContextLoaderListener针对web容器的支持
* 注：文中介绍ContextLoaderServlet的用法，但是spring3.0的修改日志明确该类已移出

## 1.基本ContextLoaderListener的使用
### 1.1 web.xml配置
		<context-param>
			<param-name>contextConfigLocation</param-name>
			<param-value>classpath:applicationContext.xml</param-value>
		</context-param>
		<listener>
			<listener-class>
				org.springframework.web.context.ContextLoaderListener
			</listener-class>
		</listener>
		
### 1.2 applicationContext.xml配置
		<!-- 扫描类包，将标注Spring注解的类自动转化Bean，同时完成Bean的注入 -->
		<context:component-scan base-package="net.linzhihui"/>
	
## 2.基于SpringMVC的配置
### 2.1 web.xml配置
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
### 2.2 viewspace-servlet.xml 配置
		<!-- 扫描web包，应用Spring的注解 -->
		<context:component-scan base-package="net.linzhihui"/>
		
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
            
## 其他问题
### el表达式故障处理
		maven webapp 骨架默认web.xml的dtd版本为2.3，是不支持el表达式解析，需调整为2.4以上
### ContextLoaderServlet移出的说明
		Changes in version 3.0.0.M1 (2008-12-05)
		----------------------------------------
		
		* revised project layout and build system (module-based sources, bundle repository)
		* updated entire codebase for Java 5 code style (generics, varargs, StringBuilder)
		* updated to JUnit 4.5 and JRuby 1.1
		* removed WebLogic 8.1 and WebSphere 5.1 support
		* removed native TopLink API support (superseded by JPA)
		* removed Commons Attributes support (superseded by Java 5 annotations)
		* removed Jakarta JSTL support for JSP 1.2 (superseded by JSP 2.0)
		* removed outdated Struts 1.x Action delegation support
		* removed ContextLoaderServlet and Log4jConfigServlet
		摘自http://docs.spring.io/spring/docs/3.0.x/changelog.txt
		

