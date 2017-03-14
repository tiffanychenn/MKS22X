import java.util.*;

public class ArrayFinder{

	public static int partition(int[] ary, int start, int end){
		Random rand = new Random();
		int r = rand.nextInt(end - start) + start;
		if (r == end) r --;
		//System.out.println(r);
		int compare = ary[r];
		int counterS = start;
		int counterE = end - 1;
		int tempy = ary[end];
		ary[end] = compare;
		ary[r] = tempy;
		while (counterS != counterE && counterS <= end - 1 && counterE >= start){
			if (ary[counterS] > compare && ary[counterE] < compare){
				tempy = ary[counterE];
				ary[counterE] = ary[counterS];
				ary[counterS] = tempy;
				counterE --;
				counterS ++;
			}
			else if (ary[counterS] > compare) counterE --;
			else counterS ++;
			//System.out.println(toString(ary));
		}
		if (ary[counterS] > compare || counterS == end){
			tempy = ary[counterS];
			ary[counterS] = compare;
			ary[end] = tempy;
		}
		else {
			tempy = ary[counterS + 1];
			ary[counterS + 1] = compare;
			ary[end] = tempy;
			counterS ++;
		}
		return counterS;
	}

	public static void main(String[] args){
		int[] ary = {3, 1, 5, 9, 10, 0, 8, 2, 4, 7, 6};
		System.out.println(toString(ary));
		int b = partition(ary, 0, ary.length - 1);
		System.out.println(b + ": " + toString(ary));
		b = partition(ary, 0, 5);
		System.out.println(b + ": " + toString(ary));
		b = partition(ary, 3, 9);
		System.out.println(b + ": " + toString(ary));
		b = partition(ary, 7, ary.length - 1);
		System.out.println(b + ": " + toString(ary));
	}

	public static String toString(int[] ary){
		String s = "[";
		for (int i = 0; i < ary.length; i ++){
			s = s + " " + ary[i];
		};
		return s + " ]";
	}

}