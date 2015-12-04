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
		
		long timer1, timer2;
		int numVertices = 100000;
		GraphList starGraph = new GraphList(numVertices); 
		starGraph.generateStarGraph();
		GraphList lineGraph = new GraphList(numVertices); 
		lineGraph.generateLineGraph();
		GraphList randomGraph = new GraphList(numVertices); 
		randomGraph.generateRandomGraph();
		System.out.println("finish generate graph.");
		
		//============star==============
		System.out.println("star graph: " + "number of vertices:" + numVertices + "number of edges :" + starGraph.getNumEdges());
		Kruskal kruskal_star_unionset = new Kruskal(starGraph.getAllEdges(), starGraph.getNumVertices());
		timer1 = System.currentTimeMillis();
		kruskal_star_unionset.generateEdgeResult();
		timer2 = System.currentTimeMillis();
		System.out.println("Kruskal time of star graph with union set: " + (timer2 - timer1) + "ms") ;
		Kruskal kruskal_star_DFS = new Kruskal(starGraph.getAllEdges(), starGraph.getNumVertices());
		timer1 = System.currentTimeMillis();
		kruskal_star_DFS.generateEdgeResultDFS();
		timer2 = System.currentTimeMillis();
		System.out.println("Kruskal time of star graph with DFS: " + (timer2 - timer1) + "ms") ;
		//============star==============
		
		//============line==============
		System.out.println("line graph: " + "number of vertices:" + numVertices + "number of edges :" + lineGraph.getNumEdges());
		Kruskal kruskal_line_unionset = new Kruskal(lineGraph.getAllEdges(), lineGraph.getNumVertices());
		timer1 = System.currentTimeMillis();
		kruskal_line_unionset.generateEdgeResult();
		timer2 = System.currentTimeMillis();
		System.out.println("Kruskal time of line graph with union set: " + (timer2 - timer1) + "ms") ;
		Kruskal kruskal_line_DFS = new Kruskal(lineGraph.getAllEdges(), lineGraph.getNumVertices());
		timer1 = System.currentTimeMillis();
		kruskal_line_DFS.generateEdgeResultDFS();
		timer2 = System.currentTimeMillis();
		System.out.println("Kruskal time of line graph with DFS: " + (timer2 - timer1) + "ms") ;
		//============line==============
		
		//============random==============
		System.out.println("random graph: " + "number of vertices:" + numVertices + "number of edges :" + randomGraph.getNumEdges());
		Kruskal kruskal_random_unionset = new Kruskal(randomGraph.getAllEdges(), randomGraph.getNumVertices());
		timer1 = System.currentTimeMillis();
		kruskal_random_unionset.generateEdgeResult();
		timer2 = System.currentTimeMillis();
		System.out.println("Kruskal time of random graph with union set: " + (timer2 - timer1) + "ms") ;
		Kruskal kruskal_random_DFS = new Kruskal(randomGraph.getAllEdges(), randomGraph.getNumVertices());
		timer1 = System.currentTimeMillis();
		kruskal_random_DFS.generateEdgeResultDFS();
		timer2 = System.currentTimeMillis();
		System.out.println("Kruskal time of random graph with DFS: " + (timer2 - timer1) + "ms") ;
		//============random==============
		
		
		//============star==============
		System.out.println("star graph: " + "number of vertices:" + numVertices + "number of edges :" + starGraph.getNumEdges());
		Prim prim_star_arrayList = new Prim(starGraph);
		timer1 = System.currentTimeMillis();
		prim_star_arrayList.Prim_ArrayLst();
		timer2 = System.currentTimeMillis();
		System.out.println("Prim time of star graph with Arraylist: " + (timer2 - timer1) + "ms") ;
		Prim prim_star_priorityQueue = new Prim(starGraph);
		timer1 = System.currentTimeMillis();
		prim_star_priorityQueue.Prim_PriorityQueue();
		timer2 = System.currentTimeMillis();
		System.out.println("Prim time of star graph with priorityQueue: " + (timer2 - timer1) + "ms") ;
		//============star==============
		
		//============line==============
		System.out.println("line graph: " + "number of vertices:" + numVertices + "number of edges :" + lineGraph.getNumEdges());
		Prim prim_line_arrayList = new Prim(lineGraph);
		timer1 = System.currentTimeMillis();
		prim_line_arrayList.Prim_ArrayLst();
		timer2 = System.currentTimeMillis();
		System.out.println("Prim time of line graph with Arraylist: " + (timer2 - timer1) + "ms") ;
		Prim prim_line_priorityQueue = new Prim(lineGraph);
		timer1 = System.currentTimeMillis();
		prim_line_priorityQueue.Prim_PriorityQueue();
		timer2 = System.currentTimeMillis();
		System.out.println("Prim time of line graph with priorityQueue: " + (timer2 - timer1) + "ms") ;
		//============line==============
		
		//============random==============
		System.out.println("random graph: " + "number of vertices:" + numVertices + "number of edges :" + randomGraph.getNumEdges());
		Prim prim_random_arrayList = new Prim(randomGraph);
		timer1 = System.currentTimeMillis();
		prim_random_arrayList.Prim_ArrayLst();
		timer2 = System.currentTimeMillis();
		System.out.println("Prim time of random graph with Arraylist: " + (timer2 - timer1) + "ms") ;
		Prim prim_random_priorityQueue = new Prim(randomGraph);
		timer1 = System.currentTimeMillis();
		prim_random_priorityQueue.Prim_PriorityQueue();
		timer2 = System.currentTimeMillis();
		System.out.println("Prim time of random graph with priorityQueue: " + (timer2 - timer1) + "ms") ;
		//============random==============
		
		
		
		
		
//		Kruskal kruskal1 = new Kruskal(starGraph.getAllEdges(), starGraph.getNumVertices());
//		Kruskal kruskal2 = new Kruskal(starGraph.getAllEdges(), starGraph.getNumVertices());
//		
//		
//		long time1, time2, time3, time4;
//		
//		//graph1
//		time1 = System.currentTimeMillis();
////		kruskal1.generateEdgeResultDFS();
//		time2 = System.currentTimeMillis();
//		System.out.println("Kruskal time of Graph1: " + (time2 - time1) + "ms") ;
//		
//		time3 =System.currentTimeMillis();
//		new Prim(starGraph).Prim_PriorityQueue();
//		time4 =System.currentTimeMillis();
//		System.out.println("Prim time of Graph1: " + (time4 - time3) + "ms");
//		//graph1
//		System.out.println();
//		//graph2
//		time1 = System.currentTimeMillis();
////		kruskal2.generateEdgeResultDFS();
//		time2 = System.currentTimeMillis();
//		System.out.println("Kruskal time of Graph2: " + (time2 - time1) + "ms") ;
//		
//		time3 =System.currentTimeMillis();
//		new Prim(starGraph).Prim_PriorityQueue();
//		time4 =System.currentTimeMillis();
//		System.out.println("Prim time of Graph2: " + (time4 - time3) + "ms");
	}
}	
