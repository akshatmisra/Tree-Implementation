// Insert Data in Binary tree using level order traversal.

import java.util.*;


public class TreeDS {

	Tree root;

	public void insertData(int data)
	{
		// queue to store the tree node at each level
		Queue<Tree> queue = new LinkedList<Tree>(); 
		
		//Tree node to store the poped node from queue
		Tree temp;
		
		Tree node = new Tree(data);
		
		//if root is empty insert the data at root and return;
		if(root == null)
		{
			root = node;
			return;
		}
		
		queue.add(root);
		
		while(!queue.isEmpty())
		{
			temp = queue.poll(); // queue all the elements of same level
			
			if(temp.left != null)
				queue.add(temp.left);
			else
			{
				temp.left = node;
				queue.clear();
				return;
			}
			
			if(temp.right != null)
				queue.add(temp.right);
			else
			{
				temp.right = node;
				queue.clear();
				return;
			}
		}
		
		queue.clear();
	}
	
	public void Inorder(Tree temp)
	{
		if(temp == null)
			return;
		Inorder(temp.left);
		System.out.println(temp.data);
		Inorder(temp.right);
	}
	
	public Tree MirrorTree(Tree temp)
	{
		Tree node;
		if(temp != null)
		{
			MirrorTree(temp.left);
			MirrorTree(temp.right);
			node = temp.left;
			temp.left = temp.right;
			temp.right = node;
		}
		return temp;
	}

	public boolean IsMirror(Tree node1, Tree node2)
	{
		if(node1 == null && node2 == null)
			return true;
		if(node1 == null ||node2 == null)
			return false;
		if(node1.data != node2.data)
			return false;
		else
			return IsMirror(node1.left, node2.right) && IsMirror(node1.right, node2.left);
	}
	
	public boolean PrintAncestors(Tree temp, int node)
	{
		if(temp == null)
			return false;
		if(temp.data == node)
			return true;
		if(PrintAncestors(temp.left,node) || PrintAncestors(temp.right,node))
	{
			System.out.print(temp.data);
			return true;
	}
		return false;
	}

	public boolean IsBST(Tree temp)
	{
		if (temp == null)
			return true;
		if(temp.left != null && temp.data < temp.left.data)
			return false;
		if(temp.right != null && temp.data > temp.right.data)
			return false;
		if(!IsBST(temp.left) || !IsBST(temp.right))
			return false;
		return true;
	}

		
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		TreeDS insertTree = new TreeDS();
		insertTree.insertData(50);
		insertTree.insertData(60);
		insertTree.insertData(70);
		insertTree.insertData(90);
		insertTree.insertData(150);
		insertTree.insertData(20);
		//insertTree.insertData(10);

		insertTree.PrintAncestors(insertTree.root, 0);
		//insertTree.MirrorTree(insertTree.root);
		//insertTree.Inorder(node);
		char [] inorder = {'D','B','E','A','F','C'};
		char [] preorder = {'A','B','D','E','C','F'};
		
		System.out.println(insertTree.IsBST(insertTree.root));
		//Tree node2 = insertTree.BuildTree(inorder,preorder,0,inorder.length -1);
		//insertTree.Inorder(node2);
		//System.out.println(" Are two tree mirror of each other ? " + insertTree.IsMirror(insertTree.root, node));
		//if(insertTree.SearchData(20))
			//System.out.println("Data found");
		//else
			//System.out.println("Data Not found");
		
		sc.close();
	}
}
