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
        System.out.println(h);
    }

}