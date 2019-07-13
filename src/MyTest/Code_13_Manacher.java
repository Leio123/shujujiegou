package MyTest;

public class Code_13_Manacher {

	public static char[] manacherString(String str) {
		char[] res = new char[2 * str.length() + 1];
		int index = 0;
		for (int i = 0; i < res.length; i++) {
			res[i] = i % 2 == 0 ? '#' : str.charAt(index++);
		}
		return res;
	}
	
	public static int maxLcpsLength(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}
		char[] res = manacherString(str);
		int[] help = new int[res.length];
		int center = -1;
		int right = -1;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < res.length; i++) {
			help[i] = i < right ? Math.min(help[2 * center - i], right - i) : 1;
			while (i + help[i] < res.length && i - help[i] > -1) {
				if (res[i + help[i]] == res[i - help[i]]) {
					help[i]++;
				} else {
					break;
				}
			}
			max = Math.max(max, help[i]);
			if (i + help[i] > right) {
				center = i;
				right = i + help[i];
			}
		}
		return max - 1;
	}
	
	public static void main(String[] args) {
		String str = "abcb";
		int res = maxLcpsLength(str);
		System.out.println(res);
	}
	
}
