import java.util.*;

public class MyDeque{

    private String[] data;
    private int start, end, size;

    public MyDeque(){
        data = new String[10];
    }

    private void resize(){
        String[] temp = new String[data.length * 2];
        size *= 2;
        int counter = start;
        int place = 0;
        while (counter != end){
            temp[place] = data[counter];
            counter ++;
            place ++;
            counter = counter % data.length;
        }
        temp[place] = data[end];
        start = 0;
        end = place;
        data = temp;
    }

    public void addFirst(String s){
        if ((end + 1) % data.length == start) resize();
        data[(start - 1 + data.length) % data.length] = s;
        start --;
        size ++;
        start = (start + data.length) % data.length;
        if (size == 1){
            end --;
            end = end % data.length;
        }
    }

    public void addLast(String s){
        if ((end + 1) % data.length == start) resize();
        data[(end + 1) % data.length] = s;
        end ++;
        size ++;
        end = end % data.length;
        if (size == 1){
            start ++;
            start = (start + data.length) % data.length;
        }
    }

    public String removeFirst(){
        String s = data[start];
        start ++;
        start = start % data.length;
        size --;
        return s;
    }

    public String removeLast(){
        String s = data[end];
        end --;
        end = end % data.length;
        size --;
        return s;
    }

    public String getFirst(){
        return data[start];
    }

    public String getLast(){
        return data[end];
    }

    public String toString(){
        String s = "";
        for (int i = 0; i < data.length; i ++){
            if (data[i] == null) s += "null ";
            else s += data[i].toString() + " ";
        }
        s += "\n" + "start: " + start + " end: " + end;
        return s;
    }

}