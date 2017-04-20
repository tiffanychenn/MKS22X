public class Driver{
	
	public static void main(String[] args){
		MyDeque d = new MyDeque();
		d.addFirst("hello");
		d.addLast("goodbye");
		System.out.println(d);
	}

}