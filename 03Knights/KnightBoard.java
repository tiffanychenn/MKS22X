public class KnightBoard{

    //instance variables
    private int[][] board;
    private static int[] rows = {1, 1, 2, 2, -1, -1, -2, -2};
    private static int[] cols = {2, -2, 1, -1, 2, -2, 1, -1};

    public KnightBoard(int startingRows,int startingCols){
	board = new int[startingRows][startingCols];
    }

    //blank if you never called solve or when there is no solution
    public String toString(){
	if (board[0][0] == 0){
	    return "";
	}
	String s = "";
	for (int i = 0; i < board.length; i ++){
	    for (int j = 0; j < board[0].length; j ++){
		if (board[i][j] < 10){
		    s = s + " " + board[i][j];
		}
		else {
		    s += board[i][j];
		}
		s += " ";
	    }
	    s += "\n";
	}
	return s;
    }

    public void solve(){
        solveH(0, 0, 1);
    }

    // level is the # of the knight
    private boolean solveH(int row, int col, int level){
	if (level > board.length * board[0].length){
	    return true;
	}
	if (row < 0 || col < 0 || row >= board.length || col >= board[0].length){
	    return false;
	}
	if (board[row][col] == 0){
	    board[row][col] = level;
	    for (int i = 0; i < rows.length; i ++){
		if (solveH(row + rows[i], col + cols[i], level + 1)){
		    return true;
		}
	    }
	    board[row][col] = 0;
	}
	return false;
    }

}
