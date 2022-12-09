import java.util.Scanner;

//Using DFS

public class Graph {
	
	public static void printHelper(int edges[][],int sv,boolean visited[])
	{
		System.out.println(sv);
		visited[sv]=true;
		
		int n=edges.length;
		for(int i=0;i<n;i++)
		{
			//not visited=1 and if false then traverse through the edges
			if(!visited[i])
			{
				printHelper(edges, i, visited);
			}
		}
	}
	
	public static void print(int edges[][],int sv)
	{
		boolean visited[]=new boolean[edges.length];
		printHelper(edges, sv, visited);
	}

	public static void main(String[] args) {
		//n->nodes
		int n;
		//e->edges
		int e;
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		e=sc.nextInt();
		int edges[][]=new int[n][n];
		
		for(int i=0;i<e;i++)
		{
			//fv->first vertex
			int fv=sc.nextInt();
			//sv->second vertex
			int sv=sc.nextInt();
			edges[fv][sv]=1;
			edges[sv][fv]=1;
		}
		print(edges,0);

	}

}
