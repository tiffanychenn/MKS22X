import java.util.*;

public class MyLinkedList{

    private class Node{

        Node next, prev;
        int value;

        private Node(int v){
          value = v;
        }

        private Node(int v, Node n){
            value = v;
            next = n;
        }

    }

    Node start, end;
    int size;

    public MyLinkedList(){}

    public int size(){
        return size;
    }

    private Node getNthNode(int n){
        if (n >= size) throw new IndexOutOfBoundsException();
        Node current;
        if (n > size / 2){
            int counter = size - n;
            current = end;
            while (counter > 0){
                counter --;
                current = current.prev;
            }
        }
        else {
            int counter = n;
            current = start;
            while (counter > 0){
                counter --;
                current = current.next;
            }
        }
        return current;
    }

    private void remove(Node target){
        target.prev.next = target.next;
        target.next.prev = target.prev;
        size --;
    }

    public String toString(){
        String s = "[";
        Node current = start;
        for (int i = 0; i < size; i ++){
            s += current.value + " ";
            current = current.next;

        }
        if (size == 0){
            return s + "]";
        }
        return s.substring(0, s.length() - 1) + "]";
    }

    public boolean add(int value){
        if (size == 0){
            start = new Node(value, end);
        }
        else {
            end = new Node(value, end);
        }
        size ++;
        return true;
    }

    //public int get(int index){/*complete this*/}
    
    //public int set(int index, int value){/*complete this*/}

    //public int indexOf(int value){/*complete this*/}

    //public int remove(int index){/*complete this*/}

    //public void add(int index,int value){/*complete this*/}

}