package MyTest;

import java.util.Arrays;
//基数排序
public class Code_08_RadixSort {

	public static void radixSort(int[] number, int d) // d表示最大的数有多少位
	{
		int k = 0;
		int n = 1;
		int m = 1; //控制键值排序依据在哪一位
		int[][] temp = new int[10][number.length]; // 数组的第一维表示可能的余数0-9
		int[] order = new int[10]; // 数组order[i]用来表示该位是i的数的个数
		while (m <= d) {
			for (int i = 0; i < number.length; i++) {
				int lsd = ((number[i] / n) % 10);
				temp[lsd][order[lsd]] = number[i];
				order[lsd]++;
			}
			for (int i = 0; i < 10; i++) {
				if (order[i] != 0)
					for (int j = 0; j < order[i]; j++) {
						number[k++] = temp[i][j];
					}
				order[i] = 0;
			}
			n *= 10;
			k = 0;
			m++;
		}
	}

	public static void main(String[] args) {
		int[] res = { 73, 22, 93, 43, 55, 14, 28, 65, 39, 81, 33, 100 };
		radixSort(res, 3);
		System.out.println(Arrays.toString(res));
	}
}
