public class Driver{
	
	public static void main(String[] args){
		QueenBoard n = new QueenBoard(4);
		//n.solve();
		//System.out.println(n);
		n.countSolutions();
		System.out.println(n.getSolutionCount());
	}

}
