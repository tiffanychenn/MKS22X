import java.util.*;

public class MyHeap{
    
    private int size;
    private boolean type;
    private ArrayList<Integer> heap;

    public MyHeap(){
        this(true);
    }

    public MyHeap(boolean mode){
        type = mode;
        size = 0;
        heap = new ArrayList<Integer>();
        heap.add(0);
    }

    public void add(Integer s){
        heap.add(s);
        size ++;
        moveUp();
    }

    public Integer remove(){
        Integer s = heap.set(1, heap.remove(size));
        size --;
        moveDown();
        return s;
    }

    public Integer peek(){
        return heap.get(1);
    }

    private void moveUp(){
        int index = size;
        if (type){
            while (index > 1 && heap.get(index).compareTo(heap.get(index / 2)) > 0){
                Integer temp = heap.set(index, heap.get(index / 2));
                heap.set(index / 2, temp);
                index /= 2;
            }
        }
        else {
            while (index > 1 && heap.get(index).compareTo(heap.get(index / 2)) < 0){
                Integer temp = heap.set(index, heap.get(index / 2));
                heap.set(index / 2, temp);
                index /= 2;
            }
        }
    }

    private void moveDown(){
        int index = 1;
        boolean welp = true;
        if (type){
            while (index * 2 <= size && welp){
                int left = heap.get(index).compareTo(heap.get(index * 2));
                int right = heap.get(index).compareTo(heap.get(index * 2 + 1));
                if (left > 0 && right > 0) welp = false;
                else if (left > right){
                    Integer temp = heap.set(index, heap.get(index * 2 + 1));
                    heap.set(index * 2 + 1, temp);
                    index = index * 2 + 1;
                }
                else {
                    Integer temp = heap.set(index, heap.get(index * 2));
                    heap.set(index * 2, temp); 
                    index *= 2;
                }
            }
        }
        else {
            while (index * 2 < size && welp){
                int left = heap.get(index).compareTo(heap.get(index * 2));
                int right = heap.get(index).compareTo(heap.get(index * 2 + 1));
                if (left < 0 && right < 0) welp = false;
                else if (left < right){
                    Integer temp = heap.set(index, heap.get(index * 2 + 1));
                    heap.set(index * 2 + 1, temp);
                    index = index * 2 + 1;
                }
                else {
                    Integer temp = heap.set(index, heap.get(index * 2));
                    heap.set(index * 2, temp); 
                    index *= 2;
                }

            }
        }
    }

    public String toString(){
        return heap.toString();
    }

}