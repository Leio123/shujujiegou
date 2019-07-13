package MyTest;

public class Code_18_PrintMatrixSpiralOrder {
	
	public static void spiralOrderPrint(int[][] matrix) {
		int lr = 0;
		int lc = 0;
		int rr = matrix.length - 1;
		int rc = matrix[0].length - 1;
		while (lr <= rr && rr <= rc) {
			printEdge(matrix, lr++, lc++, rr--, rc--);
		}
	}

	public static void printEdge(int[][] m, int lr, int lc, int rr, int rc) {
		if (lr == rr) {
			while (lc <= rc) {
				System.out.print(m[lr][lc++] + " ");
			}
		} else if (lc == rc) {
			while (lr <= rr) {
				System.out.print(m[lr++][lc] + " ");
			}
		} else {
			int curC = lc;
			int curR = lr;
			while (curC < rc) {
				System.out.print(m[lr][curC++] + " ");
			}
			while (curR < rr) {
				System.out.print(m[curR++][rc] + " ");
			}
			while (curC > lc) {
				System.out.print(m[rc][curC--]+ " ");
			}
			while (curR > lr) {
				System.out.print(m[curR--][lc]+ " ");
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
				{ 13, 14, 15, 16 } };
		spiralOrderPrint(matrix);
	}

}