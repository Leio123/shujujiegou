package shujujieguo;
//ջ���Ƚ����������ȳ���
class MyStack
{
	//�ײ�ʵ����һ������
	private long[] arr;
	private int top;
	
	//Ĭ�ϵĹ��췽��
	public MyStack()
	{
		arr=new long[10];
		top=-1;
	}
	
	//���������췽��������Ϊ�����ʼ����С
	public MyStack(int maxsize)
	{
		arr=new long[maxsize];
		top=-1;
	}
	//�������
	public void push(int value)
	{
		arr[++top]=value;
	}
	//�Ƴ�����
	public long pop()
	{
		return arr[top--];
	}
	//�鿴����
	public long peek()
	{
		return arr[top];
	}
	//�ж��Ƿ�Ϊ��
	public boolean isEmpty()
	{
		return top==-1;
	}
	//�ж��Ƿ�����
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








