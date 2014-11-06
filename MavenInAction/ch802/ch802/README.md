# maven实战第八章练习
## 聚合
		参考ch801工程配置
## 继承
### 1.子pom添加父pom信息，子pom不需要再配置单独的版本号和组id
		<project>
			<modelVersion>4.0.0</modelVersion>
			<parent>
				<groupId>net.linzhihui.bestPractice.mavenInAction</groupId>
				<artifactId>ch802</artifactId>
				<version>0.0.1-SNAPSHOT</version>
			</parent>
			
			<artifactId>ch802-b</artifactId>
			<name>ch802-b</name>
			......
		</project>
### 2.父pom定义依赖，子pom就可以引用依赖时不需要再配置版本和范围等参数
		<!-- 父pom -->
		<project>
			<modelVersion>4.0.0</modelVersion>
			......
			<!-- 父pom添加 dependencyManagement声明，子pom就可以依赖，子pom不需要再次配置version和scope-->
			<dependencyManagement>
				<dependencies>
					<dependency>
						<groupId>junit</groupId>
						<artifactId>junit</artifactId>
						<version>3.8.1</version>
						<scope>test</scope>
					</dependency>
				</dependencies>
			</dependencyManagement>
			......
		</project>
		<!-- 子pom -->
		<project>
			......
			<properties>
				<mail.version>1.4.1</mail.version>
			</properties>
			<dependencies>
				<!-- 使用父pom的依赖，不需要再定义version、scope -->
				<dependency>
					<groupId>junit</groupId>
					<artifactId>junit</artifactId>
				</dependency>
		
				<!-- 扩展依赖 父pom中并没有声明 不会影响到父POM 和其他模块 -->
				<dependency>
					<groupId>javax.mail</groupId>
					<artifactId>mail</artifactId>
					<version>${mail.version}</version>
				</dependency>
			</dependencies>
		</project>

		