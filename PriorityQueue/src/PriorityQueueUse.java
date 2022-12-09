import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;


class StringLengthComparator implements Comparator<String>
{

	@Override
	public int compare(String o1, String o2) {
		if(o1.length()<o2.length())
		{
			return -1;
		}
		else if(o1.length()>o2.length())
		{
			return 1;
		}
		else
		{
			return 0;
		}
		
	}
	
}
public class PriorityQueueUse {
	
	public static void sortKSoted(int arr[],int k)
	{
		PriorityQueue<Integer> pq=new PriorityQueue<>();
		int i=0;
		for(;i<k;i++)
		{
			pq.add(arr[i]);
		}
		for(;i<arr.length;i++)
		{
			arr[i-k]=pq.remove(); //checking for minimum and returning minimum or peek()
			pq.add(arr[i]);
		}
		for(int j=arr.length-k;j<arr.length;j++)
		{
			arr[j]=pq.remove();
		}
		
		
	}

	public static void printKLargest(int arr[],int k)
	{
		PriorityQueue<Integer> pq=new PriorityQueue<>();
		int i=0;
		for(;i<k;i++)
		{
			pq.add(arr[i]);
		}
		for(;i<arr.length;i++)
		{
			int min=pq.element();
			if(min<arr[i])
			{
				pq.remove();
				pq.add(arr[i]);
			}
		}
		
		while(!pq.isEmpty())
		{
			System.out.println(pq.remove());
		}
	}
	

	
	
	public static void main(String[] args) {
		
		String arr[]= {"this","the","a","an","their"};
		StringLengthComparator stringCompare=new StringLengthComparator();
		PriorityQueue<String> pq=new PriorityQueue<>(stringCompare);
//		PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
//		int arr[]= {9,1,0,4,7,3};
		for(int i=0;i<arr.length;i++)
		{
			pq.add(arr[i]);
		}
//	
//		int arr[]= {2,4,1,9,3,8};
//		int k=3;
////		printKLargest(arr, k);
//		sortKSoted(arr, k);
		while(!pq.isEmpty())
		{
			System.out.println(pq.remove());
		}
		
		
		
//		Priority_Queue pr=new Priority_Queue();
//		int arr[]= {5,1,9,2,0};
//		
//		for(int i=0;i<arr.length;i++)
//		{
//			insertIntoVirtualHeap(arr,i); 
//		}
//		
		
//		for(int i=0;i<arr.length;i++)
//		{
//			arr[arr.length-1-i]=removeMinFromVirtualHeap(arr,arr.length-i);
//		}
//		for(int i=0;i<arr.length;i++)
//		{
//			System.out.println(arr[i]+" ");
//		}
////		
//		while(!pr.isEmpty())
//		{
//			System.out.println(pr.removeMin()+" ");
//		}
//		System.out.println();

	}

	private static int removeMinFromVirtualHeap(int[] arr, int heapSize) {
		 
		int temp=arr[0];
		arr[0]=arr[heapSize-1];
		heapSize--;
		int index=0;
		int leftChildIndex=2*index+1;
		int rightChildIndex=2*index+2;
		
		while(leftChildIndex<heapSize)
		{
			int minIndex=index;
			if(arr[leftChildIndex]<arr[minIndex])
			{
				minIndex=leftChildIndex;
			}
			if(rightChildIndex<heapSize && arr[rightChildIndex]<arr[minIndex])
			{
				minIndex=rightChildIndex;
			}
			
			if(minIndex!=index)
			{
				int temp1=arr[index];
				arr[index]=arr[minIndex];
				arr[minIndex]=temp1;
				index=minIndex;
				leftChildIndex=2*index+1;
				rightChildIndex=2*index+2;
				
			}
			else
			{
				break;
			}
				
		}
		return temp;
	}

	private static void insertIntoVirtualHeap(int[] arr, int i) {
		int childIndex=i;
		int parentIndex=(childIndex-1)/2;
		
		while(childIndex>0)
		{
			if(arr[childIndex]<arr[parentIndex])
			{
				//swap as min heap
				
				int temp=arr[childIndex];
				arr[childIndex]=arr[parentIndex];
				arr[parentIndex]=temp;
				childIndex=parentIndex;
				parentIndex=(childIndex-1)/2;
			}
			else
			{
				return;
			}
		}		
		
	}

}
