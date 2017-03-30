public class Driver{

	public static void main(String[] args){
		MyLinkedList l = new MyLinkedList();
		l.add(5);
		l.add(10);
		l.add(47);
		System.out.println(l);
		l.add(1, 36817);
		System.out.println(l);
		l.add(2, 19);
		System.out.println(l);
	}

}