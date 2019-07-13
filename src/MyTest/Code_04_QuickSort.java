package MyTest;

import java.util.Arrays;

public class Code_04_QuickSort {

	public static void quickSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		quickSort(arr, 0, arr.length - 1);
	}
	
	public static void quickSort(int[] arr, int left, int right) {
		if (left < right) {
			int change = left + (int)(Math.random() * (right - left + 1));
			swap(arr, change, right);
			int[] part = partition(arr, left, right);
			quickSort(arr, left, part[0]);
			quickSort(arr, part[1], right);
		}
	}
	
	public static int[] partition(int[] arr, int left, int right) {
		int less = left - 1;
		int more = right;
		while (left < more) {
			if (arr[left] < arr[right]) {
				swap(arr, ++less, left++);
			} else if (arr[left] > arr[right]) {
				swap(arr, left, --more);
			} else {
				left++;
			}
		}
		swap(arr, more, right);
		return new int[] {less, more + 1};
	}
	
	public static void swap(int[] arr, int i, int j) {
		if(i == j) return;
		arr[i] ^= arr[j];
		arr[j] ^= arr[i];
		arr[i] ^= arr[j];
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 5, 6, 8, 2, 0, 5, 10};
		quickSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
