import java.util.*;
import java.io.*;

public class Bronze{

  private String textBuffer;
  private int[][] steps;
  private int[][] lake;
  private int row;
  private int col;
  private int e;
  private int n;

  public void loadFile(String name) throws FileNotFoundException{
      File infile = new File(name);
      Scanner inf = new Scanner(infile);
      while(inf.hasNextLine()){
        String line = inf.nextLine();
        textBuffer += line + "\n";  
      }   
  }

  public Bronze(String name){
    try{
      loadFile(name);
    }
    catch(FileNotFoundException e){
      System.exit(0);
    }
    String[] temp = textBuffer.split("\n");
    row = Integer.parseInt(temp[0].split(" ")[0].substring(4));
    col = Integer.parseInt(temp[0].split(" ")[1]);
    e = Integer.parseInt(temp[0].split(" ")[2]);
    n = Integer.parseInt(temp[0].split(" ")[3]);
    steps = new int[temp.length - row - 1][3];
    lake = new int[row][col];
    for(int lineNumber = 1; lineNumber < row + 1; lineNumber ++){
      String[] buff;
      buff = temp[lineNumber].split(" ");
      for(int columnNumber = 0; columnNumber < col; columnNumber ++){
        lake[lineNumber - 1][columnNumber] = Integer.parseInt(buff[columnNumber]);
      }
    }
    for(int lineNumber = row  + 1; lineNumber < temp.length; lineNumber ++){
      String[] buff;
      buff = temp[lineNumber].split(" ");
      steps[lineNumber - row - 1][0] = Integer.parseInt(buff[0]);
      steps[lineNumber - row - 1][1] = Integer.parseInt(buff[1]);
      steps[lineNumber - row - 1][2] = Integer.parseInt(buff[2]);
    }
  }
    

  public void makeLake(){
    for(int step = 0; step < steps.length; step ++){
      for(int i = 0; i < steps[step][2]; i ++){
        int roww = steps[step][0];
        int coll = steps[step][1];
        int large = findLargest(roww, coll);
        for(int r = roww - 1; r < roww + 2; r ++){
          for(int c = coll - 1; c < coll + 2; c ++){
            if(lake[r][c] == large) lake[r][c] --;
          }
        }
      }
    }
  }

  private int findLargest(int roww, int coll){
    int largest = 0;
    for (int r = roww - 1; r < roww + 2; r ++){
      for (int c = coll - 1; c < coll + 2; c ++){
        if (lake[r][c] > largest){
          largest = lake[r][c];
        }
      }
    }
    return largest;
  }

  public int volume(){
    int totalDepth = 0;
    for (int i = 0; i < lake.length; i ++){
      for (int j = 0; j < lake[0].length; j ++){
        if (e - lake[i][j] > 0){
          totalDepth += e - lake[i][j];
        }
      }
    }
    return 72 * 72 * totalDepth;
  }

}