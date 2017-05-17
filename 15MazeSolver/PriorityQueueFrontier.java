public class PriorityQueueFrontier implements Frontier{

    private MyHeap frontier;

    public PriorityQueueFrontier(){
        frontier = new MyHeap();
    }

    public void add(Location l){
        frontier.add(l);
    }

    public Location next(){
        return frontier.remove();
    }

    public Location peek(){
        return frontier.peek();
    }

    public int size(){
        return frontier.size();
    }

    public boolean hasNext(){
        return !(frontier.peek() == null);
    }

}