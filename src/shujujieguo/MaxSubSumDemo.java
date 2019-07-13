package shujujieguo;
//最大子序列和问题
public class MaxSubSumDemo {
	public static int maxSubSum4(int[] a) {
		int maxSum = 0, thisSum = 0;
		for(int i = 0; i < a.length; i++) {
			thisSum += a[i];
			if(thisSum > maxSum) {
				maxSum = thisSum;
			} else if(thisSum < 0) {
				thisSum = 0;
			}
		}
		return maxSum;
	}
	
	public static void main(String[] args) {
		int[] a = {1, 5, 6, -7, 5, 5, -9, 2};
		int result = maxSubSum4(a);
		System.out.println(result);
	}
}
