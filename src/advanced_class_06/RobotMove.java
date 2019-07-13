package advanced_class_06;

public class RobotMove {

	/*
	 * N 一共有1~N的位置
	 * M 初始停留的位置
	 * P 可以走的步数
	 * K 最终停在的位置
	 * 返回值： 一共有多少种走法
	 * */
	public static int ways(int N, int M, int P, int K) {
		if (M < 1 || M > N || P < 0 || K < 1 || K > N || N < 2) {
			return 0;
		}
		if (P == 0) {
			return M == K ? 1 : 0;
		}
		int res = 0;
		if (M == 1) {
			res = ways(N, M + 1, P - 1, K);
		} else if (M == N) {
			res = ways(N, M - 1, P - 1, K);
		} else {
			res = ways(N, M + 1, P - 1, K) + ways(N, M - 1, P - 1, K) ;
		}
		return res;	
	}
	
	public static int ways1(int N, int M, int P, int K) {
		if (M < 1 || M > N || P < 0 || K < 1 || K > N || N < 1) {
			return 0;
		}
		int[][] dp = new int[N][P + 1];
		dp[K - 1][0] = 1;
		for (int j = 1; j < P + 1; j++) {
			dp[0][j] = dp[1][j - 1];
			dp[N - 1][j] = dp[N - 2][j - 1];
			for (int i = 1; i < N - 1; i++) {
				dp[i][j] = dp[i - 1][j - 1] + dp[i + 1][j - 1]; 
			}
		}
		return dp[M - 1][P];
	}
	
	public static void main(String[] args) {
		int res = ways(9, 4, 12, 8);
		System.out.println(res);
		int res1 = ways1(9, 4, 12, 8);
		System.out.println(res1);
	}
}
