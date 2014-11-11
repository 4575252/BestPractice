# Itxdl 实战之javaSE第三季
## 本章要点
* 二叉树的实现，作为收藏，不展开，看源码即可
* IO流，包括字节流和字符流两大类，细扩展还可分为打印流，转换流等等，不做演示
* 设计模式：装饰者模式
* string三姐妹差异
* set,list,map差异
* 多线程的使用
* 多线程的同步锁synchronized
* 线程池
* 网络编程
* 设计模式：观察者模式
* 注解，重点！


### 装饰者模式
		在原有模型上附加更多东西，此案例介绍了生产一杯豆浆然后添加鸡蛋、糖等配料最终得出名称和总价的场景

### string三姐妹差异
		string和StringBuffer在java1.0时期出现，sb的效率高，资源利用率高，且线程安全
		StringBuild是线程不安全的，出产月java1.5，效率优于StringBuffer，在非线程安全的情况下优先使用
		
### set,list,map差异
		底层都是数组的封装，效率不如数组，功能远远多于数组
		set存储保证唯一，list用于增量扩展，map类似于set（他的kv结构可存储单个大量数据）
		为了排序三者都实现了treeXXX子类
		场景：arrayList用于基本扩展列表，linklist用于堆栈、序列，hashMap存储键值对
		
### 多线程的使用
		多线程的实现方式：
		1、继承Thread类
 		2、实现Runnable接口
 		
### 多线程的同步锁synchronized
		synchronized 用于同步锁，可作用与类或函数
		当一个对象被多线程操作，就有可能发生线程堵塞而出现不完整操作，导致最终数据不一致，因此才需要同步锁
		当一个同步锁去访问另一个同步锁时就有可能出现死锁，比如交叉访问

### 线程池
		代码中使用java.util.concurrent.Executors，文内仅作为代理工具，详细内容还需要gg
		
### 网络编程
		tcp编程采用java.net.ServerSocket来实现，本项目介绍了echo实现
		udp编程采用java.net.DatagramSocket来实现，本项目介绍了echo的实现
		差异：tcp需等到握手成功处理完业务才结束，udp服务端只要一抛出就结束
		更多内容参考其他文章
		
### 观察者模式
		感觉应该叫被观察者模式跟贴切
		本项目实例中，被观察者清楚的知道自己的观察者是谁，当事件触发则第一时间通知观察者
		
### 注解
		包括三个内置注解，四个元注解，和用户自定义注解
		1.内置注解包括@Override,@Deprecated,@SuppressWarnings
			@Override用于覆盖，如果名称写错或不存在着编译器报错
			@Deprecated用于提醒用户该方法已过期
			@SuppressWarnings（“xxx”）用于告诉编译器忽略警告
		2.元注解包括@Retention，@Documented,@Target,@Inherited
			@Retention，定义使用范围，包括源码，class文件，运行时
			@Documented，用于javadoc执行时一并生成注解
			@Target，用于定义注解用于编码时的存放位置，如type-类，method-方法，field-字段等。
			@Inherited,表示类的注解是否允许被子类继承，有标注则默认为true
		
		
