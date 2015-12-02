package MST;

public class MST {
	static int MAX = Integer.MAX_VALUE;
	static int[][] graph1 = {
			   {MAX,   6,   9,   5,  13},  
			   {  6, MAX,   6,   7,   8},  
			   {  9,   6, MAX,   9,   3},  
			   {  5,   7,   9, MAX,   3},  
			   { 13,   8,   3,   3, MAX}  
			 };
	static int[][] graph2 = {
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
		GraphList g = new GraphList(10); 
		g.generateRandomGraph();
		g.printGraph();
		
		//test generate random matrix
		Matrix m = new Matrix(10);
		int[][] testm = m.generateRandomMaxtrix(4);//�����ϡ���ܼ��̶�:1�ܼ�--->10ϡ��
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				System.out.print(testm[i][j] + " ");
			}
			System.out.println("");
		}
//		Prim prim1= new Prim(graph1);
//		prim1.Prim_ArrayLst();
//		prim1.Prim_PriorityQueue();
		
		Kruskal kruskal1 = new Kruskal(graph1);
		Kruskal kruskal2 = new Kruskal(graph2);
		long time1, time2, time3, time4;
		//graph1
		time1 = System.currentTimeMillis();
		kruskal1.generateEdgeResult();
		time2 = System.currentTimeMillis();
		System.out.println("Kruskal time of Graph1: " + (time2 - time1) + "ms") ;
		
		time3 =System.currentTimeMillis();
		new Prim(graph1).Prim_ArrayLst();
		time4 =System.currentTimeMillis();
		System.out.println("Prim time of Graph1: " + (time4 - time3) + "ms");
		//graph1
		System.out.println();
		//graph2
		time1 = System.currentTimeMillis();
		kruskal2.generateEdgeResult();
		time2 = System.currentTimeMillis();
		System.out.println("Kruskal time of Graph2: " + (time2 - time1) + "ms") ;
		
		time3 =System.currentTimeMillis();
		new Prim(graph2).Prim_ArrayLst();
		time4 =System.currentTimeMillis();
		System.out.println("Prim time of Graph2: " + (time4 - time3) + "ms");
		//graph2
	}
}	
