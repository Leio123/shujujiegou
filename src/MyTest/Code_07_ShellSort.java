package MyTest;

import java.util.Arrays;

public class Code_07_ShellSort {

	public static void shellSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		int h = 1;
		while (h < arr.length / 3) {
			h = h * 3 + 1;
		}
		while (h > 0) {
			for (int i = h; i < arr.length; i++) {
				for (int j = i; j > h - 1 && arr[j] < arr[j - h]; j -= h) {
					swap(arr, j, j - h);
				}
			}
			h = (h - 1) / 3;
		}
	}

	public static void swap(int[] arr, int i, int j) {
		if (i == j) return;
		arr[i] ^= arr[j];
		arr[j] ^= arr[i];
		arr[i] ^= arr[j];
	}

	public static void main(String[] args) {
		int[] arr = { 7, 0, 5, 4, 7, 0, 5, 4 };
		shellSort(arr);
		System.out.println(Arrays.toString(arr));
	}

}
