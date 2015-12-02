package MST;

import java.util.Random;



public class GraphList {
	
	private int numVertices = 0;
	private int numEdges = 0;
	private Vertex[] vertexArray = null;
	private Random random = new Random();
	public GraphList(int numVertices) {
		this.random.setSeed(0);
		this.numVertices = numVertices;
		this.numEdges = 0;
		vertexArray = new Vertex[numVertices];
		if(vertexArray == null) {
			System.out.println("error");
		}
		for(int i = 0; i < numVertices; i++) {
			Vertex v = new Vertex(i + 1, null);
			vertexArray[i] = v;
		}
	}
	
	
	public void generateRandomGraph() {
		for(int i = 0; i < numVertices; i++) {
			int currentNumEdge = random.nextInt(numVertices - 1);
			Edge currentEdge = null;
			for(int j = 0; j < currentNumEdge; j++) {
				Edge e = null;
				if(i + 1 == j + 1) {
					e = new Edge(i + 1, j + 1, Integer.MAX_VALUE);
				} else {
					e = new Edge(i + 1, j + 1, (int) (Math.random() * 9 + 1));	
				}
				if(j == 0) {
					vertexArray[i].setAdjacentE(e);
				} else {
					currentEdge.setNextEdge(e);
				}
				currentEdge = e;
			}
		}
	}
	
	
	public void Destroy() {
		for(int i = 0; i < numVertices; i++) {
			Edge e = vertexArray[i].getAdjacentE();
			while(e.getNextEdge() != null) {
				vertexArray[i].setAdjacentE(e.getNextEdge());
				e = vertexArray[i].getAdjacentE();
			}
		}
	}
	
	
	/**
	 * get next neighbor vertex key number of certain vertex key
	 * @param vertexkey the start vertex number.
	 * @return end vertex number of fist edge in link list. 
	 * */
	public int getFirstNeighbor(int vertexkey) {
		if(vertexkey - 1 != -1) {
			Edge e = vertexArray[vertexkey - 1].getAdjacentE();
			if(e != null) {
				return e.getEnd();
			}
			
		}
		return -1;
	}
	
	/**
	 * get next neighbor vertex key number of certain vertex key
	 * @param vertexkey the start vertex number.
	 * @param nextVertexKey The end vertex number of the edge that you want to find its next end vertex number
	 * @return vertexKey 
	 * */
	public int getNextNeighbor(int vertexkey, int nextVertexKey) {
		if(vertexkey - 1  != -1) {
			Edge e = vertexArray[vertexkey - 1].getAdjacentE();
			if(nextVertexKey != e.getEnd() && e != null) {
				e = e.getNextEdge();
			}
			if(e.getNextEdge() != null && e != null ) {
				return e.getNextEdge().getEnd();
			}
			
		}
		return -1;
	}
	
	public void printGraph() {
		for(int i = 0; i < numVertices; i++) {
			printEdgeWeight(vertexArray[i].getAdjacentE());
			System.out.println("");
		}
	}
	
	private void printEdgeWeight(Edge nextEdge) {
		System.out.print(nextEdge + " ");
		if(nextEdge.getNextEdge() != null) {
			printEdgeWeight(nextEdge.getNextEdge());
		}
	}
	
//	/**
//	 * get position of certain vertex key
//	 * */
//	public int getVertexPos(int vertexKey) {
//		for(int i = 0; i < vertexArray.length; i++) {
//			if(vertexKey == vertexArray[i].getKey()) {
//				return i;
//			}
//		}
//		return -1;
//	}
//	
//	/**
//	 * get vertex key of certain vertex position
//	 * */
//	public int getkey(int vertexPos) {
//		return (vertexPos >= 0 && vertexPos < numVertices)? vertexArray[vertexPos].getKey(): -1;
//	}
}
