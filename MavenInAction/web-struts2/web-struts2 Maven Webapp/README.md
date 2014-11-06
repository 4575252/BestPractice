# maven web 项目实战 之 struts
## 本章要点
* maven webapp 工程创建
* 工程裁剪、修补
* struts2依赖注入
* struts2配置

### 1.maven webapp 工程创建
		参考web-helloworld工程处理办法
		
### 2.struts2依赖注入
		<!-- Struts2 依赖 -->  
		<dependency>
		    <groupId>org.apache.struts</groupId>  
		    <artifactId>struts2-core</artifactId>  
		    <version>2.3.1</version>  
		</dependency> 
    
### 3.struts2配置
		1.web.xml配置
		
		<filter>  
		    <filter-name>struts2</filter-name>  
		    <filter-class>org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter</filter-class>  
		</filter>  
		  
		<filter-mapping>  
		    <filter-name>struts2</filter-name>  
		    <url-pattern>/*</url-pattern>  
		</filter-mapping>    
		
		2.struts.xml
		新建该文件到src/main/resources目录下
		
		3.其他struts/webapp运行所需的action和jsp文件
		