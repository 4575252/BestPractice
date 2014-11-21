# Itxdl 实战之javaWeb第一季
## 本章要点
* JDBC操作
* 完善Junit的使用和case编写

### JDBC操作类
		DBUtils，用于本地连接管理，功能简单，使用ResourceBundle加载db连接配置，提供创建连接和关闭连接的方法，可独立使用也可考虑二次封装与连接池搭配使用
		JdbcTemplate/ResultSetHandler,crud操作模板，纯手工处理，可考虑使用apache的dbutils的QueryRunner替代
		QueryRunner的使用，apache common dbutils中的一个运行器，方便的使用如下
			执行CUD时自动关闭连接，可预置数据源，省去每次传入db连接的麻烦
			查询时可自动根据字段名映射，返回对象或对象的集合
		
### junit的使用
		junit的使用，好多很多
			可以方便测试的代码，同样的方便调研
			测试用的代码，本身就是很好的文档，便于后续接手人的使用
			复杂逻辑修改，方便重复验证，减少回归测试中出现的错误