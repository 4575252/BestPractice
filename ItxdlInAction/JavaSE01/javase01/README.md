# Itxdl 实战之javaSE第一季
## 本章要点
* java.util.Scanner
* java.util.Random

### Scanner使用
		引用很简单，无需第三方jar，不过具体jdk版本不明，应该不高， Scanner s = new Scanner(System.in);
		丰富的命令行多类型读取函数，完善的故障异常，不过故障需自行捕获处理
		异常包括npe、类型转换错误、特别语种不支持告知等。
		
### Random使用
		使用也很简单，主要有取得int和小于0的浮点数（该方法被封装后用于math包的同名类）
		Random r = new Random();//创建生成随机数的工具类
		for (int i = 0; i < 10; i++) {
			System.out.println(r.nextInt(16));
			System.out.println(r.nextDouble());
		}