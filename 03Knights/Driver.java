public class Driver{

    public static void main(String[] args){
	KnightBoard k = new KnightBoard(8, 8);
	k.solve();
	System.out.println(k.toString());
    }

}
