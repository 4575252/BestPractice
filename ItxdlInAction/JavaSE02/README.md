# Itxdl 实战之javaSE第二季
## 本章要点
* 字符串的使用
* jdk1.5 可变参数
* 单例模式
* 继承
* 抽象类
* 接口
* 设计模式：单例模式、简单工厂模式、代理模式、适配器模式
* 内部类：成员内部类、函数内部类、参数内部类（接口、抽象类、普通类应用）
* 递归和链表
* jdk1.5 包装类(元数据）

### String使用
		使用String本身并不复杂，这里特别之处，这里特别指出来，主要是string使用频繁，如果高效的利用！
		1.直接赋值和使用 new String("xxxx"); 一个是使用堆内的字符串常量池，一个是使用堆内存（参考类使用方式）
		2.批量字符串拼接，建议使用StringBuffer之类的专用工具类
		
### 继承
		继承就意味着子类可以对父类进行引用/重用、覆盖、扩展等操作
		
### 抽象类 
		含有abstract类型函数的类，自身不实现只声明，子类必须要实现
		class前也需要声明为atbstract class

### 接口
		接口中的方法默认都是public atbstract，可只输入public
		与抽象类相似处：所有的抽象方法都需要被实现
		与抽象类不一致：可以多实现/继承，一般只声明不存放代码（部分项目作为代码表/常量表，因public中的属性字段都是默认static）
		
### 设计模式
		一、单例模式
		1.构造方法私有化并对外提供实例的创建（静态）
		2.对外提供实例包括静态生成和函数调用生成（可传可不传参数），后一种因存在操作可能性，多线程环境有隐患
		二、简单工厂模式
		1.通过传参让工厂来决定如何生产
		三、静态代理模式
		1.代理处理实际业务的开启和结束工作，类似junit，场景可考虑应用于jdbc，文件流等
		四、适配器模式
		1.在适配器中将两种不同类型的接口做兼容改造
		
### 内部类
		包括成员内部类、函数内部类、参数内部类（接口、抽象类、普通类应用）三大种类，还有静态内部类，基本上等于外部类
		主要用于精简设计，比如jdbc模块，定义一个适配器仅供自己使用等专有场景
		
### 递归和链表
		递归必须留有出口，调用必须是递减，深度过大的递归很容易出现内存溢出
		本实例的链表采用代理模式，链表实现了实例的增加、删除、打印的功能。
		
### jdk1.5 包装类(元数据）
		类似。net中的string和String类，此次升级较为完善，使用上几乎没有什么差异感觉，含有自动装箱、拆箱和类型转换。
		
		
		

		

		