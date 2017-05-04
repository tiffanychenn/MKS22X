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
        size ++;
        moveUp();
    }

    public String remove(){
        String s = heap.set(1, heap.remove(size));
        size --;
        moveDown();
        return s;
    }

    private void moveUp(){
        int index = size;
        if (type){
            while (heap > 1 && heap.get(index).compareTo(heap.get(index / 2)) > 0){
                String temp = heap.set(index, heap.get(index / 2));
                heap.set(index / 2, temp);
                index /= 2;
            }
        }
        else {
            while (heap > 1 && heap.get(index).compareTo(heap.get(index / 2)) < 0){
                String temp = heap.set(index, heap.get(index / 2));
                heap.set(index / 2, temp);
                index /= 2;
            }
        }
    }

    private void moveDown(){
        
    }

    public String peek(){
        return heap.get(1);
    }

    public String toString(){
        return heap.toString();
    }

}