# 【Spring 3.0 就这么简单】 第2章 要点
* 基本BeanFactory使用
## 1.基本BeanFactory使用
	BeanFactory是Spring最核心的接口，其他接口都是在它之上进行封装，一般只在spring内部使用，项目中不直接使用它
	
## 2.基于xml加载的ApplicationContent使用,
	ClassPathXmlApplicationContext
	FileSystemXmlApplicationContext
	AnnotationConfigApplicationContext
	WebApplicationContext(参考chapter01和chapter021，这里不做演示），spring提供了ContextLoaderListener对web容器的支持

### 例1，使用ClassPathXmlApplicationContext加载xml使用
		ApplicationContext ctx = new ClassPathXmlApplicationContext(String path);
		
### 例2，使用ClassPathXmlApplicationContext加载多个dxml使用
		ApplicationContext ctx = new ClassPathXmlApplicationContext(String[] xmls);
		注：本实例加载时同时加载了beans2.xml，应用BeanFactoryPostProcessor等接口对实体bean car进行部分属性重写！
		
### 例3，使用FileSystemXmlApplicationContext加载绝对路径xml使用
		ApplicationContext ctx = new FileSystemXmlApplicationContext(String path);
		
### 例4，使用FileSystemXmlApplicationContext加载相对路径xml使用
		ApplicationContext ctx = new FileSystemXmlApplicationContext(String path);
		
### 例5，使用AnnotationConfigApplicationContext扫描包路径，加载应用了注解的bean
		ApplicationContext ctx = new AnnotationConfigApplicationContext("org.chapter0202.applicationContext");
		Car c = (Car) ctx.getBean("car");
		assertEquals(c.getBrand(), "红旗CCC");
