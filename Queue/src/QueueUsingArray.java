
public class QueueUsingArray {
		private int data[];
		private int front;
		private int rear;
		private int size;
		
		public QueueUsingArray()
		{
			data=new int[10];
			front=-1;
			rear=-1;
			size=0;
		}
		public QueueUsingArray(int capacity)
		{
			data=new int[capacity];
			front=-1;
			rear=-1;
			size=0;
		}
		
		int size()
		{
			return size;
		}
		
		boolean isEmpty()
		{
			return (size()==0);
		}
		
		int front() throws QueueEmptyException
		{
			if(size()==0)
			{
				throw new QueueEmptyException();
			}
			
			
			return data[front];
		}
		
		void enqueue(int element) throws QueueFullException
		{
			if(size==data.length)
			{
				throw new QueueFullException();
			}
			
			if(size==0)
			{
				front=0;
			}
			
			size++;
			
			rear=(rear+1)%data.length;
//			rear++;
//			if(rear==data.length)
//			{
//				rear=0;
//			}
			data[rear]=element;
			
		}
		int deqeue() throws QueueEmptyException
		{
			if(size()==0)
			{
				throw new QueueEmptyException();
			}
			
			
			front=(front+1)%data.length;
//			front++;
//			if(size==data.length)
//			{
//				front=0;
//			}
			int temp=data[front];
			size--;
			
			if(size==0)
			{
				front=-1;
				rear=-1;
			}
			return temp;
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
