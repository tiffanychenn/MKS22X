import java.util.*;

public class Driver{

    public static void main(String[] args){
        int[] ary1 = makeRandomizedArray(args[0]);
        int[] ary2 = makeDuplicateArray(args[0]);
        int[] ary3 = makeSameArray(args[0]);
        int[] ary4 = makeSortedArray(args[0]);
        int[] ary5 = makeReverseArray(args[0]);
        Quick.quicksort(ary1);
        Quick.quicksort(ary2);
        Quick.quicksort(ary3);
        Quick.quicksort(ary4);
        Quick.quicksort(ary5);
        if (isSorted(ary1)) System.out.println("yes");  
        if (isSorted(ary2)) System.out.println("yes");
        if (isSorted(ary3)) System.out.println("yes");
        if (isSorted(ary4)) System.out.println("yes");
        if (isSorted(ary5)) System.out.println("yes");
    }

    public static int[] makeRandomizedArray(String s){
        int a = Integer.parseInt(s);
        Random rand = new Random();
        int[] temp = new int[a];
        for (int i = 0; i < a; i ++){
            temp[i] = rand.nextInt();
        }
        return temp;
    }

    public static int[] makeDuplicateArray(String s){
        int a = Integer.parseInt(s);
        Random rand = new Random();
        int[] temp = new int[a];
        for (int i = 0; i < a; i ++){
            temp[i] = rand.nextInt(10);
        }
        return temp;
    }

    public static int[] makeSameArray(String s){      
        int a = Integer.parseInt(s);
        int[] temp = new int[a];
        for (int i = 0; i < a; i ++){
            temp[i] = 578927;
        }
        return temp;
    }

    public static int[] makeSortedArray(String s){
        int a = Integer.parseInt(s);
        int[] temp = new int[a];
        for (int i = 0; i < a; i ++){
            temp[i] = i;
        }
        return temp;
    }

    public static int[] makeReverseArray(String s){   
        int a = Integer.parseInt(s);
        int[] temp = new int[a];
        for (int i = 0; i < a; i ++){
            temp[i] = a - i;
        }
        return temp;
    }

    public static boolean isSorted(int[] a){
        for (int i = 0; i < a.length - 1; i ++){
            if (a[i] > a[i+1]) return false;
        }
        return true;
    }

}
