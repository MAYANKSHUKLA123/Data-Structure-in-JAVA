import java.util.Stack;

public class balancedBracket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Character> stack=new Stack<>();
		String str="{(a+b)}}";
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)=='(' || str.charAt(i)=='{' )
			{
				stack.push(str.charAt(i));
			}
			else if(str.charAt(i)==')' || str.charAt(i)=='}')
			{
				if(stack.peek()=='(' && str.charAt(i)==')')
				{
					stack.pop();
				}
				else if(stack.peek()=='{' && str.charAt(i)=='}')
				{
					stack.pop();
				}
				else if(stack.peek()=='(' && str.charAt(i)!=')')
				{
					System.out.println(false);
				}
				else if(stack.peek()=='{' && str.charAt(i)!='}')
				{
					System.out.println(false);
				}	
			
			
		}
		
		if(stack.isEmpty())
		{
			System.out.println(true);
		}
		
		
		


	}

	}
}
