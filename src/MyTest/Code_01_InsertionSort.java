package MyTest;

import java.util.Arrays;

public class Code_01_InsertionSort {

	public static void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
				swap(arr, j, j + 1);
			}
		}
	}
	
	public static void swap(int[] arr, int i, int j) {
		arr[i] ^= arr[j];
		arr[j] ^= arr[i];
		arr[i] ^= arr[j];
	}
	
	public static void main(String[] args) {
		int[] arr = {1,5,6,8,2,0,5};
		insertionSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
