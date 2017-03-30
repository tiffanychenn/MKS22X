public class MyLinkedList{

    private class Node{

        private int element;
        private Node next;

        private Node(int e){
            element = e;
        }

        private Node(int e, Node n){
            element = e;
            next = n;
        }

    }

    private Node start;
    private int size;

    public MyLinkedList(){
        start = null;
        size = 0;
    }

    public boolean add(int e){
        if (size == 0){
            start = new Node(e);
            size ++;
            return true;
        }
        Node current = start;
        while (current.next != null){
            current = current.next;
        }
        current.next = new Node(e);
        size ++;
        return true;
    }

    public void add(int index, int value){
        if (index >= size) throw new IndexOutOfBoundsException();
        int counter = 0;
        Node current = start;
        while (counter < index){
            current = current.next;
            counter ++;
        }
        current = new Node(value, current);
        counter = 0;
        Node currentN = start;
        while (counter < index - 1){
            currentN = currentN.next;
            counter ++;
        }
        currentN.next = current;
        size ++;
    }

    public int size(){
        return size;
    }

    public String toString(){
        String s = "[";
        Node current = start;
        for (int i = 0; i < size; i ++){
            s = s + current.element + ", ";
            current = current.next;
        }
        if (size == 0) return s + "]";
        return s.substring(0, s.length() - 2) + "]";
    }

    public int get(int index){
        if (index >= size) throw new IndexOutOfBoundsException();
        int counter = 0;
        Node current = start;
        while (counter < index){
            current = current.next;
            counter ++;
        }
        return current.element;
    }

    public void set(int index, int value){
        if (index >= size) throw new IndexOutOfBoundsException();
        int counter = 0;
        Node current = start;
        while (counter < index){
            current = current.next;
            counter ++;
        }
        current.element = value;
    }

    public int indexOf(int value){
        int counter = 0;
        Node current = start;
        while (current.element != value){
            if (current.next == null) return -1;
            current = current.next;
            counter ++;
        }
        return counter;
    }

}