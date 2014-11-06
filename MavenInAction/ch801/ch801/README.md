# maven实战第八章练习
## 一、聚合配置
### 创建父工程，修改pom文件中打包方式为pom
		  <packaging>pom</packaging>
### 添加2个子模块（model），父工程添加配置
		<project ...>
			.......
		  <modules>
		  	<module>ch801-a</module>
		  	<module>ch801-b</module>
		  </modules>
		</project>
		