# Google Kaptcha 验证码使用
## 本章要点
* kaptcha的安装
* kaptcha的使用

### kaptcha的安装
		通过myeclipse的m2仓库可以查询到索引，但无法有效下载，登录google官网下载 http://code.google.com/p/kaptcha/downloads/list
		解压后执行以下命令安装到本地仓库
			mvn install:install-file -DgroupId=com.google.code.kaptcha -DartifactId=kaptcha -Dversion=2.3.2 -Dpackaging=jar -Dfile=kaptcha-2.3.2.jar
		配置pom
		<dependency>
			<groupId>com.google.code.kaptcha</groupId>
			<artifactId>kaptcha</artifactId>
			<version>2.3.2</version>
		</dependency> 
		
### kaptcha的使用
		配置web.xml，添加servlet，具体参数详见官方文档
		配置测试用test.jsp和响应result.jsp
注：spring的集成可参考 http://blog.csdn.net/rambo_china/article/details/7720181
