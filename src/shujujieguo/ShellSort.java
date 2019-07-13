package shujujieguo;
//希尔排序
public class ShellSort {
	public static void sort(int[] arr) {
		
		//初始化一个间隔
		int h = 1;
		while(h < arr.length / 3) {
			h = h * 3 + 1;
		}
		while(h > 0) {
			//进行插入排序
//			int temp = 0;
//			for(int i = h; i < arr.length; i++) {
//				temp = arr[i];
//				int j = i;
//				while(j > h - 1 && arr[j -h] >= temp) {
//					arr[j] = arr[j - h];
//					j -= h;
//				}
//				arr[j] =temp;
//			}
			//进行插入排序
			int temp = 0;
			for(int i = h;i < arr.length; i++)
			{
				int j = i;
		        while (j > h - 1 && arr[j] < arr[j- h])
		        {
		        	temp=arr[j];
					arr[j]=arr[j-h];
					arr[j-h]=temp;
		            j -= h;
		        }
			}
			//减少间隔
			h = (h -1) / 3;
		}
}
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		int[] arr = {7, 0, 5, 4,7, 0, 5, 4,7, 0, 5, 4,7, 0, 5, 4,7, 0, 5, 4,};
		sort(arr);
		int i = 0;
		while(i < arr.length) {
			System.out.print(arr[i] + " ");
			i++;
		}
		System.out.println();
		long end = System.currentTimeMillis();
		System.out.println("程序运行时间："+(end - start)+"ms");
	}
}
