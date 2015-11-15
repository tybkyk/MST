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
	static int[][] weight2 = {
			   {MAX,   4, MAX, MAX, MAX, MAX, MAX,   8, MAX},  
			   {  4, MAX,   8, MAX, MAX, MAX, MAX,  11, MAX},  
			   {MAX,   8, MAX,   7, MAX,   4, MAX, MAX,   2},  
			   {MAX, MAX,   7, MAX,   9,  14, MAX, MAX, MAX},  
			   {MAX, MAX, MAX,   9, MAX,  10, MAX, MAX, MAX},
			   {MAX, MAX,   4,  14,  10, MAX,   2, MAX, MAX},
			   {MAX, MAX, MAX, MAX, MAX,   2, MAX,   1,   6},
			   {  8,  11, MAX, MAX, MAX, MAX,   1, MAX,   7},
			   {MAX, MAX,   2, MAX, MAX, MAX,   6,   7, MAX}
			 };
	public static void main(String args[]) {
		
		Kruskal kruskal = new Kruskal(weight2);
		
		long time1 = System.currentTimeMillis();
		kruskal.generateEdgeResult();
		long time2 = System.currentTimeMillis();
		System.out.println("Kruskal time: " + (time2 - time1) + "ms") ;
		long t1=System.currentTimeMillis();
		new Prim(weight2);
		long t2=System.currentTimeMillis();
		System.out.println("Prim time: " + (t2 - t1) + "ms");

	}
}	
