import java.util.*;

public class MyDeque{

    private ArrayList<String> data;
    private int start, end;

    public MyDeque(){
        data = new ArrayList<String>(10);
    }

    private void resize(){
        ArrayList<String> temp = new ArrayList<String>(data.size() * 2);
        int counter = start;
        while (counter != end){
            temp.add(data.get(counter));
            counter ++;
            counter = counter % data.size();
        }
        temp.add(data.get(end));
        start = 0;
        end = data.size();
        data = temp;
    }

    public void addFirst(String s){}

    public void addLast(String s){}

    public void removeFirst(){}

    public void removeLast(){}

    public void getFirst(){}

    public void getLast(){}

}