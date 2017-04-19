import java.util.*;

public class MyLinkedList implements Iterable<Integer>{

    public static class MyLinkedListIterator implements Iterator<Integer>{

        private int index;
        private MyLinkedList stuff;

        public MyLinkedListIterator(MyLinkedList a){
            index = 0;
            stuff = a;
        }

        public boolean hasNext(){
            return index < stuff.size();
        }

        public Integer next(){
            int returned = stuff.get(index);
            index ++;
            return returned;
        }

    }

    private class Node{

        Node next, prev;
        int value;

        private Node(int v){
          value = v;
        }

        private Node(int v, Node n){
            value = v;
            prev = n;
        }

        public String toString(){
            if (prev == null && next == null) return "null " + value + " null";
            else if (prev == null) return "null " + value + " " + next.value;
            else if (next == null) return prev.value + " " + value + " null";
            return prev.value + " " + value + " " + next.value;
        }

    }

    Node start, end;
    int size;

    public MyLinkedList(){}

    public Iterator<Integer> iterator(){
        return new MyLinkedListIterator(this);
    }

    public int size(){
        return size;
    }

    private Node getNthNode(int n){
        if (n > size) throw new IndexOutOfBoundsException();
        Node current;
        if (n > size / 2){
            int counter = size - n;
            current = end;
            while (counter > 1){
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
            start = new Node(value);
        }
        else if (size == 1){
            end = new Node(value);
            end.prev = start;
            start.next = end;
        }
        else {
            end = new Node(value, end);
            end.prev.next = end;
        }
        size ++;
        return true;
    }

    public int get(int index){
        Node n = getNthNode(index);
        if (index == size) throw new IndexOutOfBoundsException();
        return n.value;
    }
    
    public int set(int index, int value){
        Node n = getNthNode(index);
        if (index == size) throw new IndexOutOfBoundsException();
        int v = n.value;
        n.value = value;
        return v;
    }

    public int indexOf(int value){
        int counter = 0;
        Node current = start;
        while (current != null && current.value != value){
            counter ++;
            current = current.next;
        }
        if (counter == size) return -1;
        return counter;
    }

    public int remove(int index){
        Node n = getNthNode(index);
        if (index == size) throw new IndexOutOfBoundsException();
        if (size == 1){
            start = null;
            size --;
            return n.value;
        }
        if (index == 0){
            n.next.prev = null;
            start = n.next;
        }
        else if (index == size - 1){
            n.prev.next = null;
            end = n.prev;
        }
        else {
            n.prev.next = n.next;
            n.next.prev = n.prev;
        }
        size --;
        return n.value;
    }

    public void add(int index, int value){
        Node n = getNthNode(index);
        size ++;
        Node p = new Node(value);
        if (index == 0){
            start = p;
            p.next = n;
            n.prev = p;
        }
        else if (index == size - 1){
            end = p;
            p.prev = n;
            n.next = p;
        }
        else {
            p.prev = n.prev;
            p.next = n;
            n.prev.next = p;
            n.prev = p;
        }
    }

}