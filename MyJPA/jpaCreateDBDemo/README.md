# jpa 自动建表练习
## 本项目要点
* 使用jpa/hibernate core扫描entity类自动创建表
* 特色,可引用其他工程,在xml文件中设置第三方工程的class全路径即可生成,无多工程集成的隐患
* 不足,class定义需要全路径,网上有两种主要解决办法,spring和openjpa的扫描方案