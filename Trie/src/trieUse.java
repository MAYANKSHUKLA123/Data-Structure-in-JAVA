
public class trieUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tries t=new Tries();
		t.add("this");
		t.add("news");
		t.remove("news");
		System.out.println(t.search("new"));

	}

}
