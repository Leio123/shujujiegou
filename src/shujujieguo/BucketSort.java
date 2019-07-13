package shujujieguo;
public class BucketSort 
{
	public static int[] bucket_sort(int[] unsorted,int maxNumber)
	{
		int[] sorted=new int[maxNumber+1];
		for(int i=0;i<unsorted.length;i++)
		{
			sorted[unsorted[i]]=unsorted[i];
		}
		return sorted;
	}
	public static void main(String[] args)
	{
		int[] unsorted= {99,65,24,47,50,88,33,66,67,31,18};
		int[] sorted=bucket_sort(unsorted,99);
		for(int i=0;i<sorted.length;i++)
		{
			if(sorted[i]>0)
				System.out.print(sorted[i]+" ");
		}
	}
}
