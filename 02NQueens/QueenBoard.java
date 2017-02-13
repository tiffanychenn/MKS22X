public class QueenBoard{
    private int[][]board;
    private int solutionCount;
    
    public QueenBoard(int size){
	board = new int[size][size];
        solutionCount = -1;
    }

    /**
     *precondition: board is filled with 0's only.
     *@return false when the board is not solveable. true otherwise.
     *postcondition: 
     *if false: board is still filled with 0's
     *if true: board is filled with the 
     *final configuration of the board after adding 
     *all n queens. Uses solveH
     */
    public void solve(){
	solveH(0);
    }

    private boolean solveH(int col){
        if (col >= board.length){
            return true;
        }
        int num = -1;
        for (int row = 0; row < board.length; row ++){
            if (board[row][col] < 0){
                num = removeQueen(row, col);
                break;
            }
            else if (board[row][col] == 0){
                num = row;
                break;
            }
        }
        if (num >= 0){
            addQueen(num, col);
            return solveH(col + 1);
        }
        if (col == 0){
            return false;
        }
        return solveH(col - 1);
    }

    private int removeQueen(int r, int c){
        for (int i = 0; i < board.length; i ++){
            board[i][c] --;
            board[r][i] --;
        }
        int counter = 0;
        while (r - counter >= 0 && c - counter >= 0){
            board[r - counter][c - counter] --;
            counter ++;
        }
        counter = 0;
        while (r + counter < board.length && c + counter < board.length){
            board[r + counter][c + counter] --;
            counter ++;
        }
        counter = 0;
        while (r - counter >= 0 && c + counter < board.length){
            board[r - counter][c + counter] --;
            counter ++;
        }
        counter = 0;
        while (r + counter < board.length && c - counter >= 0){
            board[r + counter][c - counter] --;
            counter ++;
        }
        board[r][c] = 0;
        int returned = -1;
        for (int i = 0; i < board.length; i ++){
            if (board[i][c] == 0 && i > r){
                returned = i;
                break;
            }
        }
        return returned;
    }

    private void addQueen(int r, int c){
        for (int i = 0; i < board.length; i ++){
            board[i][c] ++;
            board[r][i] ++;
        }
        int counter = 0;
        while (r - counter >= 0 && c - counter >= 0){
            board[r - counter][c - counter] ++;
            counter ++;
        }
        counter = 0;
        while (r + counter < board.length && c + counter < board.length){
            board[r + counter][c + counter] ++;
            counter ++;
        }
        counter = 0;
        while (r - counter >= 0 && c + counter < board.length){
            board[r - counter][c + counter] ++;
            counter ++;
        }
        counter = 0;
        while (r + counter < board.length && c - counter >= 0){
            board[r + counter][c - counter] ++;
            counter ++;
        }
        board[r][c] = -1;
    }

    /**
     *@return the number of solutions found, or -1 if the board was never solved.
     *The board should be reset after this is run.    
     */
    public int getSolutionCount(){
    	return solutionCount;
    }

    public void countSolutions(){
	if (board.length == 2 || board.length == 3){
	    solutionCount = -1;
	}
	else {
	    solve();
	    solutionCount ++;
	    boolean hello = true;
	    while (hello){
		hello = solveH(board.length - 1);
		solutionCount ++;
	    }
	}
    }

    /**toString
     *and all nunbers that represent queens are replaced with 'Q' 
     *all others are displayed as underscores '_'
     */
    public String toString(){
    	String returned = "";
        for (int i = 0; i < board.length; i ++){
            for (int j = 0; j < board.length; j ++){
                if (board[i][j] == -1){
                    returned += "Q ";
                }
                else{
                    returned += "_ ";
                }
            }
            returned += "\n";
        }
        return returned;
    }

    private String debugger(){
        String returned = "";
        for (int i = 0; i < board.length; i ++){
            for (int j = 0; j < board.length; j ++){
                returned = returned + board[i][j] + " ";
            }
            returned += "\n";
        }
        return returned;
    }

}
