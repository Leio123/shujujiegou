package shujujieguo;

class Sorts 
{
	public static int[] BubbleSort(int[] arr)
	{
//		int temp=0;
//		for(int i=0;i<arr.length-1;i++)
//		{
//			for(int j=arr.length-1;j>i;j--)
//			{
//				if(arr[j]<arr[j-1])
//				{
//					temp=arr[j];
//					arr[j]=arr[j-1];
//					arr[j-1]=temp;
//				}
//			}
//		}
		int temp = 0;
		for(int i = 0; i < arr.length - 1; i++) {
			for(int j = 0; j < arr.length - 1 - i; j++) {
				if(arr[j] > arr[j + 1]) {
					temp =arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		return arr;
	}
	public static int[] StraightSelectionSort(int[] arr)
	{
		int k=0,temp=0;
		for(int i=0;i<arr.length-1;i++)
		{
			k=i;
			for(int j=i;j<arr.length ;j++)
			{
				if(arr[j]<arr[k])
					k=j;
			}
			temp=arr[i];
			arr[i]=arr[k];
			arr[k]=temp;
		}
		return arr;
	}
 	public static int[] InsertSort(int[] arr)
	{
		int temp=0;
		for(int i=1;i<arr.length;i++)
		{
			int j=i;
	        while (j>0 && arr[j]<arr[j-1])
	        {
	        	temp=arr[j];
				arr[j]=arr[j-1];
				arr[j-1]=temp;
	            j--;
	        }
		}
		return arr;
	}
}
public class SortDemo
{
	public static void sop(int[] arr)
	{
		System.out.print("[");
		for(int a:arr)
			System.out.print(a+" ");
		System.out.println("]");
	}
	public static void main(String[] args)
	{
		int[] arr= {0,5,34,-11,55,0,3};
		sop(Sorts.BubbleSort(arr));
//		sop(Sorts.StraightSelectionSort(arr));
//		sop(Sorts.InsertSort(arr));
	}
}