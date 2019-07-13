package shujujieguo;
//����㣬�൱���ǳ���
class Node
{
	//������
	public long data;
	//�����
	public Node next;
	
	public Node(long value)
	{
		this.data=value;
	}
	//��ʾ����
	public void display()
	{
		System.out.print(data+" ");
	}
}

//�����൱�ڻ�
class LinkList
{
	//ͷ���
	private Node first;
	public LinkList()
	{
		first=null;
	}
	//����һ����㣬��ͷ������в���
	public void insertFirst(long value)
	{
		Node node=new Node(value);
		node.next=first;
		first=node;
	}
	//ɾ��һ����㣬��ͷ�������ɾ��
	public Node deleteFirst()
	{
		Node tmp=first;
		first=tmp.next;
		return tmp;
	}
	//��ʾ����
	public void display()
	{
		Node current=first;
		while(current!=null)
		{
			current.display();
			current=current.next;
		}
	}
	//����ĳ�����
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
	//ɾ������������������������ɾ����
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
