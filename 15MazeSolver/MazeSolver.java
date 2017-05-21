public class MazeSolver{

	private Maze board;
	private boolean pretty;

	public MazeSolver(String file){
		this(file, false);
	}

	public MazeSolver(String file, boolean animate){
		board = new Maze(file);
		pretty = animate;
	}

	public void solve(){
		solve(1);
	}

	public void solve(int style){
		if (style == 0){
			StackFrontier frontier = new StackFrontier();
			frontier.add(board.getStart());
			while (frontier.peek() != board.getEnd()){
				Location[] possible = possibilities(frontier.remove());
				for (int i = 0; i < possible.length; i ++){
					frontier.add(possible[i]);
				}
			}
		}
		else if (style == 1){
			int i = 0;
		}
		else if (style == 2){
			int i = 0;
		}
		else if (style == 3){
			int i = 0;
		}
	}

	public String toString(){
		if (pretty){
			return toString(1000);
		}
		return board.toString();
	}

	// helper function!!! -> returns a list of possible locations to go to

	private Location[] possibilities(Location l){
		
	}

	// helper function!!! -> returns the Manhattan distance to the end

}