package advanced_class_06;

public class Code_02_CardsInLine {

	public static int win3(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		} else {
			int i = 0;
			int j = arr.length - 1;
			return Math.max(first(arr, i , j), second(arr, i, j));
		}
	}
	//first(int[] arr, int i, int j)表示对于数组arr，元素从i到j，先拿可以达到的最大分数
	//second(int[] arr, int i, int j)表示对于数组arr，元素从i到j，后拿可以达到的最大分数
	public static int first(int[] arr, int i, int j) {
		if (i == j) {
			return arr[i];
		} else {
			return Math.max(arr[i] + second(arr, i + 1, j), arr[j] + second(arr, i, j-1));
		}
	}
	
	public static int second(int[] arr, int i, int j) {
		if (i == j) {
			return 0;
		} else {
			//为什么取较小值，而不是较大值？因为a和b都是绝顶聪明人，你是在另一个绝顶聪明人之后才拿的，他给你剩下的肯定是较坏的情况
			return Math.min(first(arr, i + 1, j), first(arr, i, j - 1));
		}
	}
	
	public static int win1(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		return Math.max(f(arr, 0, arr.length - 1), s(arr, 0, arr.length - 1));
	}

	public static int f(int[] arr, int i, int j) {
		if (i == j) {
			return arr[i];
		}
		return Math.max(arr[i] + s(arr, i + 1, j), arr[j] + s(arr, i, j - 1));
	}

	public static int s(int[] arr, int i, int j) {
		if (i == j) {
			return 0;
		}
		return Math.min(f(arr, i + 1, j), f(arr, i, j - 1));
	}

	public static int win2(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		//画表
		int[][] f = new int[arr.length][arr.length];
		int[][] s = new int[arr.length][arr.length];
		for (int j = 0; j < arr.length; j++) {
			f[j][j] = arr[j];
			for (int i = j - 1; i >= 0; i--) {
				f[i][j] = Math.max(arr[i] + s[i + 1][j], arr[j] + s[i][j - 1]);
				s[i][j] = Math.min(f[i + 1][j], f[i][j - 1]);
			}
		}
		return Math.max(f[0][arr.length - 1],  s[0][arr.length - 1]);
	}

	public static void main(String[] args) {
		int[] arr = { 1, 9, 1 };
		System.out.println(win1(arr));
		System.out.println(win2(arr));
		System.out.println(win3(arr));
	}

}
