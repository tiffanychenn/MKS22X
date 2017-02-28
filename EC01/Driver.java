public class Driver{

    public static void main(String[] args){
    	for (int i = 0; i < 8; i ++){
    		for (int j = 0; j < 8; j ++){
    			KnightBoard k = new KnightBoard(i, j);
    			k.solve();
    			System.out.println(i); System.out.println(j); System.out.println(k);
    		}
    	}
    }

}
