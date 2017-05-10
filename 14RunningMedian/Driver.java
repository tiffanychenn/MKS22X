public class Driver{
    
    public static void main(String[] args){
        RunningMedian r = new RunningMedian();
        r.add(12);
        System.out.println(r.getMedian());
        r.add(22);
        System.out.println(r.getMedian());
        r.add(116);
        System.out.println(r.getMedian());
        r.add(5);
        System.out.println(r.getMedian());
        r.add(72);
        System.out.println(r.getMedian());
        r.add(4);
        System.out.println(r.getMedian());
        r.add(7);
        System.out.println(r.getMedian());
        r.add(721);
        System.out.println(r.getMedian());
        r.add(3);
        System.out.println(r.getMedian());
        r.add(31);
        System.out.println(r.getMedian());
    }

}