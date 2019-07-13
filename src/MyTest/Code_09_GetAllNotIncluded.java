package MyTest;

import java.util.ArrayList;

public class Code_09_GetAllNotIncluded {

	public static ArrayList<Integer> getAllNotIncluded(int[] A, int[] B) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < B.length; i++) {
			int l = 0; 
			int r = A.length - 1;
			boolean flag = false;
			while (l <= r) {
				int mid = l + ((r - l) >> 1);
				if (A[mid] == B[i]) {
					flag = true;
					break;
				} else if (A[mid] > B[i]) {
					r = mid - 1;
				} else {
					l = mid + 1;
				}
			}
			if (!flag) {
				list.add(B[i]);
			}
		}
		return list;
	}
	
	public static void main(String[] args) {
		int[] A = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] B = {0, 1, 6, 11, 12, 2};
		ArrayList<Integer> res = getAllNotIncluded(A, B);
		System.out.println(res);
	}
}
