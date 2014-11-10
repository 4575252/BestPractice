package net.linzhihui.bestPractice.itxdlInAction.JavaSE02;
/**
	适配器模式（ Adapter ）：将一个类的接口转换成客户希望的另外一个接口。
	适配器模式使得原本由于接口不兼容而不能一起工作的那些类可以一起工作。

*/
class AdapterDemo{
	public static void main(String[] args){
		PowerA powerA = new PowerAImpl();
		start(powerA);


		PowerB powerB = new PowerBImpl();
		PowerAAdapter pa = new PowerAAdapter(powerB);
		start(pa);
	}

	//开始工作
	public static void start(PowerA powerA){
		//..........
		powerA.insert();
		//...........
	}
	/**
	public static void start(PowerB powerB){
		//...........
		powerB.connect();
		//............
	}
	*/
}

//适配器类
class PowerAAdapter implements PowerA{
	private PowerB powerB;//要进行适配的接口
	
	public PowerAAdapter(PowerB powerB){
		this.powerB = powerB;
	}
	
	public void insert(){
		powerB.connect();
	}

}

/**
	电源A接口
*/
interface PowerA{
	public void insert();
}

class PowerAImpl implements PowerA{
	public void insert(){
		System.out.println("电源A接口插入，开始工作");
	}
}

/**
	电源B接口
*/
interface PowerB{
	public void connect();
}

class PowerBImpl implements PowerB{
	public void connect(){
		System.out.println("电源B接口已连接，开始工作");
	}
}
