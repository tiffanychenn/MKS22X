import java.util.*;
import java.io.*;

public class Silver{

    private int[][] map;
    private int[] start, end;
    private int time;

    public Silver(String filename){
        readFile(filename);
        System.out.println(time)
        System.out.print(start[0] + " "); System.out.println(start[1]);
        System.out.print(end[0] + " "); System.out.println(end[1]);
    }

    private void readFile(String filename){
        Scanner s = new Scanner(filename);
        map = new int[s.nextInt()][s.nextInt()];
        time = s.nextInt();
        for (int i = 0; i < map.length; i ++){
            for (int j = 0; j < map[0].length; j ++){
                if (sc.next() == '.'){
                    map[i][j] = 0;
                }
                else {
                    map[i][j] = -1;
                }
            }
        }
        start = {s.nextInt(), s.nextInt()};
        end = {s.nextInt(), s.nextInt()};
    }

}