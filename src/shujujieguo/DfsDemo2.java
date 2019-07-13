package shujujieguo;

public class DfsDemo2 {
int[] num = new int[3];
	
	public void dfs(int index) {
		//边界条件
		if(index == 3) {
			for(int i = 0; i < 3; i++) {
				System.out.print(num[i] + " ");
			}
			System.out.println();
			//走不下去就return了
			return;
		}		
		for(int i = 1; i<= 3; i++) {
			num[index] = i;
			//枚举下一种情况
			dfs(index + 1);
		}
	}
	
	public static void main(String[] args) {
		DfsDemo2 dfsDemo = new DfsDemo2();
		dfsDemo.dfs(0);
	}
}
