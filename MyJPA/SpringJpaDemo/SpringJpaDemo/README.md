# spring hibernate jpa 自动建表练习
## 本项目要点
* 使用LocalContainerEntityManagerFactoryBean 扫描entity类自动创建表
* 特色,spring 有三种entityManagerFactory,本工程使用的方法属于三者中功能最强大,颗粒度最高,可进行目录扫描!过滤!还可以设置分隔符
		generate.packagesToScan=net.linzhihui.bestPractice.entitys
		generate.naming_strategy=org.hibernate.cfg.ImprovedNamingStrategy
* 参考资料
		http://java.dzone.com/articles/springmvc4-spring-data-jpa