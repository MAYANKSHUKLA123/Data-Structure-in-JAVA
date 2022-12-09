
public class Fibonacci {
	
	public static int fib(int n)
	{
		if(n==0 || n==1)
		{
			return n;
		}
		
		return fib(n-1)+fib(n-2);
	}
	
	public static int fibM(int n)
	{
		int storage[]=new int[n+1];
		for(int i=0;i<=n;i++)
		{
			storage[i]=-1;
		}
		return fibM(n,storage);
	}
	

	public static int fibM(int n, int[] storage) {
		if(n==0 || n==1)
		{
			storage[n]=n;
			return storage[n];
		}
		
		if(storage[n]!=-1)
		{
			return storage[n];
		}
		
		storage[n]=fibM(n-1,storage)+fibM(n-2,storage);
		return storage[n];
	}
	public static int fibDP(int n)
	{
		int storage[]=new int[n+1];
		 storage[0]=0;
		 storage[1]=1;
		 
		 for(int i=2;i<=n;i++)
		 {
			 storage[i]=storage[i-1]+storage[i-2];
		 }
		 
		 return storage[n];
		
	}
	
	public static int minimizetoOne(int n)
	{
		if(n==1)
		{
			return 0;
		}
		
		int op1=minimizetoOne(n-1);
		int minSteps=op1;
		
		if(n%3==0)
		{
			int op2=minimizetoOne(n/3);
			if(op2<minSteps)
			{
				minSteps=op2;
			}
		}
		if(n%2==0)
		{
			int op3=minimizetoOne(n/2);
			if(op3<minSteps)
			{
				minSteps=op3;
			}
		}
		
		return 1+minSteps;	
		
	}
	public static int minimizetoOneM(int n)
	{
		int storage[]=new int[n+1];
		return minimizetoOne(n,storage);
	}

	private static int minimizetoOne(int n, int[] storage) {
		if(n==1)
		{
			storage[n]=n;
			return storage[n];
		}
		
		int op1=minimizetoOne(n-1);
		int minSteps=op1;
		
		if(n%3==0)
		{
			int op2=minimizetoOne(n/3);
			if(op2<minSteps)
			{
				minSteps=op2;
			}
		}
		if(n%2==0)
		{
			int op3=minimizetoOne(n/2);
			if(op3<minSteps)
			{
				minSteps=op3;
			}
		}
		
		storage[n]=1+minSteps;
		return storage[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m=1000;
		System.out.println(minimizetoOneM(m));
		System.out.println(minimizetoOne(m));
		

//		int n=44;
//		System.out.println(fibDP(n));
//		System.out.println(fibM(n));
//		System.out.println(fib(n));
		

	}

}
