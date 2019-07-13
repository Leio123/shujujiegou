package shujujieguo;
//二叉树节点
class Node1
{
	//数据项1
	public long data;
	//数据项2
	public String sdata;
	//左子节点
	public Node1 leftChild;
	//右子节点
	public Node1 rightChild;
	//构造方法
	public Node1(long data,String sdata)
	{
		this.data=data;
		this.sdata=sdata;
	}	
}
//二叉树
class Tree
{
	//根节点
	public Node1 root;
	//插入节点
	public void insert(long value,String sValue)
	{
		//封装节点
		Node1 newNode1=new Node1(value,sValue);
		//引用当前节点
		Node1 current=root;
		//引用父节点
		Node1 parent;
		//如果root为null，也就是第一插入的时候
		if(root==null)
		{
			root=newNode1;
			return;
		}
		else
		{
			while(true)
			{
				//父节点指向当前节点
				parent=current;
				//如果当前指向的节点数据比插入的要大，则向左走。
				if(current.data>value)
				{
					current=current.leftChild;
					if(current==null)
					{
						parent.leftChild=newNode1;
						return;
					}
				}
				//如果当前指向的节点数据比插入的要小，则向右走。
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
	//查找节点
	public Node1 find(long value)
	{
		//引用当前节点，从根节点开始
		Node1 current=root;
		//循环，只要查找值不等于当前节点的数据项
		while(current.data!=value)
		{
			 //进行比较，比较查找值和当前节点的大小。
			if(current.data>value)
				current=current.leftChild;
			else
				current=current.rightChild;
			//如果查找不到
			if(current==null)
				return null;
		}
		return current;
	}
	//删除节点
	public boolean delete(long value)
	{
		//引用当前节点，从根节点开始
		Node1 current=root;
		//引用当前节点的父节点
		Node1 parent=root;
		//是否为左节点
		boolean isLeftChild=true;
		while(current.data!=value)
		{
			parent=current;
			//进行比较，比较查找值和当前节点的大小。
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
			//如果查找不到
			if(current==null)
			{
				return false;
			}
		}
		//删除叶子节点，也就是该节点没有子节点
		if(current.leftChild==null && current.rightChild==null)
		{
			if(current==root)
				root=null;
			//如果它是父节点的左子节点
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
	//前序遍历
	public void frontOrder(Node1 localNode1)
	{
		if(localNode1!=null)
		{
			//访问根节点
			System.out.println(localNode1.data+","+localNode1.sdata);
			//前序遍历左子树
			frontOrder(localNode1.leftChild);
			//前序遍历右子树
			frontOrder(localNode1.rightChild);
		}
	}
	//中序遍历
	public void inOrder(Node1 localNode1)
	{
		if(localNode1!=null)
		{
			//中序遍历左子树
			inOrder(localNode1.leftChild);
			//访问根节点
			System.out.println(localNode1.data+","+localNode1.sdata);
			//中序遍历右子树
			inOrder(localNode1.rightChild);
		}
	}
	//后序遍历
	public void afterOrder(Node1 localNode1)
	{
		if(localNode1!=null)
		{
			//后序遍历左子树
			afterOrder(localNode1.leftChild);
			//后序遍历右子树
			afterOrder(localNode1.rightChild);
			//访问根节点
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
//		tree.inOrder(tree.root);//从小到大排序
//		tree.afterOrder(tree.root);
//		tree.delete(15);
//		tree.inOrder(tree.root);
		
	}
}
