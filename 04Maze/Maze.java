import java.util.*;
import java.io.*;

public class Maze{

    private char[][] maze;
    private boolean animate;

    /*Constructor loads a maze text file, and sets animate to false by default.
      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - locations that cannot be moved onto
      ' ' - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)

      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!
      3. When the file is not found OR there is no E or S then: print an error and exit the program.

    */

    public Maze(String filename){
        readFile(filename);
        animate = false;
        boolean e = false, s = false;
        for (int i = 0; i < maze.length; i ++){
            for (int j = 0; j < maze[0].length; j ++){
                if (maze[i][j] == 'E'){
                    e = true;
                }
                if (maze[i][j] == 'S'){
                    s = true;
                }
            }
        }
        if (!(s && e)){
            throw new IllegalArgumentException("file must contain a start (S) and an end (E) of the maze.");
        }
    }

    private void readFile(String file){
        try {
            Scanner sc = new Scanner(new File(file));
            int counter = 1;
            char[][] temp = new char[100][sc.nextLine().length()];
            for (int i = 0; i < temp[0].length; i ++){
                temp[0][i] = '#';
            }
            while (sc.hasNextLine()){
                char[] ary = sc.nextLine().toCharArray();
                temp[counter] = ary;
                counter ++;
            }
            for (int i = 1; i < temp.length; i ++){
                if (!(temp[i][0] == ' ' || temp[i][0] == '#' || temp[i][0] == 'S' || temp[i][0] == 'E')){
                    maze = new char[i][temp[0].length];
                    break;
                }
            }
            for (int i = 0; i < maze.length; i ++){
                maze[i] = temp[i];
            }
        }
        catch (Exception e){
            System.out.println(e);
            System.exit(1);
        }
    }
    
    private void wait(int millis){ //ADDED SORRY!
        try {
            Thread.sleep(millis);
        }
        catch (InterruptedException e){}
    }

    public void setAnimate(boolean b){
        animate = b;
    }

    public void clearTerminal(){
        //erase terminal, go to top left of screen.
        System.out.println("\033[2J\033[1;1H");
    }

    /* Wrapper Solve Function
       Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
    public boolean solve(){
        int startr = -1, startc = -1;
        for (int i = 0; i < maze.length; i ++){
            for (int j = 0; j < maze[0].length; j ++){
                if (maze[i][j] == 'S'){
                    startr = i;
                    startc = j;
                }
            }
        }
        maze[startr][startc] = ' ';
        return solve(startr, startc);
    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns true when the maze is solved,
      Returns false when the maze has no solution.

      Postcondition:

      The S is replaced with '@' but the 'E' is not.

      All visited spots that were not part of the solution are changed to '.'
      All visited spots that are part of the solution are changed to '@'
    */

    private boolean solve(int row, int col){
        if (animate){
            System.out.println("\033[2J\033[1;1H" + this);
            wait(20);
        }
        if (maze[row][col] == 'E'){
            return true;
        }
        if (maze[row][col] != ' '){
            return false;
        }
        maze[row][col] = '@';
        if (!(solve(row + 1, col) || solve(row - 1, col) || solve(row, col + 1) || solve(row, col - 1))){
            maze[row][col] = '.';
            if (maze[row + 1][col] == '@'){
                maze[row + 1][col] = ' ';
                return solve(row + 1, col);
            }
            else if (maze[row - 1][col] == '@'){
                maze[row - 1][col] = ' ';
                return solve(row - 1, col);
            }
            else if (maze[row][col + 1] == '@'){
                maze[row][col + 1] = ' ';
                return solve(row, col + 1);
            }
            else if (maze[row][col - 1] == '@'){
                maze[row][col - 1] = ' ';
                return solve(row, col - 1);
            }
            return false;
        }
        return true;
    }

    public String toString(){
        String s = "";
        for (int i = 0; i < maze.length; i ++){
            for (int j = 0; j < maze[0].length; j ++){
                s += maze[i][j];
            }
            s += "\n";
        }
        return s;
    }


}
