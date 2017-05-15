public class QueueFrontier implements Frontier{

	Queue<Location> frontier;

	public QueueFrontier(){
		frontier = new Queue<Location>();
	}

	public void add(Location l){
		frontier.add(l);
	}

	public Location next(){
		return frontier.remove();
	}

}