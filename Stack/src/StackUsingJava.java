
public class StackUsingJava {
	
	private int data[];
	private int top;
	
	public StackUsingJava()
	{
		data=new int[10];
		top=-1;
	}
	public StackUsingJava(int capacity)
	{
		data=new int[capacity];
		top=-1;
	}
	
	public boolean isEmpty()
	{
		return (top==-1);
	}
	
	public int size()
	{
		return top+1;
	}
	
	public int top() throws StackEmptyException
	{
		if(size()==0)
		{
			StackEmptyException e=new StackEmptyException();
			throw e;
		}
		
		return data[top];
	}
	
	public void push(int element) throws StackFullException{
		if(size()==data.length)
		{
//			StackFullException e=new StackFullException();
//			throw e;
			doubleCapacity();
		}
		top++;
		data[top]=element;
	}
	
	private void doubleCapacity()
	{
		int temp[]=data;
		data=new int[data.length];
		for(int i=0;i<data.length;i++)
		{
			data[i]=temp[i];
		}
	}
	public int pop() throws StackEmptyException
	{
		if(size()==0)
		{
			StackEmptyException e=new StackEmptyException();
			throw e;
		}
		int temp=data[top];
		top--;
		return temp;
	}

}
