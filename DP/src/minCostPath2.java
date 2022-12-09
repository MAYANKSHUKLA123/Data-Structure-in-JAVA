
public class minCostPath2 {

	public static int minCostPath(int arr[][])
	{
		return minCostPath(arr,0,0);
	}
	
	private static int minCostPath(int arr[][],int i,int j)
	{
		int m=arr.length;
		int n=arr[0].length;
		
		if(i==m-1 && j==n-1)
		{
			return arr[i][j];
		}
		
		if(i>=m || j>=n)
		{
			return Integer.MAX_VALUE;
		}
		
		int op1=minCostPath(arr,i+1,j);
		int op2=minCostPath(arr,i+1,j+1);
		int op3=minCostPath(arr,i,j+1);
		
		return arr[i][j]+Math.min(op1,Math.min(op2, op3));
	}
	
	public static int minCostPathDp(int arr[][])
	{
		int m=arr.length;
		int n=arr[0].length;
		int storage[][]=new int[m][n];
		
		//last index value storing or base condition
		storage[m-1][n-1]=arr[m-1][n-1];
		
		//Last row upside value
		for(int j=n-2;j>=0;j--)
		{
			storage[m-1][j]=storage[m-1][j+1]+arr[m-1][j];
		}
		
		//last column left side value
		
		for(int i=m-2;i>=0;i--)
		{
			storage[i][n-2]=storage[i+1][n-1]+arr[i][n-1];
		}
		
		for(int i=m-2;i>=0;i--)
		{
			for(int j=n-2;j>=0;j--)
			{
				storage[i][j]=arr[i][j]+Math.min(storage[i][j+1],Math.min(arr[i+1][j+1],arr[i+1][j]));
			}
		}
		return storage[0][0];
		
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][]= {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,5},{6,7,8,9,10},{11,12,13,14,15}};
		System.out.println(minCostPath(arr));

	}

}
