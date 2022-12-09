
public class Knapsack {
	
	public static int knapsack(int weight[],int value[],int maxWeight)
	{
		return knapsack(weight,value,maxWeight,0);
	}

	private static int knapsack(int[] weight, int[] value, int maxWeight, int i) {
	
		if(i==weight.length || maxWeight==0)
		{
			return 0;
		}
		
		if(weight[i]>maxWeight)
			
		{
			return knapsack(weight,value,maxWeight,i+1);
		}
		else
		{
			int op1=value[i]+knapsack(weight,value,maxWeight-weight[i],i+1);
			int op2=knapsack(weight, value, maxWeight,i+1);
			
			return Math.max(op1, op2);
		}
	}
	
	public static int knapsackM(int weight[],int values[],int maxWeight)
	{
		int storage[]=new int[weight.length+1];
		return knapsackM(weight,values,maxWeight,0,storage);
	}

	private static int knapsackM(int[] weight, int[] values, int maxWeight, int i, int[] storage) {
		// TODO Auto-generated method stub
		
		if(storage[i]!=0)
		{
			return storage[i];
		}
		if(maxWeight==0 || i==weight.length)
		{
			storage[i]=0;
			return storage[i];
		}
		
		if(weight[i]>maxWeight)
		{
			storage[i]=knapsackM(weight, values, maxWeight,i+1,storage);
			return storage[i];
		}
		else
		{
			int op1=values[i]+knapsackM(weight, values, maxWeight-weight[i],i+1,storage);
			int o2=knapsackM(weight, values, maxWeight,i+1,storage);
			
			storage[i]=Math.max(op1, o2);
			return storage[i];
		}
	}

	public static void main(String[] args) {
		int weights[]= {6,1,2,4,5};
		int values[]= {10,5,4,8,6};
		int maxWeight=5;
		System.out.println(knapsackM(weights, values, maxWeight));
		System.out.println(knapsack(weights, values, maxWeight));
		
		

	}

}
