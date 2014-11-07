# maven web 项目实战 之 mybatis
## 本章要点
	本次单独使用mybatis，工程创建方式与hibernate等类似，简化本文描述。新的技术以注解简化配置，将是未来的主流。
	
### 1.maven quickstart 工程创建
### 2.mybatis依赖注入
    <!-- 添加MyBatis依赖 -->  
    <dependency>  
        <groupId>org.mybatis</groupId>  
        <artifactId>mybatis</artifactId>  
        <version>3.1.1</version>  
    </dependency>  
      
    <dependency>  
        <groupId>log4j</groupId>  
        <artifactId>log4j</artifactId>  
        <version>1.2.16</version>  
    </dependency>  
      
    <dependency>  
      <groupId>org.slf4j</groupId>  
      <artifactId>slf4j-api</artifactId>  
      <version>1.6.1</version>  
    </dependency>  
      
    <dependency>  
        <groupId>org.slf4j</groupId>  
        <artifactId>slf4j-nop</artifactId>  
        <version>1.6.4</version>  
    </dependency>  
    
    <dependency>
    	<groupId>mysql</groupId>
    	<artifactId>mysql-connector-java</artifactId>
    	<version>5.1.33</version>
    </dependency>
    
    
### 3.mysql配置
		-- ----------------------------
		-- Table structure for `t_person`
		-- ----------------------------
		DROP TABLE IF EXISTS `t_person`;
		CREATE TABLE `t_person` (
		  `id` int(11) NOT NULL,
		  `name` varchar(255) DEFAULT NULL,
		  PRIMARY KEY (`id`)
		) ENGINE=InnoDB DEFAULT CHARSET=utf8;
			