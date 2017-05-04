public class Driver{
    
    public static void main(String[] args){
        MyHeap h = new MyHeap();
        h.add("hi");
        h.add("boop");
        h.add("love");
        h.add("chihuahua");
        h.add("unique");
        h.add("beagle");
        h.add("jolly");
        h.add("ten");
        h.add("bobby");
        h.add("figure");
        h.add("storytime");
        h.add("zedd");
        h.add("goodbye");
        h.add("facetious");
        h.add("guess");
        h.add("boop");
        System.out.println(h.peek());
        System.out.println(h);
        h.remove();
        System.out.println(h);
    }

}