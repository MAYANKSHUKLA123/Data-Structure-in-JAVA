import javax.swing.text.AbstractDocument.LeafElement;

public class editDistance {

	public static int editDistances(String s,String t)
	{
		if(s.length()==0)
		{
			return t.length();
		}
		
		if(t.length()==0)
		{
			return s.length();
		}
		
		if(s.charAt(0)==t.charAt(0))
		{
			return editDistances(s.substring(1),t.substring(1));
		}
		else
		{
			int op1=editDistances(s,t.substring(1));
			int op2=editDistances(s.substring(1),t);
			int op3=editDistances(s.substring(1),t.substring(1));
			return 1+Math.min(op1, Math.min(op2, op3));
		}
		
		
	}
	
	public static int editDistancesM(String s,String t)
	{
		int m=s.length(); 
		int n=t.length();
		
		int storage[][]=new int[m+1][n+1];
		for(int i=0;i<=m;i++)
		{
			for(int j=0;j<=n;j++)
			{
				storage[i][j]=-1;
			}
		}
		return editDistancesM(s, t, storage);
	}
	private static int editDistancesM(String s, String t, int[][] storage) {
		int m=s.length();
		int n=t.length();
		
		if(storage[m][n]!=-1)
		{
			return storage[m][n];
		}
		if(m==0)
		{
			storage[m][n]=n;
			return storage[m][n];
		}
		
		if(n==0)
		{
			storage[m][n]=m;
			return storage[m][n];
		}
		
		if(s.charAt(0)==t.charAt(0))
		{
			storage[m][n]=editDistancesM(s.substring(1),t.substring(1),storage);
		}
		else
		{
			int op1=editDistancesM(s, t.substring(1),storage);
			int op2=editDistancesM(s.substring(1), t,storage);
			int op3=editDistancesM(s.substring(1), t.substring(1),storage);
			storage[m][n]=1+Math.min(op1, Math.min(op2, op3));
		}
		return storage[m][n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="adefdfdeadefdf";
		String t="fbgbdedefdfdgbdfdgbd";
		System.out.println(editDistancesM(s, t));
		System.out.println(editDistances(s, t));

	}

}
