package net.linzhihui.bestPractice.itxdlInAction.JavaSE03.decorator;

/**
 * 具体的装饰者对象：黑豆
 * @author lamp
 *
 */
public class BlackBeanDecorator extends Decorator {

	public BlackBeanDecorator(Drink drink) {
		super(drink);
	}
	
	@Override
	public String description() {
		return super.description()+"+黑豆";
	}
	
	@Override
	public float cost() {
		return super.cost()+3.0f;
	}

}
