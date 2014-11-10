package net.linzhihui.bestPractice.itxdlInAction.JavaSE03;

public class BinaryTree {

	private Node root;//根节点
	
	//添加节点，提供给类外部调用
	public void add(int data){
		if(root==null){
			root = new Node(data);
		}else{
			root.addNode(data);
		}
	}
	
	//输出节点，提供给类外部调用
	public void print(){
		if(root!=null){
			root.printNode();
		}
	}
	
	
	
	//节点类
	class Node{
		
		private int data;//当前节点数据
		private Node left;//左子树
		private Node right;//右子树
		public Node(int data){
			this.data = data;
		}		
		//添加节点
		public void addNode(int data){
			if(this.data>data){
				if(this.left==null){
					this.left = new Node(data);
				}else{
					this.left.addNode(data);
				}
			}else if(this.data<=data){
				if(this.right==null){
					this.right = new Node(data);
				}else{
					this.right.addNode(data);
				}
			}
		}
		//输出节点(中序遍历：左根右)
		public void printNode(){
			if(this.left!=null){
				this.left.printNode();
			}
			System.out.print(this.data+" ");
			if(this.right!=null){
				this.right.printNode();
			}
		}
	}
}
