package net.linzhihui.bestPractice.itxdlInAction.JavaSE03.observe;

/**
 * 观察者接口
 * @author lamp
 *
 */
public interface Observer {

	/**
	 * 观察者更新信息方法
	 * @param price
	 */
	public void update(float price);
}
