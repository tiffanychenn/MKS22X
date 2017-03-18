import java.util.*;

public class Quick{

    public static int part(int[] ary, int start, int end){
        Random rand = new Random();
        int r = rand.nextInt(end - start) + start;
        if (r == end) r --;
        int compare = ary[r];
        int counterS = start;
        int counterE = end - 1;
        int tempy = ary[end];
        ary[end] = compare;
        ary[r] = tempy;
        while (counterS != counterE && counterE != counterS + 1 && counterE != counterS - 1){
            if (ary[counterS] > compare && ary[counterE] < compare){
                tempy = ary[counterE];
                ary[counterE] = ary[counterS];
                ary[counterS] = tempy;
                counterE --;
                counterS ++;
            }
            else if (ary[counterS] > compare) counterE --;
            else if (ary[counterE] < compare) counterS ++;
            else {
                counterE --;
                counterS ++;
            }
            //System.out.println(toString(ary));
        }
        if (counterE != counterS){
            if (ary[counterS] > ary[counterE]){
                tempy = ary[counterE];
                ary[counterE] = ary[counterS];
                ary[counterS] = tempy;
            }
        }
        while (ary[counterS] < compare){
            counterS ++;
        }
        tempy = ary[counterS];
        ary[counterS] = compare;
        ary[end] = tempy;
        return counterS;
    }

    public static int quickselect(int[] data, int k){
        return quickselectH(data, k, 0, data.length - 1);
    }

    private static int quickselectH(int[] data, int k, int start, int end){
        if (end == start) return data[end];
        int pivot = part(data, start, end);
        if (pivot == k) return data[pivot];
        else if (pivot > k) return quickselectH(data, k, 0, pivot - 1);
        else return quickselectH(data, k, pivot + 1, data.length - 1);
    }

    public static void quicksort(int[] data){
        quicksortH(data, 0, data.length - 1);
    }

    private static void quicksortH(int[] data, int start, int end){
        if (start < end){
            int pivot = part(data, start, end);
            quicksortH(data, start, pivot - 1);
            quicksortH(data, pivot + 1, end);
        }
    }

    public static void main(String[] args){
        int[] ary = {2, 10, 15, 23, 0, 5};
        quicksort(ary);
        System.out.println(toString(ary));
        //System.out.println(quickselect(ary, 0)); //would return 0
        //System.out.println(quickselect(ary, 1)); //would return 2
        //System.out.println(quickselect(ary, 2)); //would return 5
        //System.out.println(quickselect(ary, 3)); //would return 10
        //System.out.println(quickselect(ary, 4)); //would return 15
    }

    public static String toString(int[] ary){
        String s = "[";
        for (int i = 0; i < ary.length; i ++){
            s = s + " " + ary[i];
        }
        return s + " ]";
    }

}