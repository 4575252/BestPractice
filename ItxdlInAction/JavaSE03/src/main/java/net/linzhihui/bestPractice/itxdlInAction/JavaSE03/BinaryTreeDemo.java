package net.linzhihui.bestPractice.itxdlInAction.JavaSE03;

/**
 * 二叉树实现
 * @author lamp
 *
 */
public class BinaryTreeDemo {

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.add(8);
		bt.add(3);
		bt.add(10);
		bt.add(1);
		bt.add(6);
		bt.add(14);
		bt.add(4);
		bt.add(7);
		bt.add(13);
		
		bt.print();
	}

}

