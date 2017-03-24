import java.util.*;

public class Driver{

    public static void main(String[] args){
	int[] ary1 = makeRandomizedArray(args[0]);
	int[] ary2 = makeDuplicateArray(args[0]);
	int[] ary3 = makeSameArray(args[0]);
	int[] ary4 = makeSortedArray(args[0]);
	int[] ary5 = makeReverseArray(args[0]);
	int[] checker1 = ary1, checker2 = ary2, checker3 = ary3, checker4 = ary4, checker5 = ary5;
	Merge.mergesort(ary1);
	Merge.mergesort(ary2);
	Merge.mergesort(ary3);
	Merge.mergesort(ary4);
	Merge.mergesort(ary5);
	if (ary1.equals(Collections.sort(checker1))) System.out.println("yes");	
	if (ary2.equals(Collections.sort(checker2))) System.out.println("yes");
	if (ary3.equals(Collections.sort(checker3))) System.out.println("yes");
	if (ary4.equals(Collections.sort(checker4))) System.out.println("yes");
	if (ary5.equals(Collections.sort(checker5))) System.out.println("yes");
    }

    public static int[] makeRandomizedArray(String s){
	int a = Integer.parseInt(s);
	Random rand = new Random();
	int[] temp = new int[s];
	for (int i = 0; i < a; i ++){
	    temp[i] = rand.nextInt();
	}
	return temp;
    }

    public static int[] makeDuplicateArray(String s){
	int a = Integer.parseInt(s);
	Random rand = new Random();
	int[] temp = new int[s];
	for (int i = 0; i < a; i ++){
	    temp[i] = rand.nextInt(10);
	}
	return temp;
    }

    public static int[] makeSameArray(String s){      
	int a = Integer.parseInt(s);
	int[] temp = new int[s];
	for (int i = 0; i < a; i ++){
	    temp[i] = 137624789578927;
	}
	return temp;
    }

    public static int[] makeSameArray(String s){
	int a = Integer.parseInt(s);
	int[] temp = new int[s];
	for (int i = 0; i < a; i ++){
	    temp[i] = i;
	}
	return temp;
    }

    public static int[] makeReverseArray(String s){   
	int a = Integer.parseInt(s);
	int[] temp = new int[s];
	for (int i = 0; i < a; i ++){
	    temp[i] = s - i;
	}
	return temp;
    }

}
