package MyTest;

import java.util.Arrays;

//数组对应一颗完全二叉树 i位置的节点的左孩子(i*2+1) 右孩子(i*2+2)
//大根堆指的是任何一颗子树的头部都是这颗子树的最大值
//小根堆指的是任何一颗子树的头部都是这颗子树的最小值
//堆排序：首先把整个数组变成大根堆，堆顶和最后一个元素交换，再把最后一个元素前的数组变成大根堆，堆顶和倒数第二个元素交换，保证后面的元素有序
public class Code_03_HeapSort {
	
	public static void heapSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		//建立大根堆
		for (int i = 0; i < arr.length; i++) {
			heapInsert(arr, i);
		}
		int heapSize = arr.length;
		swap(arr, 0, --heapSize);
		while (heapSize > 0) {
			heapify(arr, 0, heapSize);
			swap(arr, 0, --heapSize);
		}
		
	}
	
	public static void heapify(int[] arr, int index, int heapSize) {
		int left = index * 2 + 1;
		while (left < heapSize) {
			int maxIndex = left + 1 < heapSize && arr[left] < arr[left + 1] ? left + 1 : left;
			maxIndex = arr[index] < arr[maxIndex] ? maxIndex : index;
			if (index == maxIndex) {
				break;
			}
			swap(arr, index, maxIndex);
			index = maxIndex;
			left = index * 2 + 1;
		}
	}
	
	public static void heapInsert(int[] arr, int index) {
		while (arr[index] > arr[(index - 1) / 2]) {
			swap(arr, index, (index  - 1) / 2);
			index = (index - 1) / 2;
		}
	}
		
	public static void swap(int[] arr, int i, int j) {
		arr[i] ^= arr[j];
		arr[j] ^= arr[i];
		arr[i] ^= arr[j];
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 5, 6, 8, 2, 0, 5, 10};
		heapSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
