import java.util.*;

public class Quick{

    private static void swap (int[] ary, int i, int j){
        int tempy = ary[i];
        ary[i] = ary[j];
        ary[j] = tempy;
    }

    public static int quickselect(int[] data, int k){
        return quickselectH(data, k, 0, data.length - 1);
    }

    private static int quickselectH(int[] data, int k, int start, int end){
        if (end <= start) return data[end];
        Random rand = new Random();
        int r = rand.nextInt(end - start) + start;
        if (r == start) r ++;
        int v = data[r];
        swap(data, start, r);
        int i = start;
        int lt = start + 1;
        int gt = end;
        while (i <= gt){
            if (data[i] == v){
                i ++;
            }
            else if (data[i] > v){
                swap(data, i, gt);
                gt --;
            }
            else {
                swap(data, lt, i);
                lt ++; i ++;
            }
        }
        if (k < lt){
            return quickselectH(data, k, start, lt - 1);
        }
        else if (k > gt){
            return quickselectH(data, k, gt + 1, end);
        }
        else return data[k];
    }

    public static void quicksort(int[] data){
        quicksortH(data, 0, data.length - 1);
    }

    private static void quicksortH(int[] data, int start, int end){
        if (start < end){
            Random rand = new Random();
            int r = rand.nextInt(end - start) + start;
            if (r == start) r ++;
            int v = data[r];
            swap(data, start, r);
            int i = start;
            int lt = start + 1;
            int gt = end;
            while (i <= gt){
                if (data[i] == v){
                    i ++;
                }
                else if (data[i] > v){
                    swap(data, i, gt);
                    gt --;
                }
                else {
                    swap(data, lt, i);
                    lt ++; i ++;
                }
            }
            quicksortH(data, start, lt - 1);
            quicksortH(data, gt + 1, end);
        }
    }

    public static void main(String[] args){
        int[] ary = new int[100];
        for (int i = 0; i < ary.length; i ++){
            ary[i] = 3;
        }
        ary[0] = 9;
        System.out.println(toString(ary));
        quicksort(ary);
        System.out.println(toString(ary));
        /*System.out.println(quickselect(ary, 621873));
        System.out.println(quickselect(ary, 367187));
        System.out.println(quickselect(ary, 218)); 
        System.out.println(quickselect(ary, 33175)); 
        System.out.println(quickselect(ary, 4316));*/
    }

    private static String toString(int[] ary){
        String s = "[";
        for (int i = 0; i < ary.length; i ++){
            s = s + " " + ary[i];
        }
        return s + " ]";
    }

}