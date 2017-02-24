public class Driver{

    public static void main(String[] args){
    	for (int i = 45; i < 60; i ++){
    		KnightBoard k = new KnightBoard(50, 50);
    		k.solveFast();
    		System.out.println(i); System.out.println(k);
    	}
    }

}
