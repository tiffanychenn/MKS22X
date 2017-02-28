public class Driver{

    public static void main(String[] args){
    	for (int i = 40; i < 61; i ++){
    		KnightBoard k = new KnightBoard(i, i);
    		k.solveFast();
    		System.out.println(i); System.out.println(k);
    	}
    }

}
