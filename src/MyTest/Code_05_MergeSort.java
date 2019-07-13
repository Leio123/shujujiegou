package MyTest;

import java.util.Arrays;

public class Code_05_MergeSort {

	public static void mergeSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		mergeSort(arr, 0, arr.length - 1);
	}
	
	public static void mergeSort(int[] arr, int left, int right) {
		if (left == right) {
			return;
		}
		int mid = left + ((right - left) >> 1);
		mergeSort(arr, left, mid);
		mergeSort(arr, mid + 1, right);
		merge(arr, left, mid, right);
	}
	
	public static void merge(int[] arr, int left, int mid, int right) {
		int[] help = new int[right - left + 1];
		int i = 0;
		int ltemp = left;
		int rtemp = mid + 1;
		while (ltemp <= mid && rtemp <= right) {
			help[i++] = arr[ltemp] <= arr[rtemp] ? arr[ltemp++] : arr[rtemp++];
		}
		while (ltemp <= mid) {
			help[i++] = arr[ltemp++];
		}
		while (rtemp <= right) {
			help[i++] = arr[rtemp++];
		}
		for (int j = 0; j < help.length; j++) {
			arr[left + j] = help[j];
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 5, 6, 8, 2, 0, 5, 10};
		mergeSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
}
