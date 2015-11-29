package MST;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Kruskal {
	
	
	/**n:number of vertices*/
	private int numVertices;
	ArrayList<Edge> edgeList = new ArrayList<Edge>();
	ArrayList<Edge> outputEdgeList = new ArrayList<Edge>();
	public Kruskal(int[][] graph) {
		this.numVertices = graph.length;
		this.edgeList = generateTree(graph);
		
		//Test number of edges
//		for(Edge e : edgeList) {
//			System.out.println(e.toString());
//		}
	}
	
	
	
	public void generateEdgeResult() {
		this.edgeList.sort(null);
		if(edgeList.size() == 0) {
			try {
				throw new Exception("Please input a graph.");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//use two-dimention array to record result
		int[][] tree = new int[numVertices][numVertices];
		for(int i = 0; i < numVertices; i++) {
			for(int j = 0; j < numVertices; j++) {
				tree[i][j] = Integer.MAX_VALUE;
			}
		}
		
		
		
		
		// using map to indicate which node belongs to which set.
		Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
		int numberOfNodes = numVertices;
		int treeEdgeCounter = 0;
		while (treeEdgeCounter < numberOfNodes - 1 || !edgeList.isEmpty()) {
			
			//sleep for a while
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
			Edge miniEdge = edgeList.remove(0);
			int start = miniEdge.getStart();
			int end = miniEdge.getEnd();
			int weight = miniEdge.getWeight();
			Set<Integer> setStart = map.get(start);
			Set<Integer> setEnd = map.get(end);
			// both nodes did not show up in other set.
			if(setStart == null && setEnd == null) {
				Set<Integer> set = new HashSet<Integer>();
				set.add(start);
				set.add(end);
				map.put(start, set);
				map.put(end, set);
			} else if(setStart == null && setEnd != null){
				setEnd.add(start);
				map.put(start, setEnd);
			} else if(setStart != null && setEnd == null) {
				setStart.add(end);
				map.put(start, setStart);
			} else if(setStart != null && setEnd != null && setStart != setEnd) {
				setStart.addAll(setEnd);
				for(int tempEnd: setEnd) {
					map.put(tempEnd, setStart);
				}
			} else {
				continue;
			}
			
			
			boolean flag = false;
			for(Edge e: outputEdgeList) {
				if(e.getStart() == miniEdge.getEnd() && e.getEnd() == miniEdge.getStart() && e.getWeight() == miniEdge.getWeight()) {
					flag = true;
				}
			}
			if(flag) {
				continue;
			}
			outputEdgeList.add(miniEdge);
			System.out.println(miniEdge);
			treeEdgeCounter++;
		}
		
		//output result
		
	}


	

private ArrayList<Edge> generateTree(int[][] graph) {
	//construct edgeList.
	ArrayList<Edge> edgeList = new ArrayList<Edge>();
	int rowLen = graph.length;
	int colmnLen = graph[0].length;
	for(int i = 1; i <= rowLen; i++) {
		for(int j = 1; j <= colmnLen; j++) {
			if(graph[i - 1][j - 1] > 0 && graph[i - 1][j - 1] < Integer.MAX_VALUE) {
				Edge edge = new Edge(i, j, graph[i - 1][j - 1]);
				edgeList.add(edge);
			}
		}
	}
	return edgeList;
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
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge o) {
		if(o.weight == weight) {
			return 0;
		} else if( o.weight > weight) {
			return -1;
		} else if (o.weight < weight) {
			return 1;
		}
		return 0;
	}
	
	public String toString() {
		return start + "--" + end + ":" + weight;
	}
}

}