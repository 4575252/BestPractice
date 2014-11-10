package net.linzhihui.bestPractice.itxdlInAction.JavaSE03.decorator;

/**
 * 被装饰者对象的接口
 * @author lamp
 *
 */
public interface Drink {
	//饮料的描述信息
	public String description();
	
	//计算价格
	public float cost();
}
