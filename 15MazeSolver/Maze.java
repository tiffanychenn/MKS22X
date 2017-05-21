import java.io.*;
import java.io.FileNotFoundException;
import java.util.*;
public class Maze{
  private static final String CLEAR_SCREEN =  "\033[2J";
  private static final String HIDE_CURSOR =  "\033[?25l";
  private static final String SHOW_CURSOR =  "\033[?25h";

  Location start,end;
  private char[][]maze;
  private boolean animate;
  private int maxRows,maxCols;

  private static String go(int x,int y){
    return ("\033[" + x + ";" + y + "H");
  }
  private static String color(int foreground,int background){
    return ("\033[0;" + foreground + ";" + background + "m");
  }
  private void wait(int millis){
    try {
      Thread.sleep(millis);
    }
    catch (InterruptedException e) {
    }
  }
  public void clearTerminal(){
    System.out.println(CLEAR_SCREEN+"\033[1;1H");
  }
  public Maze(String filename){
    this(filename,false);
  }
  public Maze(String filename, boolean b){
    animate = b;
    ArrayList<char[]> lines = new ArrayList<char[]>();
    int startr=-1, startc=-1;
    int endr=-1,endc=-1;
    try{
      Scanner in = new Scanner(new File(filename));
      while(in.hasNext()){
        lines.add(in.nextLine().toCharArray());
      }
    }catch(FileNotFoundException e){
      System.out.println("File not found: "+filename);
      System.exit(1);
    }
    maze = new char[lines.size()][];
    for(int i = 0; i < maze.length; i++){
      maze[i]=lines.get(i);
    }
    for(int r=0; r<maze.length;r++){
      for(int c=0; c<maze[r].length;c++){
        if(maze[r][c]=='S'){
          if(startr == -1){
            startr=r;
            startc=c;
          }else{
            System.out.println("Multiple 'S' found!");
            System.exit(0);
          }
        }
        if(maze[r][c]=='E'){
          if(endr == -1){
            endr=r;
            endc=c;
          }else{
            System.out.println("Multiple 'E' found!");
            System.exit(0);
          }
        }
      }
    }
    if(startr == -1 || endr == -1){
      System.out.println("Missing 'S' or 'E' from maze.");
      System.exit(0);

    }
    maxRows = maze.length;
    maxCols = maze[0].length;
    //IF YOU GET HERE, there is 1 start, and 1 end. The coords are in
    //startr,startc
    //endr,endc
    //you must initialize the Location start/end now!
  }

  public String toString(){
    int maxr = maze.length;
    int maxc = maze[0].length;
    String ans = "";
    for(int i = 0; i < maxr * maxc; i++){
      int row = i/maxc;
      int col = i%maxc;

      char c =  maze[row][col];
      ans+=c;
      if( col == maxc-1 ){
        ans += "\n";
      }

    }
    return ans + "\n";
  }


  public static String colorize(String s){
    String ans = "";
    Scanner in = new Scanner(s);
    while(in.hasNext()){
        String line ="";
          for(char c : in.nextLine().toCharArray()){
            if(c == '#'){
              line+= color(37,47)+c;
            }
            else if(c == '@'){
              line+= color(36,40)+c;
            }
            else if(c == '?'){
              line+= color(36,40)+c;
            }
            else if(c == '.'){
              line+= color(32,40)+c;
            }
            else if(c == ' '){
              line+= color(35,40)+c;
            }else{
              line+=color(37,40)+c;
            }

          }
        ans += line+color(37,40)+"\n";
    }
    return ans;
  }
}
