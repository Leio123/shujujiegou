package advanced_class_05;

import java.util.ArrayList;
import java.util.List;

public class Code_04_MaxHappy {

	public static class ReturnType {
		public int visitedValue;
		public int notVisitedValue;
		
		public ReturnType(int visitedValue, int notVisitedValue) {
			this.visitedValue = visitedValue;
			this.notVisitedValue = notVisitedValue;
		}
	}
	
	public static class Node {
		public int happy;
		public List<Node> nexts;

//		public Node(int happy, List<Node> nexts) {
		public Node(int happy) {
			this.happy = happy;
			nexts = new ArrayList<>();
		}
	}
	
	public static int getMaxHappy(Node head) {
		if (head == null) {
			return 0;
		}
		ReturnType rt = process(head);
		return Math.max(rt.visitedValue, rt.notVisitedValue);
	}
	
	public static ReturnType process(Node head) {
		int visitedValue = head.happy;
		int notVisitedValue = 0;
		List<Node> nexts = head.nexts;
		for (int i = 0; i < nexts.size(); i++) {
			ReturnType next = process(nexts.get(i));
			visitedValue += next.notVisitedValue; 
			notVisitedValue += Math.max(next.visitedValue, next.notVisitedValue);
		}
		return new ReturnType(visitedValue, notVisitedValue);
	}
	
	
	public static int maxHappy(int[][] matrix) {
		int[][] dp = new int[matrix.length][2];
		boolean[] visited = new boolean[matrix.length];
		int root = 0;
		for (int i = 0; i < matrix.length; i++) {
			if (i == matrix[i][0]) {
				root = i;
			}
		}
		process(matrix, dp, visited, root);
		return Math.max(dp[root][0], dp[root][1]);
	}

	public static void process(int[][] matrix, int[][] dp, boolean[] visited, int root) {
		visited[root] = true;
		dp[root][1] = matrix[root][1];
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == root && !visited[i]) {
				process(matrix, dp, visited, i);
				dp[root][1] += dp[i][0];
				dp[root][0] += Math.max(dp[i][1], dp[i][0]);
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 8 }, { 1, 9 }, { 1, 10 } };
		System.out.println(maxHappy(matrix));
		List<Node> nexts = new ArrayList<>();		
		nexts.add(new Node(8));
		nexts.add(new Node(10));
		Node head = new Node(9);
		head.nexts = nexts;
		System.out.println(getMaxHappy(head));
		
	}
}
