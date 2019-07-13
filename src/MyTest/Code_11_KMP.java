package MyTest;
//有一个文本串S，和一个模式串P，现在要查找P在S中的位置
public class Code_11_KMP {

	public static int getIndexOf(String s, String m) {
		if (s == null || m == null || m.length() == 0 || s.length() < m.length()) {
			return -1;
		}
		char[] chs = s.toCharArray();
		char[] chm = m.toCharArray();
		int[] next = getNextArray(chm);
		int i = 0;
		int j = 0;
		while (i < chs.length && j < chm.length) {
			if (chs[i] == chm[j]) {
				i++;
				j++;
			} else if (next[j] == -1) {
				i++;
			} else {
				j = next[j];
			}
		}
		return j == chm.length ? (i - j) : -1;
	}
	
	public static int[] getNextArray(char[] ch) {
		if (ch.length == 1) {
			return new int[] { -1 };
		}
		int[] next = new int[ch.length];
		next[0] = -1;
		next[1] = 0;
		int pos = 2;
		int pre = 0;
		while (pos < next.length) {
			if (ch[pos - 1] == ch[pre]) {
				next[pos++] = ++pre;
			} else if (pre > 0) {
				pre = next[pre];
			} else {
				next[pos++] = 0;
			}
		}
		return next;
	}
	
	public static void main(String[] args) {
		String str = "abckbcdbcd";
		String match = "bcd";
		System.out.println(getIndexOf(str, match));
	}
}
