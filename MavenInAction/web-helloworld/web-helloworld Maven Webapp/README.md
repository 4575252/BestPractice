# maven web 项目实战 之 helloworld
## 本章要点
* maven-archetype-webapp 工程创建
* 工程裁剪、修补
* servlet 测试

### 1.maven-archetype-webapp 工程创建
		新建maven工程，archetype选择maven-archetype-webapp
		
### 2.工程裁剪、修补
		工程创建后已设置后三个Sources Floder，但没有创建文件夹
		创建 src/main/java 文件夹
		创建 src/test/java 文件夹
		注：不同版本的可能对于此次工程所选的骨架略有差异，具体情况具体处理
		
### 3.servlet 测试
		1.添加依赖
		
		<dependency>    
		    <groupId>javax.servlet</groupId>    
		    <artifactId>servlet-api</artifactId>    
		    <version>2.5</version>    
		    <scope>provided</scope>    
		</dependency>    
		
		2.添加基本的servlet处理文件
		添加login.jsp, index.jsp, servlet, web.xml配置
		
注： 本文参照 http://blog.csdn.net/yuguiyang1990/article/details/8796726 进行练习