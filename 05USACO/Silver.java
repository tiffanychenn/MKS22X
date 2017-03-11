import java.util.*;
import java.io.*;

public class Silver{

    private int[][] map;
    private int[] start, end;
    private int time;

    public Silver(String filename){
        readFile(filename);
    }

    private void readFile(String filename){
        try {
            File f = new File(filename);
            Scanner s = new Scanner(f);
            map = new int[s.nextInt()][s.nextInt()];
            time = s.nextInt();
            for (int i = 0; i < map.length; i ++){
                String b = s.next();
                for (int j = 0; j < map[0].length; j ++){
                    if (b.charAt(j) == '.'){
                        map[i][j] = 0;
                    }
                    else {
                        map[i][j] = -1;
                    }
                }
            }
            start = new int[2];
            start[0] = s.nextInt() - 1;
            start[1] = s.nextInt() - 1;
            end = new int[2];
            end[0] = s.nextInt() - 1;
            end[1] = s.nextInt() - 1;
        }
        catch (Exception e){
            System.out.println(e);
            System.exit(1);
        }
    }

    public int mooves(){
        map[start[0]][start[1]] = 1;
        int mod = (start[0] + start[1]) % 2;
        int[][] temp = map;
        while (time > 0){
            mod ++;
            mod = mod % 2;
            for (int i = 0; i < temp.length; i ++){
                for (int j = 0; j < temp[0].length; j ++){
                    if (temp[i][j] == -1){
                        continue;
                    }
                    if (mod == (i + j) % 2){
                        temp[i][j] = add(i + 1, j) + add(i - 1, j) + add(i, j + 1) + add(i, j - 1);
                    }
                }
            }
            for (int i = 0; i < temp.length; i ++){
                for (int j = 0; j < temp[0].length; j ++){
                    if ((i + j) % 2 != mod && temp[i][j] != -1){
                        temp[i][j] = 0;
                     }
                }
            }
            map = temp;
            time --;
        }
        return temp[end[0]][end[1]];
    }

    private int add(int i, int j){
        if (i < 0 || i >= map.length || j < 0 || j >= map[0].length || map[i][j] == -1){
            return 0;
        }
        return map[i][j];
    }

}