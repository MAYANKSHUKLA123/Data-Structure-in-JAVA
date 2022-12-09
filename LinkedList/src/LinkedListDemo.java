import java.util.Scanner;


public class LinkedListDemo {
	
//	public static Node<Integer> sortedLL(Node<Integer> head1,Node<Integer> head2)
//	{
//		
//	}
	
	public static void midPoint(Node<Integer> head)
	{
		Node<Integer> slow=head;
		Node<Integer> fast=head;
		while(fast!=null && fast.next!=null)
		{
			fast=fast.next.next;
			slow=slow.next;	
		}
		System.out.println(slow.data);
	}
	
	public static Node<Integer> delete(Node<Integer> head,int pos)
	{
		int i=0;
		Node<Integer> temp=head;
		while(i<pos-1)
		{
			temp=temp.next;
			i++;
		}
		temp.next=temp.next.next;
		return head;
	}
	
	public static Node<Integer> insert(Node<Integer> head,int data,int pos)
	{
	
		Node<Integer> newNode=new Node<Integer>(data);
		if(pos==0)
		{
			newNode.next=head;
			return newNode;
		}
		int i=0;
		Node<Integer> temp=head;
		while(i<pos-1)
		{
			temp=temp.next;
			i++;
		}
		newNode.next=temp.next;
		temp.next=newNode;
		return head;
	}
	
	public static Node<Integer> takeInput()
	{
		Node<Integer> head=null,tail=null;
		Scanner sc=new Scanner(System.in);
		int data=sc.nextInt();
		
		while(data!=-1)
		{
			Node<Integer> newNode=new Node<Integer>(data);
			if(head==null)
			{
				head=newNode;
				tail=newNode;
			}
			else
			{
				tail.next=newNode;
				tail=newNode;
			}
			data=sc.nextInt();
		}
		return head;
	}
	
	public static void print(Node<Integer> head)
	{
//		Node<Integer> temp=head; 
		while(head!=null)
		{
			System.out.println(head.data+" ");
			head=head.next;
		}
	
	}
	public static void main(String[] args)
	{
		
		Node<Integer> head=takeInput();
		midPoint(head);
//		head=delete(head, 2);
//		head=insert(head,80,0);
//		Node<Integer> node1=new Node<Integer>(10);
////		System.out.println(node1.data);
////		System.out.println(node1.next);
//		Node<Integer> node2=new Node<Integer>(20);
//		Node<Integer> node3=new Node<Integer>(30);	
//		Node<Integer> head=node1;
//		node1.next=node2;
//		node2.next=node3;
//		
//		print(head); 
		
//		while(head!=null)
//		{
//			System.out.println(head.data+" "); 
//			head=head.next;
//		}
//		System.out.println(node2);
//		System.out.println(node1.next);
	}

}
