package advanced_class_05;

public class Code_03_MaxDistanceInTree {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}

	public static int maxDistance(Node head) {
		int[] record = new int[1];
		return posOrder(head, record);
	}
	
	public static class ReturnType{
		public int d;
		public int h;
		
		public ReturnType(int m, int h) {
			this.d = m;;
			this.h = h;
		}
	}
	
	public static ReturnType process(Node head) {
		if (head == null) {
			return new ReturnType(0, 0);
		}
		ReturnType lrt = process(head.left);
		ReturnType rrt = process(head.right);
		int hd = lrt.h + rrt.h + 1;
		int ld = lrt.d;
		int rd = rrt.d;
		int resd = Math.max(Math.max(ld, rd), hd);
		int resh = Math.max(lrt.h, rrt.h) + 1;
		return new ReturnType(resd, resh);
	}

	public static int posOrder(Node head, int[] record) {
		if (head == null) {
			record[0] = 0;
			return 0;
		}
		int lMax = posOrder(head.left, record);
		int maxfromLeft = record[0];
		int rMax = posOrder(head.right, record);
		int maxFromRight = record[0];
		int curNodeMax = maxfromLeft + maxFromRight + 1;
		record[0] = Math.max(maxfromLeft, maxFromRight) + 1;
		return Math.max(Math.max(lMax, rMax), curNodeMax);
	}

	public static void main(String[] args) {
		Node head1 = new Node(1);
		head1.left = new Node(2);
		head1.right = new Node(3);
		head1.left.left = new Node(4);
		head1.left.right = new Node(5);
		head1.right.left = new Node(6);
		head1.right.right = new Node(7);
		head1.left.left.left = new Node(8);
		head1.right.left.right = new Node(9);
		System.out.println(maxDistance(head1));
		System.out.println(process(head1).d);
		
		Node head2 = new Node(1);
		head2.left = new Node(2);
		head2.right = new Node(3);
		head2.right.left = new Node(4);
		head2.right.right = new Node(5);
		head2.right.left.left = new Node(6);
		head2.right.right.right = new Node(7);
		head2.right.left.left.left = new Node(8);
		head2.right.right.right.right = new Node(9);
		System.out.println(maxDistance(head2));
		System.out.println(process(head1).d);

	}

}
