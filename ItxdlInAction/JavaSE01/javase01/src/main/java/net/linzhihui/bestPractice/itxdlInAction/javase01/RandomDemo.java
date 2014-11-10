package net.linzhihui.bestPractice.itxdlInAction.javase01;
import java.util.Random;
/**

*/
public class RandomDemo{
	public static void main(String[] args){

		Random r = new Random();//创建生成随机数的工具类
		for (int i = 0; i < 10; i++) {
			System.out.println(r.nextInt(16));
			System.out.println(r.nextDouble());
		}
	}
}