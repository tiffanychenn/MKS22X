public class QueenBoard{
    private int[][]board;
    private int solutionCount;
    
    public QueenBoard(int size){
	    board = new int[size][size];
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
    public boolean solve(){
	    return solveH(0);
    }

    private boolean solveH(int col){
	    if (col >= board.length){
            return true;
        }
        int num = -1;
        for (int row = 0; row < board.length; row ++){
            int what = board[row][col];
            if (what < 0){
                num = removeDangerSpots(row, col);
                continue;
            }
            else if (what == 0){
                num = i;
                continue;
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
            counter --;
        }
        counter = 0;
        while (r + counter < board.length && c + counter < board.length){
            board[r + counter][c + counter] --;
            counter --;
        }
        int returned = -1;
        for (int i = 0; i < board.length; i ++){
            if (board[i][c] == 0 && i != r){
                returned = i;
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
        board[r][c] = -1;
    }

    /**
     *@return the number of solutions found, or -1 if the board was never solved.
     *The board should be reset after this is run.    
     */
    public int getSolutionCount(){
        for (int i = 0; i < board.length; i ++){
            for (int j = 0; j < board.length; j ++){
                board[i][j] = 0;
            }
        }
    	return -1;
    }

    public boolean countSolutions(){
        return getSolutionCount() > 0;
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

}