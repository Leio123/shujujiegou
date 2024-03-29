package shujujieguo;
//栈，先进后出，后进先出。
class MyStack
{
	//底层实现是一个数组
	private long[] arr;
	private int top;
	
	//默认的构造方法
	public MyStack()
	{
		arr=new long[10];
		top=-1;
	}
	
	//带参数构造方法，参数为数组初始化大小
	public MyStack(int maxsize)
	{
		arr=new long[maxsize];
		top=-1;
	}
	//添加数据
	public void push(int value)
	{
		arr[++top]=value;
	}
	//移除数据
	public long pop()
	{
		return arr[top--];
	}
	//查看数据
	public long peek()
	{
		return arr[top];
	}
	//判断是否为空
	public boolean isEmpty()
	{
		return top==-1;
	}
	//判断是否满了
	public boolean isFull()
	{
		return top==arr.length-1;
	}
}
public class MyStackDemo
{
	public static void main(String[] args)
	{
		MyStack ms=new MyStack(4);
		ms.push(23);
		ms.push(12);
		ms.push(1);
		ms.push(90);
		System.out.println(ms.isEmpty());//false
		System.out.println(ms.isFull());//true
		System.out.println(ms.peek());
		while(!ms.isEmpty())
		{
			System.out.print(ms.pop()+" ");
		}
		System.out.println();
		System.out.println(ms.isEmpty());//true
		System.out.println(ms.isFull());//false
	}
}








