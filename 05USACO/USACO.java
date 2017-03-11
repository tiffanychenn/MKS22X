public class USACO{

	public USACO(){}

	public int bronze(String fileName){
		Bronze b = new Bronze(fileName);
		b.makeLake();
		return b.volume();
	}

	public int silver(String fileName){
		Silver s = new Silver(fileName);
		return s.mooves();
	}

}