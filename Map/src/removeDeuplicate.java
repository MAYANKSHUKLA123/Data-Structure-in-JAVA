import java.util.ArrayList;
import java.util.HashMap;

public class removeDeuplicate {
	
	public static ArrayList<Integer> removeDeuplicate(int arr[])
	{
		ArrayList<Integer> output=new ArrayList<Integer>();
		HashMap<Integer,Boolean> seen=new HashMap<>();
		
		for(int i=0;i<arr.length;i++)
		{
			if(seen.containsKey(arr[i]))
			{
				continue;
			}
			output.add(arr[i]);
			seen.put(arr[i], true);
		}
		return output;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {1,2,3,4,5,5,6,1000,3,2,1};
		ArrayList<Integer> unique=removeDeuplicate(arr);
		for(int i=0;i<unique.size();i++)
		{
			System.out.println(unique.get(i));
		}

	}

}
