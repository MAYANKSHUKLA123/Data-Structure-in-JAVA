
public class StackUsingLLMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackUsingLL<Integer> stack=new StackUsingLL<>();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		try {
			System.out.println(stack.top());
		} catch (StackEmptyException e) {
			// TODO Auto-generated catch block
			
		}
		
		System.out.println(stack.size());

	}

}
