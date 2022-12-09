import java.util.ArrayList;

public class ArrayLIstDemo {

	public static void main(String[] args) {
		ArrayList<Integer> list1=new ArrayList<>(/*sizeIfYouWant-5*/);
		System.out.println(list1.size());
		list1.add(15);
		list1.add(20);
		list1.add(25);
		list1.add(2,24);
		System.out.println("Size "+list1.size());
		System.out.println(list1.get(2));
		for(int i=0;i<list1.size();i++)
		{
			System.out.println(list1.get(i)+" ");
		}
		list1.remove(1);
		System.out.println("Size "+list1.size());
		

	}

}
