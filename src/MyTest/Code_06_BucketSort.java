package MyTest;

import java.util.Arrays;

public class Code_06_BucketSort {

	public static void bucketSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			max = arr[i] > max ? arr[i] : max;
		}
		int[] bucket = new int[max + 1];
		for (int i = 0; i < arr.length; i++) {
			bucket[arr[i]]++;
		}
		int i = 0;
		for (int j = 0; j < bucket.length; j++) {
			while (bucket[j]-- > 0) {
				arr[i++] = j;
			}
		}
		System.out.println(Arrays.toString(bucket));
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 5, 6, 8, 2, 0, 5, 10};
		bucketSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
}
