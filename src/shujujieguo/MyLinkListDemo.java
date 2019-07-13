package shujujieguo;
//链结点，相当于是车厢
class Node
{
	//数据域
	public long data;
	//结点域
	public Node next;
	
	public Node(long value)
	{
		this.data=value;
	}
	//显示方法
	public void display()
	{
		System.out.print(data+" ");
	}
}

//链表。相当于火车
class LinkList
{
	//头结点
	private Node first;
	public LinkList()
	{
		first=null;
	}
	//插入一个结点，在头结点后进行插入
	public void insertFirst(long value)
	{
		Node node=new Node(value);
		node.next=first;
		first=node;
	}
	//删除一个结点，在头结点后进行删除
	public Node deleteFirst()
	{
		Node tmp=first;
		first=tmp.next;
		return tmp;
	}
	//显示方法
	public void display()
	{
		Node current=first;
		while(current!=null)
		{
			current.display();
			current=current.next;
		}
	}
	//查找某个结点
	public Node find(long value)
	{
		Node current=first;
		while(current.data!=value)
		{
			if(current.next==null)
				return null;
			current=current.next;
		}
		return current;
	}
	//删除方法，根据数据域来进行删除。
	public Node delete(long value)
	{
		Node current=first;
		Node previous=first;
		while(current.data!=value)
		{
			if(current.next==null)
			{
				return null;
			}
			previous=current;
			current=current.next;
		}
		if(current==first)
			first=first.next;
		else
			previous.next=current.next;
		return current;
	}
}

public class MyLinkListDemo
{
	public static void main(String[] args)
	{
		LinkList linklist=new LinkList();
		linklist.insertFirst(5);
		linklist.insertFirst(34);
		linklist.insertFirst(23);
		linklist.insertFirst(12);
		linklist.insertFirst(10);
		linklist.insertFirst(5);
		linklist.display();
		System.out.println();
		linklist.deleteFirst();
		linklist.display();
		System.out.println();
		Node node=linklist.find(34);
		node.display();
		System.out.println();
		Node node1=linklist.delete(5);
		node1.display();
		System.out.println();
		linklist.display();
	}
}
