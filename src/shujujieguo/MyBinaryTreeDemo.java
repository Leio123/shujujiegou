package shujujieguo;
//�������ڵ�
class Node1
{
	//������1
	public long data;
	//������2
	public String sdata;
	//���ӽڵ�
	public Node1 leftChild;
	//���ӽڵ�
	public Node1 rightChild;
	//���췽��
	public Node1(long data,String sdata)
	{
		this.data=data;
		this.sdata=sdata;
	}	
}
//������
class Tree
{
	//���ڵ�
	public Node1 root;
	//����ڵ�
	public void insert(long value,String sValue)
	{
		//��װ�ڵ�
		Node1 newNode1=new Node1(value,sValue);
		//���õ�ǰ�ڵ�
		Node1 current=root;
		//���ø��ڵ�
		Node1 parent;
		//���rootΪnull��Ҳ���ǵ�һ�����ʱ��
		if(root==null)
		{
			root=newNode1;
			return;
		}
		else
		{
			while(true)
			{
				//���ڵ�ָ��ǰ�ڵ�
				parent=current;
				//�����ǰָ��Ľڵ����ݱȲ����Ҫ���������ߡ�
				if(current.data>value)
				{
					current=current.leftChild;
					if(current==null)
					{
						parent.leftChild=newNode1;
						return;
					}
				}
				//�����ǰָ��Ľڵ����ݱȲ����ҪС���������ߡ�
				else
				{
					current=current.rightChild;
					if(current==null)
					{
						parent.rightChild=newNode1;
						return;
					}
				}
				
			}
		}
	}
	//���ҽڵ�
	public Node1 find(long value)
	{
		//���õ�ǰ�ڵ㣬�Ӹ��ڵ㿪ʼ
		Node1 current=root;
		//ѭ����ֻҪ����ֵ�����ڵ�ǰ�ڵ��������
		while(current.data!=value)
		{
			 //���бȽϣ��Ƚϲ���ֵ�͵�ǰ�ڵ�Ĵ�С��
			if(current.data>value)
				current=current.leftChild;
			else
				current=current.rightChild;
			//������Ҳ���
			if(current==null)
				return null;
		}
		return current;
	}
	//ɾ���ڵ�
	public boolean delete(long value)
	{
		//���õ�ǰ�ڵ㣬�Ӹ��ڵ㿪ʼ
		Node1 current=root;
		//���õ�ǰ�ڵ�ĸ��ڵ�
		Node1 parent=root;
		//�Ƿ�Ϊ��ڵ�
		boolean isLeftChild=true;
		while(current.data!=value)
		{
			parent=current;
			//���бȽϣ��Ƚϲ���ֵ�͵�ǰ�ڵ�Ĵ�С��
			if(current.data>value)
			{
				current=current.leftChild;
				isLeftChild=true;
			}
			else
			{
				current=current.rightChild;
				isLeftChild=false;
			}
			//������Ҳ���
			if(current==null)
			{
				return false;
			}
		}
		//ɾ��Ҷ�ӽڵ㣬Ҳ���Ǹýڵ�û���ӽڵ�
		if(current.leftChild==null && current.rightChild==null)
		{
			if(current==root)
				root=null;
			//������Ǹ��ڵ�����ӽڵ�
			else if(isLeftChild)
				parent.leftChild=null;
			else
				parent.rightChild=null;
		}
		else if(current.rightChild==null)
		{
			if(current==root)
				root=current.leftChild;
			else if(isLeftChild)
				parent.leftChild=current.leftChild;
			else
				parent.rightChild=current.rightChild;
		}
		else if(current.leftChild==null)
		{
			if(current==root)
				root=current.rightChild;
			else if(isLeftChild)
				parent.leftChild=current.leftChild;
			else
				parent.rightChild=current.rightChild;
		}
		{
			
		}
		return true;
	}
	//ǰ�����
	public void frontOrder(Node1 localNode1)
	{
		if(localNode1!=null)
		{
			//���ʸ��ڵ�
			System.out.println(localNode1.data+","+localNode1.sdata);
			//ǰ�����������
			frontOrder(localNode1.leftChild);
			//ǰ�����������
			frontOrder(localNode1.rightChild);
		}
	}
	//�������
	public void inOrder(Node1 localNode1)
	{
		if(localNode1!=null)
		{
			//�������������
			inOrder(localNode1.leftChild);
			//���ʸ��ڵ�
			System.out.println(localNode1.data+","+localNode1.sdata);
			//�������������
			inOrder(localNode1.rightChild);
		}
	}
	//�������
	public void afterOrder(Node1 localNode1)
	{
		if(localNode1!=null)
		{
			//�������������
			afterOrder(localNode1.leftChild);
			//�������������
			afterOrder(localNode1.rightChild);
			//���ʸ��ڵ�
			System.out.println(localNode1.data+","+localNode1.sdata);
		}
	}
}
public class MyBinaryTreeDemo
{
	public static void main(String[] args)
	{
		Tree tree=new Tree();
		tree.insert(10,"abc");
		tree.insert(20,"bcd");
		tree.insert(15,"cde");
		tree.insert(5,"def");
		tree.insert(35,"efg");
		tree.insert(40,"fgk");
		tree.insert(30,"gki");
		
		
		System.out.println(tree.root.data);
		System.out.println(tree.root.rightChild.data);
		System.out.println(tree.root.rightChild.leftChild.data);
		System.out.println(tree.root.leftChild.data);
//		
//		Node1 node=tree.find(10);
//		System.out.println(node.data+","+node.sdata);
//		tree.frontOrder(tree.root);
//		tree.inOrder(tree.root);//��С��������
//		tree.afterOrder(tree.root);
//		tree.delete(15);
//		tree.inOrder(tree.root);
		
	}
}
