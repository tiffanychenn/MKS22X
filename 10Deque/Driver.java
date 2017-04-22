public class Driver{
	
	public static void main(String[] args){
		MyDeque d = new MyDeque();
		d.addFirst("hello");
		d.addLast("goodbye");
		System.out.println(d.removeFirst());
		d.addFirst("boop");
		d.addFirst("angel");
		System.out.println(d.removeLast());
		d.addLast("welp");
		d.addLast("guess");
		d.addLast("guy");
		d.addLast("salut");
		d.addLast("bonjour");
		d.addLast("je");
		d.addLast("enough");
		d.addFirst("variety");
		d.addFirst("done");
		d.addLast("okay");
		System.out.println(d.getFirst());
		System.out.println(d.getLast());
	}

}