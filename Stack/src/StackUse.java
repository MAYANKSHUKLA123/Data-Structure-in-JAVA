
public class StackUse {

	public static void main(String[] args) throws StackFullException {
		// TODO Auto-generated method stub
		StackUsingJava stack=new StackUsingJava();
		
		for(int i=0;i<=5;i++)
		{
			stack.push(i);
		}
		while(!stack.isEmpty())
		{
			try {
				System.out.println(stack.pop());
			} catch (StackEmptyException e) {
				// Never reach here
				
			}
		}
		
	}

}
