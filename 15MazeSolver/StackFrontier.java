public class StackFrontier implements Frontier{

	Stack<Location> frontier;

	public StackFrontier(){
		frontier = new Stack<Location>();
	}

	public void add(Location l){
		frontier.push(l);
	}

	public Location next(){
		return frontier.pop();
	}

}