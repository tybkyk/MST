package MST;

public class MST {
	static int MAX = Integer.MAX_VALUE;
	static int[][] weight = {
			   {MAX, 6, 9, 5, 13},  
			   {6, MAX, 6,7,8},  
			   {9,6,MAX,9,3},  
			   {5,7,9,MAX,3},  
			   {13,8,3,3,MAX}  
			 };
	public static void main(String args[]) {
		
		Kruskal kruskal = new Kruskal(weight);
		
		Prim prim = new Prim();
		prim.prim();
	}
}	
