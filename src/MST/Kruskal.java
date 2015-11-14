package MST;

import java.util.PriorityQueue;

public class Kruskal {
	
	
	/**n:number of vertices*/
	private int n;
	
	private PriorityQueue<Edge> edgeList = new PriorityQueue<Edge>();
	
	public Kruskal(int[][] graph) {
		//construct edgeList.
		int rowLen = graph.length;
		int colmnLen = graph[0].length;
		for(int i = 0; i < rowLen; i++) {
			for(int j = 0; j < colmnLen; j++) {
				if(graph[i][j] > 0 && graph[i][j] < Integer.MAX_VALUE) {
					Edge edge = new Edge(i, j, graph[i][j]);
					edgeList.add(edge);
				}
			}
		}
		//Test number of edges
//		for(Edge e : edgeList) {
//			System.out.println(e.toString());
//		}
	}
	
	
	
	public PriorityQueue<Edge> generateEdgeResult() {
		if(edgeList.size() == 0) {
			try {
				throw new Exception("Please input a graph.");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return edgeList;
	}
}






class Edge implements Comparable<Edge>{
	
	private int start;
	private int end;
	private int weight;
	
	public Edge(int inputStart, int inputEnd, int inputWeight) {
		this.start = inputStart;
		this.end = inputEnd;
		this.weight = inputWeight;
	}
	
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge o) {
		if(o.weight == weight) {
			return 0;
		} else if( o.weight < weight) {
			return -1;
		} else if (o.weight > weight) {
			return 1;
		}
		return 0;
	}
	
	public String toString() {
		return start + "-->" + end + ":" + weight;
	}
}