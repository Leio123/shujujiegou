package MyTest;

import java.util.Arrays;

public class Code_02_SelectionSort {

	public static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				minIndex = arr[j] < arr[minIndex] ? j : minIndex; 
			}
			swap(arr, i, minIndex);
		}
	}
	
	public static void swap(int[] arr, int i, int j) {
		arr[i] ^= arr[j];
		arr[j] ^= arr[i];
		arr[i] ^= arr[j];
	}
	
	public static void main(String[] args) {
		int[] arr = {1,5,6,8,2,0,5};
		selectionSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
