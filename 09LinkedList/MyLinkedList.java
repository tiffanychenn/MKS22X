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

        private void changeRef(Node neww){
            next = neww;
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
        current.changeRef(new Node(e));
        size ++;
        return true;
    }

    public int size(){
        return size;
    }

    public String toString(){
        String s = "[";
        Node current = start;
        for (int i = 0; i < size; i ++){
            s = s + current.element + " ";
            current = current.next;
        }
        if (size == 0) return s + "]";
        return s.substring(0, s.length() - 1) + "]";
    }

}