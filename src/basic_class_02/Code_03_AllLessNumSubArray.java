package basic_class_02;

import java.util.LinkedList;

//最大值减去最小值小于或等于num的子数组数量
public class Code_03_AllLessNumSubArray {

	public static int getNum(int[] arr, int num) {//O(n^3)
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				if (isValid(arr, i, j, num)) {
					count++;
				}
			}
		}
		return count;
	}
	
	public static boolean isValid(int[] arr, int i, int j, int num) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int k = i; k <= j; k++) {
			min = Math.min(min, arr[k]);
			max = Math.max(max, arr[k]);
		}
		return max - min <= num;
	}
	//在某个范围内达标，则在这个范围内的范围都达标，在某个范围内不达标，完全包含这个范围的范围都不达标
	//窗口运动，窗口往右移
	public static int getNum1(int[] arr, int num) {//O(n)
		if (arr == null || arr.length == 0) {
			return 0;
		}
		LinkedList<Integer> qmin = new LinkedList<Integer>();
		LinkedList<Integer> qmax = new LinkedList<Integer>();
		int count = 0;
		int L = 0;
		int R = 0;
		while (L < arr.length) {
			while (R < arr.length) {
				while (!qmin.isEmpty() && arr[qmin.getLast()]  >= arr[R]) {//将最小值存入qmin链表的头部
					qmin.pollLast();
				}
				qmin.addLast(R);
				while (!qmax.isEmpty() && arr[qmax.getLast()] <= arr[R]) {//将最大值存入qmax链表的头部
					qmax.pollLast();
				}
				qmax.addLast(R);
				if (arr[qmax.getFirst()] - arr[qmin.getFirst()] > num) {
					break;
				}
				R++;
			}
			if (qmin.peekFirst() == L) {//下标是否过期
				qmin.pollFirst();
			}
			if (qmax.peekFirst() == L) {
				qmax.pollFirst();
			}
			count += R - L;
			L++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		int[] arr = {2,1,3,5,8,6,9};
		int num = 0;
		int res = getNum1(arr, num);
		System.out.println(res);
	}
	 
}
