
public class ReverseQueue<T> {
	
	public static void main(String args[]) throws QueueFullException
	{
		QueueUsingLL<Integer> queue=new QueueUsingLL<>();
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);
		int arr[]=new int[queue.size+1];
		int size=queue.size;
		
		for(int i=0;i<size;i++)
		{
			try {
				arr[i]=queue.dequeue();
			} catch (QueueEmptyException e) {
				// TODO Auto-generated catch block
				
			}
		}
		
		for(int i=size-1;i>=0;i--)
		{
			System.out.println(arr[i]);
		}
	}

}
