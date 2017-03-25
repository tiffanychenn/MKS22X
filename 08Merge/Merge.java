public class Merge{

    public static void mergesort(int[] ary){
        int[] temp = mergeH(ary, 0, ary.length - 1);
        copy(ary, temp);
    }

    private static int[] mergeH(int[] ary, int start, int end){
        if (start == end) {
            int[] a = {ary[start]};
            return a;
        }
        int[] a = mergeH(ary, start, (start + end) / 2);
        int[] b = mergeH(ary, (start + end) / 2 + 1, end);
        int[] temp = sort(a, b);
        return temp;
    }

    private static int[] sort(int[] a, int[] b){
        int[] temp = new int[a.length + b.length];
        int counterA = 0, counterB = 0;
        for (int i = 0; i < temp.length; i ++){
            if (counterA == a.length){
                temp[i] = b[counterB];
                counterB ++;
            }
            else if (counterB == b.length) {
                temp[i] = a[counterA];
                counterA ++;
            }
            else if (a[counterA] > b[counterB]){
                temp[i] = b[counterB];
                counterB ++;
            }
            else {
                temp[i] = a[counterA];
                counterA ++;
            }
        }
        return temp;
    }

    private static void copy(int[] a, int[] b){
        for (int i = 0; i < b.length; i ++){
            a[i] = b[i];
        }
    }

    public static void main(String[] args){
        int[] data = {37, 18, 9, 0, 1389, 16, 37, 4791, 381, 547, 37, 1, 498, 57, 19, 29, 47, 35, 52, 59, 1, 14, 48, 791, 1397, 79245, 1479, 489, 2497};
        mergesort(data);
        System.out.println(toString(data));
    }

    private static String toString(int[] ary){
        String s = "[";
        for (int i = 0; i < ary.length; i ++){
            s = s + " " + ary[i];
        }
        return s + " ]";
    }

}