
public class QueueUse {

	public static void main(String[] args) throws QueueFullException {
		// TODO Auto-generated method stub
		QueueUsingLL<Integer> queue=new QueueUsingLL<>();
		for(int i=0;i<5;i++)
		{
				queue.enqueue(i);
			
		}
		while(!queue.isEmpty())
		{
			try {
				System.out.println(queue.dequeue());
			} catch (QueueEmptyException e) {
				// TODO Auto-generated catch block
			
			}
		}
		
		

	}

}
