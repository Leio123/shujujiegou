package MyTest;
//给一个字符串，在后面添加字符，使其成为回文字符串，要求添加的字符长度最短
public class Code_14_Manacher_ShortestEnd {

	public static char[] manacherString(String str) {
		char[] charArr = str.toCharArray();
		char[] res = new char[str.length() * 2 + 1];
		int index = 0;
		for (int i = 0; i != res.length; i++) {
			res[i] = (i & 1) == 0 ? '#' : charArr[index++];
		}
		return res;
	}

	public static String shortestEnd(String str) {
		if (str == null || str.length() == 0) {
			return "";
		}
		char[] ch = manacherString(str);
		int[] help = new int[ch.length];
		int center = -1;
		int right = -1;
		int maxContainEnd = 0;
		for (int i = 0; i < help.length; i++) {
			help[i] = i < right ? Math.min(help[2 * center - i], right - i) : 1;
			while (i + help[i] < help.length && i - help[i] > -1) {
				if (ch[i + help[i]] == ch[i - help[i]]) {
					help[i]++;
				} else {
					break;
				}
			}
			if (i + help[i] > right) {
				center = i;
				right = i + help[i];
			}
			if (right == help.length) {
				maxContainEnd = help[i];
				break;
			}
		}
		char[] res = new char[str.length() - maxContainEnd + 1];
		for (int i = 0; i < res.length; i++) {
			res[res.length - 1 - i] = str.charAt(i);
		}
		return String.valueOf(res);
	}

	public static void main(String[] args) {
		String str = "1234abaacaabaa";
		String res = shortestEnd(str);
		System.out.println(res);
	}
	
}
