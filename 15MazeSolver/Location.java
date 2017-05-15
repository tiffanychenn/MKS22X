public class Location implements Comparable<Location>{

	int row, col, dstart, dgoal;
	Location prev;
	boolean astar;

	public Location(int r, int c, Location previous, int distToStart, int distToGoal, boolean aStar){
		row = r;
		col = c;
		prev = previous;
		dstart = distToStart;
		dgoal = distToGoal;
		astar = aStar;
	}

	public int compareTo(Location other){
		if (astar) return (dstart + dgoal) - (other.dstart + other.dgoal);
		return dgoal - other.dgoal;
	}

}