public class Driver{

	public static void main(String[] args){
		MyLinkedList l = new MyLinkedList();
		l.add(5);
		l.add(10);
		l.add(47);
		l.add(287);
		l.add(3);
		l.add(486);
		l.add(1, 36817);
		l.add(2, 19);
		l.add(0, 5);
		l.add(l.size() - 1, 1368798);
		System.out.println(l);
		for (int i : l){
			System.out.println(i);
		}
	}

}