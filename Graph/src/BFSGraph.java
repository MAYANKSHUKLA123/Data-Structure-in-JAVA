import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFSGraph {
	
	public static void printBFSHelper(int edges[][],int sv,boolean visited[])
	{
	Queue<Integer> q=new LinkedList<>();
	q.add(sv);
	int n=edges.length;
	visited[sv]=true;
	while(!q.isEmpty())
	{
		int front;
		front=q.remove();
		System.out.println(front);
		
		for(int i=0;i<n;i++)
		{
			if(edges[front][i]==1 && !visited[i])
			{
				q.add(i);
				visited[i]=true;
			}
		}
	}
}
	public static void BFS(int edges[][])
	{
		boolean visited[]=new boolean[edges.length];
		for(int i=0;i<edges.length;i++)
		{
			if(!visited[i])
			{
				printBFSHelper(edges, i, visited);
			}
		}
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
		
		BFS(edges);

	}

}
