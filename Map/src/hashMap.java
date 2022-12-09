import java.util.HashMap;
import java.util.Set;

public class hashMap {
		public static void main(String[] args)
		{
			HashMap<String,Integer> hashMap=new HashMap<>();
			hashMap.put("abc",1);
			hashMap.put("abc",1);
			hashMap.put("abc",1);
			hashMap.put("abc",1);
			System.out.println(hashMap.size());
			Set<String> set=hashMap.keySet();
			for(String s:set)
			{
				System.out.println(s);
			}
		}

}
