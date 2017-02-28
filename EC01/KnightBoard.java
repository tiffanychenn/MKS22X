import java.util.*;

public class KnightBoard{

    //variables
    private int[][] board;
    private int[][] numMoves;
    private static final int[] rows = {1, 1, 2, 2, -1, -1, -2, -2};
    private static final int[] cols = {2, -2, 1, -1, 2, -2, 1, -1};

    public KnightBoard(int startingRows,int startingCols){
        board = new int[startingRows][startingCols];
        numMoves = new int[startingRows][startingCols];
        fillNums();
    }

    private void fillNums(){
        for (int row = 0; row < numMoves.length; row ++){
            for (int col = 0; col < numMoves[0].length; col ++){
                int counter = 0;
                for (int i = 0; i < 8; i ++){
                    if (!(row + rows[i] < 0 || col + cols[i] < 0 || row + rows[i] >= numMoves.length || col + cols[i] >= numMoves[0].length)){
                        counter ++;
                    }
                }
                numMoves[row][col] = counter;
            }
        }
    }

    //blank if you never called solve or when there is no solution
    public String toString(){
        String s = "";
        if (!(board.length == 0 || board[0].length == 0) && board[0][0] != 0){
            for (int i = 0; i < board.length; i ++){
                for (int j = 0; j < board[0].length; j ++){
                    if (board[i][j] < 10){
                        s = s + "   " + board[i][j];
                    }
                    else if (board[i][j] < 100){
                        s = s + "  " + board[i][j];
                    }
                    else if (board[i][j] < 1000){
                        s = s + " " + board[i][j];
                    }
                    else{
                        s += board[i][j];
                    }
                    s += " ";
                }
                s += "\n";
            }
        }
        return s;
    }

    public void solve(){
        if (board.length == 0 || board[0].length == 0){
            return;
        }
        solveH(0, 0, 1);
    }

    public void solveFast(){
        if (board.length == 0 || board[0].length == 0){
            return;
        }
        solveFastH(0, 0, 1);
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
            for (int i = 0; i < 8; i ++){
                if (solveH(row + rows[i], col + cols[i], level + 1)){
                    return true;
                }
            }
            board[row][col] = 0;
        }
        return false;
    }

    private boolean solveFastH(int row, int col, int level){
        if (level == board.length * board[0].length){
            board[row][col] = level;
            return true;
        }
        if (row >= board.length || col >= board[0].length){
            return false;
        }
        ArrayList<Moves> moves = new ArrayList<Moves>();
        for (int i = 0; i < 8; i ++){
            if (!(row + rows[i] < 0 || col + cols[i] < 0 || row + rows[i] >= numMoves.length || col + cols[i] >= numMoves[0].length) && numMoves[row + rows[i]][col + cols[i]] > 0){
                Moves movie = new Moves(rows[i], cols[i], numMoves[row + rows[i]][col + cols[i]]);
                int counter = 0;
                for (int j = 0; j < moves.size(); j ++){
                    if (moves.get(j).getMoves() < movie.getMoves()){
                        counter ++;
                    }
                }
                moves.add(counter, movie);
            }
        }
        int placeholder = numMoves[row][col];
        board[row][col] = level;
        numMoves[row][col] = 0;
        for (int j = 0; j < 8; j ++){
            if (!(row + rows[j] < 0 || col + cols[j] < 0 || row + rows[j] >= numMoves.length || col + cols[j] >= numMoves[0].length) && numMoves[row + rows[j]][col + cols[j]] > 0){
                numMoves[row + rows[j]][col + cols[j]] --;
            }
        }
        for (int i = 0; i < moves.size(); i ++){
            if (solveFastH(row + moves.get(i).getRow(), col + moves.get(i).getCol(), level + 1)){
                return true;
            }
        }
        board[row][col] = 0;
        numMoves[row][col] = placeholder;
        for (int j = 0; j < 8; j ++){
            if (!(row + rows[j] < 0 || col + cols[j] < 0 || row + rows[j] >= numMoves.length || col + cols[j] >= numMoves[0].length) && numMoves[row + rows[j]][col + cols[j]] > 0){
                numMoves[row + rows[j]][col + cols[j]] ++;
            }
        }
        return false;
    }

}
