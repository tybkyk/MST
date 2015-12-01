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
	private ArrayList<Edge> edgeList = new ArrayList<Edge>();
	private ArrayList<Edge> outputEdgeList = new ArrayList<Edge>();
	private ArrayList<Integer> markedNode = new ArrayList<Integer>();
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
		ArrayList<PriorityQueue<Integer>> setList = new ArrayList<PriorityQueue<Integer>>();
		int numberOfNodes = numVertices;
		int treeEdgeCounter = 0;
		//do not need "|| !edgeList.isEmpty()" just for debug, when debug we need to test each edge.
		while (treeEdgeCounter < numberOfNodes - 1) {
			
			//sleep for a while
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
			Edge miniEdge = edgeList.remove(0);
			int start = miniEdge.getStart();
			int end = miniEdge.getEnd();
			int startSetNum = -1;
			int endSetNum = -1;
			for(int i = 0; i < setList.size(); i++) {
				if(setList.get(i).contains(startSetNum)) {
					startSetNum = i;
				}
				if(setList.get(i).contains(endSetNum)) {
					endSetNum = i;
				}
			}
			
			
			// both nodes did not show up in other set.
			if(startSetNum == -1 && endSetNum == -1) {
				PriorityQueue<Integer> set = new PriorityQueue<Integer>();
				set.add(start);
				set.add(end);
				setList.add(set);
			} else if(startSetNum == -1 && endSetNum != -1){
				setList.get(endSetNum).add(start);
			} else if(startSetNum != -1 && endSetNum == -1) {
				setList.get(startSetNum).add(end);
			} else if(startSetNum != -1 && endSetNum != -1 && startSetNum != endSetNum) {
				setList.get(startSetNum).addAll(setList.get(endSetNum));
				setList.remove(endSetNum);
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

	public void generateEdgeResultDFS() {
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
		
		
		
		
		int numberOfNodes = numVertices;
		int treeEdgeCounter = 0;
		// do not need " || !edgeList.isEmpty()" just for debug, when debug we need to test each edge
		while (treeEdgeCounter < numberOfNodes - 1) {
			
			//sleep for a while
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
			Edge miniEdge = edgeList.remove(0);
			int start = miniEdge.getStart();
			int end = miniEdge.getEnd();
			
			boolean isCycle = findNodeDFS(start, end, outputEdgeList);
			markedNode.clear();
			
			if(!isCycle) {
				
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
			} else {
				continue;
			}
			
			
		}
		
		//output result
		
	}
	
	
	private boolean findNodeDFS(int start, int destination, ArrayList<Edge> resultEdgeList) {
		markedNode.add(start);
		if(start == destination) {
			return true;
		}
		
		boolean branch1 = false;
		boolean branch2 = false;
		for(Edge e: resultEdgeList) {
			if(e.start == start && !markedNode.contains(e.end)) {
				branch1 = findNodeDFS(e.end, destination, resultEdgeList);
			}
			if(e.end == start && !markedNode.contains(e.start)) {
				branch2 = findNodeDFS(e.start, destination, resultEdgeList);
			}
			if(branch1 || branch2) {
				return true;
			}
			if(e.start != start && e.end != start) {
				continue;
			}
		}
		
		
		return false;
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