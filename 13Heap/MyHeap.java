import java.util.*

public class MyHeap{
	
	private int size;
	private boolean type;
	private ArrayList<String> heap;

	public MyHeap(){
		this(true);
	}

	public MyHeap(boolean mode){
		type = mode;
		size = 0;
		heap = new ArrayList<String>();
		heap.add("");
	}

	public void add(String s){
		heap.add(s);
	}

	public String remove(){
		String s = heap.set(1, "");
		heap.set(1, heap.remove(size + 1));
	}

	public String peek(){
		return heap.get(1);
	}

}