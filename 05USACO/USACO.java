public class USACO{

	public static void main(String[] args){
		String fileName = args[0];
		Bronze b = new Bronze(fileName);
		b.makeLake();
		System.out.println(b.volume());
	}

}