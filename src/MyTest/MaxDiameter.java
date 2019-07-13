package MyTest;

public class MaxDiameter {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int x) { val = x; }
	}
	
	private static int max = 0;
	
	public static int diameterOfBinaryTree(TreeNode root) {
		depth(root);
		return max;
	}
	
	private static int depth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		max = Math.max(depth(root.left) + depth(root.right), max);
		return Math.max(depth(root.left), depth(root.right)) + 1;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.right.left= new TreeNode(6);
		int res = diameterOfBinaryTree(root);
		System.out.println(res);
	}
}
