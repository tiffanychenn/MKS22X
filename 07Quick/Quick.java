import java.util.*;

public class Quick{

    private static void swap (int[] ary, int i, int j){
        int tempy = ary[i];
        ary[i] = ary[j];
        ary[j] = tempy;
    }

    public static int part(int[] ary, int start, int end){
        Random rand = new Random();
        int r = rand.nextInt(end - start) + start;
        if (r == end) r --;
        int compare = ary[r];
        int counterS = start;
        int counterE = end - 1;
        swap(ary, end, r);
        while (counterS <= counterE){
            if (ary[counterS] < compare){
                counterS ++;
            }
            else {
                swap(ary, counterS, counterE);
                counterE --;
            }
        }
        swap(ary, end, counterS);
        return counterS;
    }

    public static int quickselect(int[] data, int k){
        return quickselectH(data, k, 0, data.length - 1);
    }

    private static int quickselectH(int[] data, int k, int start, int end){
        if (end <= start) return data[end];
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
        int[] ary = {5, 10, 0, 15, 2};
        System.out.println(quickselect(ary, 0)); //would return 0
        System.out.println(quickselect(ary, 1)); //would return 2
        System.out.println(quickselect(ary, 2)); //would return 5
        System.out.println(quickselect(ary, 3)); //would return 10
        System.out.println(quickselect(ary, 4)); //would return 15
    }

    public static String toString(int[] ary){
        String s = "[";
        for (int i = 0; i < ary.length; i ++){
            s = s + " " + ary[i];
        }
        return s + " ]";
    }

}