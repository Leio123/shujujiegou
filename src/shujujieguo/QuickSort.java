package shujujieguo;
//快速排序
public class QuickSort {
	//划分数组
	public static int partition(int[] arr, int left, int right, int point) {
		int leftPtr = left - 1;
		int rightPtr = right;
		while(true) {
			//循环，将比关键字小的留在左端
			while(leftPtr < rightPtr && arr[++leftPtr] < point);
			//循环，将比关键字大的留在右端
			while(rightPtr > leftPtr && arr[--rightPtr] > point);
			if(leftPtr >= rightPtr) {
				break;
			} else {
				int temp =arr[leftPtr];
				arr[leftPtr] = arr[rightPtr];
				arr[rightPtr] = temp;
			}
		}
		int temp =arr[right];
		arr[right] = arr[leftPtr];
		arr[leftPtr] = temp;
		return leftPtr;
	}
	//快速排序
	public static void sort(int[] arr, int left, int right) {
		if(left >= right) {
			return;
		} else {
			//设置关键字
			int point = arr[right];
			//获取切入点，同时对数组进行划分
			int partition = partition(arr, left, right, point);
			//对左边的子数组进行快速排序
			sort(arr, left, partition - 1);
			//对右边的子数组进行快速排序
			sort(arr, partition + 1, right);
		}
	}
	
	//打印数组
	public static void displayArr(int[] arr) {
		System.out.print("[");
		for(int num : arr) {
			System.out.print(num + " ");
		}
		System.out.print("]");
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] arr = new int[10];
		for(int i = 0; i < 10; i++) {
			arr[i] = (int) (Math.random() * 100);
		}
		displayArr(arr);
		sort(arr, 0, arr.length - 1);
		displayArr(arr);
	}
}
