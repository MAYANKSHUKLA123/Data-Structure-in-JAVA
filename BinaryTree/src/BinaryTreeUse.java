import java.util.Scanner;

public class BinaryTreeUse {
	
	public static Pair<Boolean,Pair<Integer,Integer>> isBST(BinaryTreeNode<Integer> root)
	{
		if(root==null)
		{
			Pair<Boolean,Pair<Integer,Integer>> output=new Pair<Boolean,Pair<Integer,Integer>>();
			output.first=true;
			output.second=new Pair<Integer,Integer>();
			output.second.first=Integer.MAX_VALUE;
			output.second.second=Integer.MIN_VALUE;
			return output;
		}
		Pair<Boolean,Pair<Integer,Integer>> leftOutput=isBST(root.left);
		Pair<Boolean,Pair<Integer,Integer>> rightOutput=isBST(root.right);
		int min=Math.min(root.data, Math.min(leftOutput.second.first, rightOutput.second.first));
		int max=Math.max(root.data, Math.max(leftOutput.second.second,rightOutput.second.second));
		boolean isBST=(root.data>leftOutput.second.second) && 
				(root.data<=rightOutput.second.first) && leftOutput.first && rightOutput.first;
		
		Pair<Boolean,Pair<Integer,Integer>> output=new Pair<Boolean,Pair<Integer,Integer>>();
		output.first=isBST;
		output.second=new Pair<Integer,Integer>();
		output.second.first=min;
		output.second.second=max;
		return output;
		
	}
	public static void inorder(BinaryTreeNode<Integer> root)
	{
		if(root==null)
		{
			return;
		}
		
		inorder(root.left);
		System.out.println(root.data+" ");
		inorder(root.right);
	}
	public static void preorder(BinaryTreeNode<Integer> root)
	{
		if(root==null)
		{
			return;
		}
		System.out.println(root.data+" ");
		preorder(root.left);
		preorder(root.right);
	}
	
	public static void postorder(BinaryTreeNode<Integer> root)
	{
		if(root==null)
		{
			return;
		}
		postorder(root.left);
		postorder(root.right);
		System.out.println(root.data+" ");
	}
	public static int diameter(BinaryTreeNode<Integer> root)
	{
		if(root==null)
		{
			return 0;
		}
		
		int option1=height(root.left)+height(root.right);
		int option2=diameter(root.left);
		int option3=diameter(root.right);
		return Math.max(option1, Math.max(option2, option3));
	}
	
	private static int height(BinaryTreeNode<Integer> root) {
		// TODO Auto-generated method stub
		if(root==null)
		{
			return 0;
		}
		int lh=height(root.left);
		int rh=height(root.right);
		return 1+Math.max(lh, rh);
	}
	
	public static Pair<Integer,Integer> heightDiameter(BinaryTreeNode<Integer> root)
	{
		if(root==null)
		{
			Pair<Integer,Integer> output=new Pair<>();
			output.first=0;
			output.second=0;
			return output;
		}
		Pair<Integer,Integer> lo=heightDiameter(root.left);
		Pair<Integer,Integer> ro=heightDiameter(root.right);
		
		int height=1+Math.max(lo.first, ro.second);
		
		int option1=lo.first+ro.first;
		int option2=lo.second;
		int option3=ro.second;
		int diameter=Math.max(option1, Math.max(option2, option3));
		
		Pair<Integer,Integer> output=new Pair<>();
		output.first=height;
		output.second=diameter;
		return output;
		
	}

	public static int countNodes(BinaryTreeNode<Integer> root)
	{
		if(root==null)
		{
			return 0;
		}
		int ans=1;
		ans+=countNodes(root.left);
		ans+=countNodes(root.right);
		return ans;
	}
	
	public static BinaryTreeNode<Integer> takeInputLevelWise()
	{
		Scanner sc=new Scanner(System.in);
		QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes=new QueueUsingLL<>();
		System.out.println("Enter root data");
		int rootData=sc.nextInt();
		if(rootData==-1)
		{
			return null;
		}
		BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(rootData);
		try {
			pendingNodes.enqueue(root);
		} catch (QueueFullException e) {
			// TODO Auto-generated catch block
			
		}
		
		while(!pendingNodes.isEmpty())
		{
			BinaryTreeNode<Integer> front;
			try {
				front=pendingNodes.dequeue();
			} catch (QueueEmptyException e) {
				// TODO Auto-generated catch block
				return null;
			
		}
			
		System.out.println("Enter left child of "+ front.data);
		int leftChild=sc.nextInt();
		if(leftChild!=-1)
		{
			BinaryTreeNode<Integer> child=new BinaryTreeNode<Integer>(leftChild);
			try {
				pendingNodes.enqueue(child);
				front.left=child;
				
			} catch (QueueFullException e) {
				// TODO Auto-generated catch block
				
			}
		}
		
		System.out.println("Enter right child of "+ front.data);
		int rightChild=sc.nextInt();
		if(rightChild!=-1)
		{
			BinaryTreeNode<Integer> child=new BinaryTreeNode<Integer>(rightChild);
			try {
				pendingNodes.enqueue(child);
				front.right=child;
				
			} catch (QueueFullException e) {
				// TODO Auto-generated catch block
				
			}
		}
		}
		
		return root;
		

	}
	public static void printTree(BinaryTreeNode<Integer> root)
	{
		if(root==null)
		{
			return;
		}
		String toBeprinted=root.data+" ";
		if(root.left!=null)
		{
			toBeprinted="L: "+root.left.data+",";
		}
		if(root.right!=null)
		{
			toBeprinted="R: "+root.right.data+",";
		}
		System.out.println(toBeprinted);
		printTree(root.left);
		printTree(root.right);
	}
	public static BinaryTreeNode<Integer> takeInput(Scanner sc)
	{
		int rootData;
		System.out.println("Enter root data ");
		rootData=sc.nextInt();
		if(rootData==-1)
		{
			return null;
		}
		BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(rootData);
		root.left=takeInput(sc);
		root.right=takeInput(sc);
		return root;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		BinaryTreeNode<Integer> root=takeInputLevelWise();
		printTree(root);
//		System.out.println(countNodes(root));
//		System.out.println("Diameter: "+diameter(root));
		System.out.println("Inroder");
		inorder(root);
		System.out.println("Preorder");
		preorder(root);
		System.out.println("Postorder");
		postorder(root);
		sc.close();
		
//		BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(1);
//		BinaryTreeNode<Integer> node1=new BinaryTreeNode<Integer>(2);
//		root.left=node1;
//		BinaryTreeNode<Integer> node2=new BinaryTreeNode<Integer>(3);
//		root.right=node2;
//		
//		System.out.println(root.data);
//		System.out.println(root.left.data);
//		System.out.println(root.right.data);

	}

}
