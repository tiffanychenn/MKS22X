import java.util.*;

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
        board.set(board.getStart().getRow(), board.getStart().getCol(), 'S');
        board.set(board.getEnd().getRow(), board.getEnd().getCol(), 'E');
        if (style == 0){
            StackFrontier frontier = new StackFrontier();
            frontier.add(board.getStart());
            while (frontier.size() > 0 && (frontier.peek().getRow() != board.getEnd().getRow() || frontier.peek().getCol() != board.getEnd().getCol())){
                if (pretty) System.out.println(toString());
                Location now = frontier.next();
                ArrayList<Location> possible = possibilities(now, 0);
                for (int i = 0; i < possible.size(); i ++){
                    frontier.add(possible.get(i));
                }
                if (possible.size() == 0){
                    while ((frontier.size() == 0 && now != board.getStart()) || (frontier.size() > 0 && frontier.peek().getPrev() != now)){
                        board.set(now.getRow(), now.getCol(), '.');
                        now = now.getPrev();
                    }
                }
            }
        }
        else if (style == 1){
            QueueFrontier frontier = new QueueFrontier();
            frontier.add(board.getStart());
            while (frontier.size() > 0 && (frontier.peek().getRow() != board.getEnd().getRow() || frontier.peek().getCol() != board.getEnd().getCol())){
                if (pretty) System.out.println(toString());
                Location now = frontier.next();
                ArrayList<Location> possible = possibilities(now, 1);
                for (int i = 0; i < possible.size(); i ++){
                    frontier.add(possible.get(i));
                }
            }
            if (frontier.size() > 0 && frontier.peek().getRow() == board.getEnd().getRow() && frontier.peek().getCol() == board.getEnd().getCol()){
                Location noww = frontier.next().getPrev();
                while (noww != board.getStart()){
                    board.set(noww.getRow(), noww.getCol(), '@');
                    noww = noww.getPrev();
                }
            }
        }
        else if (style == 2){
            PriorityQueueFrontier frontier = new PriorityQueueFrontier();
            frontier.add(board.getStart());
            while (frontier.size() > 0 && (frontier.peek().getRow() != board.getEnd().getRow() || frontier.peek().getCol() != board.getEnd().getCol())){
                if (pretty) System.out.println(toString());
                Location now = frontier.next();
                ArrayList<Location> possible = possibilities(now, 1);
                for (int i = 0; i < possible.size(); i ++){
                    frontier.add(possible.get(i));
                }
            }
            if (frontier.size() > 0 && frontier.peek().getRow() == board.getEnd().getRow() && frontier.peek().getCol() == board.getEnd().getCol()){
                Location noww = frontier.next().getPrev();
                while (noww != board.getStart()){
                    board.set(noww.getRow(), noww.getCol(), '@');
                    noww = noww.getPrev();
                }
            }
        }
        else if (style == 3){
            PriorityQueueFrontier frontier = new PriorityQueueFrontier();
            board.getStart().setBool(true);
            frontier.add(board.getStart());
            while (frontier.size() > 0 && (frontier.peek().getRow() != board.getEnd().getRow() || frontier.peek().getCol() != board.getEnd().getCol())){
                if (pretty) System.out.println(toString());
                Location now = frontier.next();
                ArrayList<Location> possible = possibilities(now, 1);
                for (int i = 0; i < possible.size(); i ++){
                    frontier.add(possible.get(i));
                }
            }
            if (frontier.size() > 0 && frontier.peek().getRow() == board.getEnd().getRow() && frontier.peek().getCol() == board.getEnd().getCol()){
                Location noww = frontier.next().getPrev();
                while (noww != board.getStart()){
                    board.set(noww.getRow(), noww.getCol(), '@');
                    noww = noww.getPrev();
                }
            }
        }
        board.set(board.getEnd().getRow(), board.getEnd().getCol(), 'E');
        System.out.println(toString());
    }

    public String toString(){
        if (pretty){
            return board.toString(200);
        }
        return board.toString();
    }

    // helper function!!! -> returns a list of possible locations to go to

    private ArrayList<Location> possibilities(Location l, int style){
        if (l != board.getStart() && style == 0) board.set(l.getRow(), l.getCol(), '@');
        else if (l!= board.getStart()) board.set(l.getRow(), l.getCol(), '.');
        ArrayList<Location> temp = new ArrayList<Location>();
        if (board.get(l.getRow() + 1, l.getCol()) == ' ' || board.get(l.getRow() + 1, l.getCol()) == 'E'){
            temp.add(new Location(l.getRow() + 1, l.getCol(), l, l.getDist() + 1, distToEnd(l.getRow() + 1, l.getCol()), l.getBool()));
            board.set(l.getRow() + 1, l.getCol(), '?');
        }
        if (board.get(l.getRow() - 1, l.getCol()) == ' ' || board.get(l.getRow() - 1, l.getCol()) == 'E'){
            temp.add(new Location(l.getRow() - 1, l.getCol(), l, l.getDist() + 1, distToEnd(l.getRow() - 1, l.getCol()), l.getBool()));
            board.set(l.getRow() - 1, l.getCol(), '?');
        }
        if (board.get(l.getRow(), l.getCol() + 1) == ' ' || board.get(l.getRow(), l.getCol() + 1) == 'E'){
            temp.add(new Location(l.getRow(), l.getCol() + 1, l, l.getDist() + 1, distToEnd(l.getRow(), l.getCol() + 1), l.getBool()));
            board.set(l.getRow(), l.getCol() + 1, '?');
        }
        if (board.get(l.getRow(), l.getCol() - 1) == ' ' || board.get(l.getRow(), l.getCol() - 1) == 'E'){
            temp.add(new Location(l.getRow(), l.getCol() - 1, l, l.getDist() + 1, distToEnd(l.getRow(), l.getCol() - 1), l.getBool()));
            board.set(l.getRow(), l.getCol() - 1, '?');
        }
        return temp;
    }

    // helper function!!! -> returns the Manhattan distance to the end

    private int distToEnd(int row, int col){
        return Math.abs(row - board.getEnd().getRow()) + Math.abs(col - board.getEnd().getCol());
    }

}