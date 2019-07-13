package MyTest;
//在一个无序数组中，找到第K小（大）的数，要求时间复杂度为O(n)
//用大根堆排序实现，时间复杂度为nlog(K)
public class Code_15_BFPRT {
	
	public static int[] getMinKNumsByHeap(int[] arr, int k) {
		int[] kHeap = new int[k];
		int i = 0;
		for (; i != k; i++) {
			heapInsert(kHeap, i, arr[i]);//大根堆
		}
		printArray(kHeap);
		System.out.println();
		for (; i != arr.length; i++) {
			if (arr[i] < kHeap[0]) {
				kHeap[0] = arr[i];
				heapify(kHeap, 0);
			}
		}
		return kHeap;
	}

	public static void heapInsert(int[] kHeap, int i, int num) {
		kHeap[i] = num;
		while (i > 0) {
			if (kHeap[(i - 1) / 2] < kHeap[i]) {
				swap (kHeap, (i - 1) / 2, i);
				i = (i - 1) / 2;
			} else {
				break;
			}
		}
	}
	
	public static void heapify(int[] kHeap, int i) {
		int left = i * 2 + 1;
		int right = i * 2 + 2;
		int large = i;
		while (left < kHeap.length) {
			large = kHeap[large] < kHeap[left] ? left : large;
			large = right < kHeap.length && kHeap[large] < kHeap[right] ? right : large;
			if (large != i) {
				swap (kHeap, i, large);
			} else {
				break;
			}
			i = large;
			left = i * 2 + 1;
		    right = i * 2 + 2;
		}
	}
	
	public static void swap(int[] arr, int i , int j) {
		if (i == j) return;
		arr[i] ^= arr[j];
		arr[j] ^= arr[i];
		arr[i] ^= arr[j];
	}
	
	public static void printArray(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}
	
	public static void main(String[] args) {
		int[] arr = { 6, 9, 1, 3, 1, 2, 2, 5, 6, 1, 3, 5, 9, 7, 2, 5, 6, 1, 9 };
		printArray(getMinKNumsByHeap(arr, 5));
	}
	
}
