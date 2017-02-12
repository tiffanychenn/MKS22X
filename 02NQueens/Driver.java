public class Driver{
	
	public static void main(String[] args){
		QueenBoard n = new QueenBoard(5);
		n.solve();
		System.out.println(n.toString());
		System.out.println(n.getSolutionCount());
	}

}