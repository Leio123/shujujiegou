package shujujieguo;
//�ж��ࣺ�Ƚ��ȳ���������
class MyQueue
{
	//�ײ�ʹ������
	private long[] arr;
	//��Ч���ݵĴ�С
	private int elements;
	//��ͷ
	private int front;
	//��β
	private int end;
	//Ĭ�Ϲ��췽��
	public MyQueue()
	{
		arr=new long[10];
		elements=0;
		front=0;
		end=-1;
	}
	//�������Ĺ��췽��������Ϊ����Ĵ�С
	public MyQueue(int maxsize)
	{
		arr=new long[maxsize];
		elements=0;
		front=0;
		end=-1;
	}
	//������ݣ��Ӷ�β����
	public void insert(long value)
	{
		if(end==arr.length-1)
			end=-1;//ѭ������
		arr[++end]=value;
		elements++;
	}
	//ɾ�����ݣ��Ӷ�ͷɾ��
	public long remove()
	{
		long value=arr[front++];
		if(front==arr.length)
		{
			front=0;
		}
		elements--;
		return value;		
	}
	//�鿴���ݣ��Ӷ�ͷ�鿴
	public long peek()
	{
		return arr[front];
	}
	//�ж��Ƿ�Ϊ��
	public boolean isEmpty()
	{
		return elements==0;
	}
	//�ж��Ƿ�����
	public Boolean isFull()
	{
		return elements==arr.length;
	}		
}
public class MyQueueDemo
{
	public static void main(String[] args) 
	{
		MyQueue mq=new MyQueue(4);
		mq.insert(23);
		mq.insert(45);
		mq.insert(16);
		mq.insert(1);
		System.out.println(mq.isFull());
		System.out.println(mq.isEmpty());
		System.out.println(mq.peek());
		while(!mq.isEmpty())
		{
			System.out.print(mq.remove()+" ");
		}
		System.out.println();
		mq.insert(23);
		mq.insert(45);
		mq.insert(16);
		mq.insert(1);
		while(!mq.isEmpty())
		{
			System.out.print(mq.remove()+" ");
		}
	}
}

