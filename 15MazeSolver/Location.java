public class Location implements Comparable<Location>{

    int row, col, dstart, dgoal;
    Location prev;
    boolean astar;

    public Location(){}

    public Location(int r, int c, Location previous, int distToStart, int distToGoal, boolean aStar){
        row = r;
        col = c;
        prev = previous;
        dstart = distToStart;
        dgoal = distToGoal;
        astar = aStar;
    }

    public int getRow(){
        return row;
    }

    public int getCol(){
        return col;
    }

    public boolean getBool(){
        return astar;
    }

    public Location getPrev(){
        return prev;
    }

    public void setBool(boolean bool){
        astar = bool;
    }

    public int getDist(){
        return dstart;
    }

    public int compareTo(Location other){
        if (astar) return (dstart + dgoal) - (other.dstart + other.dgoal);
        return dgoal - other.dgoal;
    }

    public String toString(){
        if (astar) return dgoal + dstart + "";
        return "" + dgoal;
    }

}