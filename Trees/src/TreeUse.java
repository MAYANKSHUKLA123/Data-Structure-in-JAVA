import java.util.Scanner;


public class TreeUse {
	
	public static void postorderTraversal(TreeNode<Integer> root)
	{
		if(root==null)
		{
			return;
		}
		
		System.out.println(root.data+" ");
		for(int i=root.children.size();i>0;i--)
		{
			postorderTraversal(root.children.get(i));
		}
	}
	
	public static void preorderTraversal(TreeNode<Integer> root)
	{
		if(root==null)
		{
			return;
		}
		System.out.println(root.data+" ");
		for(int i=0;i<root.children.size();i++)
		{
			preorderTraversal(root.children.get(i));
			
		}
	}
	
	public static int leafNodeCount(TreeNode<Integer> root)
	{
		int leaves=0;
		if(root==null)
		{
			return 0;
		}
		
		if(root.children.size()==0)
		{
			return 1;
		}
		
		
		for(int i=0;i<root.children.size();i++)
		{
			leaves+= leafNodeCount(root.children.get(i));
			
			
		}
		return leaves;
	
		
	}
	
	public static void depthAtK(TreeNode<Integer> root,int k)
	{
		if(k<0)
		{
			return;
		}
		if(k==0)
		{
			System.out.println(root.data);
		}
		
		for(int i=0;i<root.children.size();i++)
		{
			depthAtK(root.children.get(i), k-1);
		}
	}
	
	
	public static int heightOfTree(TreeNode<Integer> root)
	{
		if(root==null)
		{
			return 0;
		}
		
		int height=1;
		for(int i=0;i<root.children.size();i++)
		{
			int heightCheck=heightOfTree(root.children.get(i));
			height++;
			if(heightCheck>height)
			{
				height=heightCheck;
			}
		}
		return height;
	}
	
	public static int largest(TreeNode<Integer> root)
	{
		if(root==null)
		{
			return Integer.MIN_VALUE;
		}
		
		int result=root.data;
		for(int i=0;i<root.children.size();i++)
		{
			int childLargest=largest(root.children.get(i));
			if(childLargest>result)
			{
				result=childLargest;
			}
		}
		return result;
	}
	
	public static int numNodes(TreeNode<Integer> root)
{
		if(root==null)
		{
			return 0;
		}
		int count=1;
		for(int i=0;i<root.children.size();i++)
		{
			count+=numNodes(root.children.get(i));
		}
		return count;
	
}
	
	public static TreeNode<Integer> takeInput(Scanner sc)
	{
		int n;
		System.out.println("Enter next node data");
		n=sc.nextInt();
		TreeNode<Integer> root=new TreeNode<Integer>(n);
		System.out.println("Enter number of children "+n);
		int childrenCount=sc.nextInt();
		for(int i=0;i<childrenCount;i++)
		{
			TreeNode<Integer> child=takeInput(sc);
			root.children.add(child);
		}
		return root;
		
	}
	
	public static void print(TreeNode<Integer> root)
	{
		String s=root.data+":";
		for(int i=0;i<root.children.size();i++)
		{
			s=s+root.children.get(i).data+",";
		}
		System.out.println(s);
		for(int i=0;i<root.children.size();i++)
		{
			print(root.children.get(i));
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		TreeNode<Integer> root=takeInput(sc);
		
		print(root);
//		System.out.println("Number of nodes "+numNodes(root));
//		System.out.println("Largest Node "+largest(root));
//		System.out.println("height "+heightOfTree(root));
//		depthAtK(root, 2);
		System.out.println("Leaf node count"+leafNodeCount(root));
//		preorderTraversal(root);
		postorderTraversal(root);
		
//		
//		TreeNode<Integer> root=new TreeNode<Integer>(4);
//		TreeNode<Integer> node1=new TreeNode<Integer>(2);
//		TreeNode<Integer> node2=new TreeNode<Integer>(3);
//		TreeNode<Integer> node3=new TreeNode<Integer>(5);
//		TreeNode<Integer> node4=new TreeNode<Integer>(6);
//		
//		root.children.add(node1);
//		root.children.add(node2);
//		root.children.add(node3);
//		node2.children.add(node4);
//		
//		System.out.println(root);
		

	}

}
