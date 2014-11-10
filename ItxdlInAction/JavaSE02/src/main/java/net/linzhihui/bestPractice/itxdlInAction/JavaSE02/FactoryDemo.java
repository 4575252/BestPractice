package net.linzhihui.bestPractice.itxdlInAction.JavaSE02;
/**
	工厂设计模式:
	简单工厂模式是由一个工厂对象决定创建出哪一种产品类的实例。
	简单工厂模式是工厂模式家族中最简单实用的模式。

*/
public class FactoryDemo{
	public static void main(String[] args){
		/*
		ClothDoll cd = new ClothDoll();
		System.out.println(cd.getInfo());
		BarbieDoll bd = new BarbieDoll();
		System.out.println(bd.getInfo());
		*/
		Doll clothDoll = DollFactory.getInstance("cloth");
		if(clothDoll!=null){
			System.out.println(clothDoll.getInfo());
		}
		Doll barbieDoll = DollFactory.getInstance("barbie");
		if(barbieDoll!=null){
			System.out.println(barbieDoll.getInfo());
		}
	}
}


//工厂类
class DollFactory{
	//只负责产生对象
	public static Doll getInstance(String name){
		//根据条件生产不同的对象
		if("cloth".equals(name)){
			return new ClothDoll();
		}else if("barbie".equals(name)){
			return new BarbieDoll();
		}
		return null;
	}
}

//娃娃
interface Doll{
	public String getInfo();
}

//布娃娃
class ClothDoll implements Doll{
	public String getInfo(){
		return "我是布娃娃，我怕脏。";
	}
}
//芭芘娃娃
class BarbieDoll implements Doll{
	public String getInfo(){
		return "我是芭芘娃娃，我美的不可思议。";
	}
}