package advanced_class_05;
//平衡二叉树的条件的是左右子树高度差不超过一
public class Code_02_IsBalancedTree2 {

	public static class Node {
		public int value;
		public Node left;
		public Node right;
		
		public Node(int value) {
			this.value = value;
		}
	}
	
	public static class ReturnType {
		public int level;
		public boolean isB;
		
		public ReturnType(int level, boolean isB) {
			this.level = level;
			this.isB = isB;
		}
	}
	
	public static boolean isBalance(Node head) {
		if (head == null) {
			return true;
		}
		return process(head).isB;
	}
	
	public static ReturnType process(Node head) {
		if (head == null) {
			return new ReturnType(0, true);
		}
		ReturnType lrt = process(head.left);
		if (!lrt.isB) {
			return new ReturnType(0, false);
		}
		ReturnType rrt = process(head.right);
		if (!rrt.isB) {
			return new ReturnType(0, false);
		}
		if (Math.abs(lrt.level - rrt.level) > 1) {
			return new ReturnType(0, false);
		}
		return new ReturnType(Math.max(lrt.level, rrt.level) + 1, true);
	}
	
	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		head.right.left = new Node(6);
		head.right.right = new Node(7);

		System.out.println(isBalance(head));

	}

}
