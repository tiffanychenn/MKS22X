public class Driver{
    
    public static void main(String[] args){
        RunningMedian r = new RunningMedian();
        r.add(5);
        System.out.println(r.getMedian());
        r.add(10);
        System.out.println(r.getMedian());
        r.add(15);
        System.out.println(r.getMedian());
        r.add(8);
        System.out.println(r.getMedian());
        r.add(37);
        r.add(379);
        r.add(2);
        r.add(1);
        r.add(11);
        System.out.println(r.getMedian());
        r.add(18);
        System.out.println(r.getMedian());
    }

}