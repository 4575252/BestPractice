# maven web 项目实战 之 hibernate
## 本章要点
* maven webapp 工程创建
* 工程裁剪、修补
* hibernate依赖注入
* hibernate配置

### 1.maven webapp 工程创建
		参考web-helloworld工程处理办法
		
### 2.hibernate依赖注入
		<!-- 添加Hibernate依赖 -->  
		<dependency>  
		    <groupId>org.hibernate</groupId>  
		    <artifactId>hibernate-core</artifactId>  
		    <version>3.6.5.Final</version>  
		</dependency>  
		  
		<!-- 添加Log4J依赖 -->  
		<dependency>  
		    <groupId>log4j</groupId>  
		    <artifactId>log4j</artifactId>  
		    <version>1.2.16</version>  
		</dependency>  
		  
		<dependency>  
		  <groupId>org.slf4j</groupId>  
		  <artifactId>slf4j-api</artifactId>  
		  <version>1.6.1</version>  
		</dependency>  
		  
		<dependency>  
		    <groupId>org.slf4j</groupId>  
		    <artifactId>slf4j-nop</artifactId>  
		    <version>1.6.4</version>  
		</dependency>  
		  
		<!-- 添加javassist -->  
		<dependency>  
		    <groupId>javassist</groupId>  
		    <artifactId>javassist</artifactId>  
		    <version>3.11.0.GA</version>  
		</dependency>
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>5.1.33</version>
		</dependency>
    
### 3.hibernate配置
		1.hibernate.cfg.xml配置
		
		<?xml version="1.0" encoding="UTF-8"?>
		<!DOCTYPE hibernate-configuration PUBLIC
		        "-//Hibernate/Hibernate Configuration DTD 3.0//EN"
		        "http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">
		
		<hibernate-configuration>
		    <session-factory>
		
		        <!-- Database connection settings -->
		        <property name="connection.driver_class">com.mysql.jdbc.Driver</property>
				<property name="connection.url">jdbc:mysql://127.0.0.1/mall?useUnicode=true&amp;characterEncoding=utf8&amp;autoReconnect=true</property>
				<property name="connection.username">root</property>
				<property name="connection.password">root</property>
				<property name="javax.persistence.validation.mode">none</property> 
		
		        <property name="dialect">org.hibernate.dialect.MySQLDialect</property>
		        
		        <property name="current_session_context_class">thread</property>
		
		        <property name="show_sql">true</property>
		        <property name="format_sql">true</property>
		
		        <property name="hbm2ddl.auto">update</property>
		
				<mapping class="com.deppon.test03.util.Supplier"/>
		    </session-factory>
		</hibernate-configuration>   
		
		2.log4j.properties
		log4j.appender.stdout=org.apache.log4j.ConsoleAppender
		log4j.appender.stdout.Target=System.out
		log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
		log4j.appender.stdout.layout.ConversionPattern=%d{ABSOLUTE} %5p %c{1}:%L - %m%n
		
		log4j.rootLogger=debug, stdout
		
		log4j.logger.org.hibernate.tool.hbm2ddl=debug
		
		3.test java类编写
		
		4.执行mvn test-compile test 保障hibernate.cfg.xml准确的编译到测试环境，进行测试
		