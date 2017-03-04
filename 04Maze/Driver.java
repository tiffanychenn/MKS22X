public class Driver{

    public static void main(String[]args){
        Maze f;
        f = new Maze("data4.dat");//true animates the maze.
        f.setAnimate(true);
        System.out.println(f.solve());
        System.out.println(f);
    }
}
