# maven实战第十章练习
## 本章要点

### 1.spring ioc 使用
		1.配置文件account-captcha.xml
		<?xml version="1.0" encoding="UTF-8"?>
		<beans xmlns="http://www.springframework.org/schema/beans"
			xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
			xsi:schemaLocation="http://www.springframework.org/schema/beans
		http://www.springframework.org/schema/beans/spring-beans-2.5.xsd">
		
			<bean id="accountCaptchaService"
				class="com.juvenxu.mvnbook.account.captcha.AccountCaptchaServiceImpl">
			</bean>
		
		</beans>
		
		2.pom依赖
		<properties>
			<springframework.version>2.5.6</springframework.version>
		</properties>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-core</artifactId>
			<version>${springframework.version}</version>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-beans</artifactId>
			<version>${springframework.version}</version>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-context</artifactId>
			<version>${springframework.version}</version>
		</dependency>
		
		3.java示例
		ApplicationContext ctx = new ClassPathXmlApplicationContext( "account-captcha.xml" );
		service = (AccountCaptchaService) ctx.getBean( "accountCaptchaService" );
		String captchaKey = service.generateCaptchaKey();


### 2.基于线程安全的8位随机字符生成算法
		private static String range = "0123456789abcdefghijklmnopqrstuvwxyz";
		
		public static synchronized String getRandomString()
		{
		    Random random = new Random();
		
		    StringBuffer result = new StringBuffer();
		
		    for ( int i = 0; i < 8; i++ )
		    {
		        result.append( range.charAt( random.nextInt( range.length() ) ) );
		    }
		
		    return result.toString();
		}
		
### 3.开源的图片引擎使用
		1.pom依赖,引用第三方仓库
		<project>
			......
			<properties>
				<kaptcha.version>2.3</kaptcha.version>
			</properties>
		
			<dependencies>
				<dependency>
					<groupId>com.google.code.kaptcha</groupId>
					<artifactId>kaptcha</artifactId>
					<version>${kaptcha.version}</version>
					<classifier>jdk15</classifier>
				</dependency>
			</dependencies>
		
			<repositories>
				<repository>
					<id>sonatype-forge</id>
					<name>Sonatype Forge</name>
					<url>http://repository.sonatype.org/content/groups/forge/</url>
					<releases>
						<enabled>true</enabled>
					</releases>
					<snapshots>
						<enabled>false</enabled>
					</snapshots>
				</repository>
			</repositories>
		</project>
		
		2.google生成验证码函数
		String captchaKey = com.google.code.kaptcha.impl.DefaultKaptcha.createText();
		
		3.生成图片字节码
		BufferedImage image = com.google.code.kaptcha.impl.DefaultKaptcha.createImage( captchaKey );
		ByteArrayOutputStream out = new ByteArrayOutputStream();
        try
        {
            ImageIO.write( image, "jpg", out );
        }
        catch ( IOException e )
        {
            throw new AccountCaptchaException( "Failed to write captcha stream!", e );
        }
        return out.toByteArray();
        
		4.图片存储
        File image = new File( "target/" + captchaKey + ".jpg" );
        OutputStream output = null;
        try
        {
            output = new FileOutputStream( image );
            output.write( captchaImage );
        }
        finally
        {
            if ( output != null )
            {
                output.close();
            }
        }
        
注： kaptcha有瞬态和反序列化的控制，生成随机码会抛出空指针，练习没有成功
Kaptcha Component throws NPE after session is expired