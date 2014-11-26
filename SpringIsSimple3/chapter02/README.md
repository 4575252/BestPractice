# 【Spring 3.0 就这么简单】 第2章 要点
* 基本BeanFactory使用
* xml和注解加载器介绍
* 基于java配置方式的加载器介绍
* spring注解补充
* 其他补充
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
		
## 3.java配置方式的注解加载器
### 3.1 使用方法
		类加上@Configuration注解
		方法加上@Bean注解
		通过AnnotationConfigApplicationContext进行加载时生效，或作为配置类给servlet作为参数（springmvc用法，参考mall-oper)
		
## 4.Spring 注解补充
### 4.1 注入和重复处理
		通过@Bean(name = "car")，设置名称，默认为类名
		当出现重复时，根据指定的类名（唯一）进行区分，应用@Qualifier("xxx"), 此方法可以用于类属性注入和方法注入，因实验过程未报错，应用@qualifier没有实验

### 4.2 不存在注入（非唯一存在）
		通过@Autowired(required=false)进行声明
		
### 4.3 jdbc注解
		@Component，是spring的容器管理bean，下面几个注解与之等效并有扩充，类似集成
		@Repository，用于对DAO实现类的标注
		@Service，对于Service实现类的标注
		@Controller，对于Controller实现类的标注(SpringMVC的DispatcherServlet扫描装载用，最终映射到url响应处理)
		
## 补充
### javabean规范
	必须提供不带参的构造方法
	如果属性名开头存在大写字母，这必须前2位都大写，不允许出现类似iCode，aBB这种写法，但是ICode是支持的