public class Moves{
	
	private int row, col, numMoves;

	public Moves(int r, int c, int n){
		row = r;
		col = c;
		numMoves = n;
	}

	public int getRow(){
		return row;
	}

	public int getCol(){
		return col;
	}

	public int getMoves(){
		return numMoves;
	}

}