public class Driver{

    public static void main(String[] args){
	KnightBoard k = new KnightBoard(16, 16);
	k.solveFast();
	System.out.println(k.toString());
    }

}
