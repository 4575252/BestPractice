# maven web 项目实战 之 srping
## 本章要点
* maven quickstart 工程创建
* spring依赖注入
* spring配置
* 本项目仅仅处理了context.xml文件载入spring，并通过容器获取bean再执行，中间bean做了dao的注入，非常基本的一个spring test project

### 1.maven quickstart 工程创建

### 2.spring依赖注入
    <!-- 添加Spring依赖 -->  
    <dependency>  
        <groupId>org.springframework</groupId>  
        <artifactId>spring-core</artifactId>  
        <version>3.1.1.RELEASE</version>  
    </dependency>  
      
    <dependency>  
        <groupId>org.springframework</groupId>  
        <artifactId>spring-beans</artifactId>  
        <version>3.1.1.RELEASE</version>  
    </dependency>  
      
    <dependency>  
        <groupId>org.springframework</groupId>  
        <artifactId>spring-context</artifactId>  
        <version>3.1.1.RELEASE</version>  
    </dependency>  
      
    <dependency>  
        <groupId>org.springframework</groupId>  
        <artifactId>spring-jdbc</artifactId>  
        <version>3.1.1.RELEASE</version>  
    </dependency>  
    
    
### 3.spring配置
	<bean id="personDao" class="net.linzhihui.bestPractice.mavenInAction.java_spring.PersonDao"></bean>
	<bean id="personService" class="net.linzhihui.bestPractice.mavenInAction.java_spring.PersonService">
		<property name="personDao" ref="personDao"></property>
	</bean>