import java.util.*;

public class MyDeque{

    private ArrayList<String> data;
    private int start, end, size;

    public MyDeque(){
        data = new ArrayList<String>(10);
        size = 10;
    }

    private void resize(){
        ArrayList<String> temp = new ArrayList<String>(size * 2);
        size *= 2;
        int counter = start;
        while (counter != end){
            temp.add(data.get(counter));
            counter ++;
            counter = counter % data.size();
        }
        temp.add(data.get(end));
        start = 0;
        end = size - 1;
        data = temp;
    }

    public void addFirst(String s){
        if ((end + 1) % size == start) resize();
        data.add((start - 1) % size, s);
        start --;
        start = start % size;
        if (data.size() == 1){
            end --;
            end = end % size;
        }
    }

    public void addLast(String s){
        if ((end + 1) % size == start) resize();
        data.add((end + 1) % size, s);
        end ++;
        end = end % size;
        if (data.size() == 1){
            start ++;
            start = start % size;
        }
    }

    public String removeFirst(){
        String s = data.get(start);
        start ++;
        start = start % size;
        return s;
    }

    public String removeLast(){
        String s = data.get(end);
        end --;
        end = end % size;
        return s;
    }

    public String getFirst(){
        return data.get(start);
    }

    public String getLast(){
        return data.get(end);
    }

    public String toString(){
        return data.toString();
    }

}