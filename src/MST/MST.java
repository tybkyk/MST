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
		
		long t1=System.currentTimeMillis();
		Prim prim = new Prim();
		prim.prim();
		long t2=System.currentTimeMillis();
		System.out.println(t2-t1);

	}
}	
