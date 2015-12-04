package MST;

import java.util.ArrayList;
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
			int currentNumEdge = random.nextInt(10) + 1;
			Edge currentEdge = null;
			for(int j = 0; j < currentNumEdge; j++) {
				Edge e = null;
				if(i + 1 == j + 1) {
					continue;
				} else {
					e = new Edge(i + 1, j + 1, (int) (Math.random() * 9 + 1));	
					numEdges++;
				}
				if(vertexArray[i].getAdjacentE() == null && e != null) {
					vertexArray[i].setAdjacentE(e);
				} else {
					currentEdge.setNextEdge(e);
				}
				currentEdge = e;
			}
		}
	}
	
	public void generateStarGraph() {
		Edge currentEdge = null;
		for(int i = 1; i < numVertices; i++) {
			int weight = random.nextInt(10) + 1;
			if(i == 1 && currentEdge == null) {
				Edge e = new Edge(1, i + 1, weight);
				vertexArray[0].setAdjacentE(e);
				currentEdge = e;
				numEdges++;	
			} else {
				Edge e = new Edge(1, i + 1, weight);
				currentEdge.setNextEdge(e);
				currentEdge = e;
				numEdges++;
			}
//			
//			Edge eReverse = new Edge(i + 1, 1, weight);
//			vertexArray[i].setAdjacentE(eReverse);
//			numEdges++;
		}
	}
	
	public void generateLineGraph() {
		for(int i = 0; i < numVertices; i++) {
			//last vertex do not have an edge.
			if(i == numVertices - 1) {
				continue;
			}
			Edge e = new Edge(i + 1, i + 2, random.nextInt(10) + 1);
			vertexArray[i].setAdjacentE(e);
			numEdges++;
		}
		
	}
	
	
	public ArrayList<Edge> getAllEdges() {
		ArrayList<Edge> edgeList = new ArrayList<Edge>();
		for(int i = 0; i < numVertices; i++) {
			if(vertexArray[i].getAdjacentE() == null) {
				continue;
			}
			Edge currentEdge = vertexArray[i].getAdjacentE();
			edgeList.add(currentEdge);
			while(currentEdge.getNextEdge() != null) {
				currentEdge = currentEdge.getNextEdge();
				edgeList.add(currentEdge);
			}
		}
		return edgeList;
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
			if(vertexArray[i].getAdjacentE() == null) {
				System.out.println("No edge in current vertex.");
			} else {
				printEdgeWeight(vertexArray[i].getAdjacentE());
				System.out.println("");	
			}
			
		}
	}
	
	private void printEdgeWeight(Edge nextEdge) {
		System.out.print(nextEdge + " ");
		if(nextEdge.getNextEdge() != null) {
			printEdgeWeight(nextEdge.getNextEdge());
		}
	}


	public int getNumVertices() {
		return numVertices;
	}


	public void setNumVertices(int numVertices) {
		this.numVertices = numVertices;
	}


	public int getNumEdges() {
		return numEdges;
	}


	public void setNumEdges(int numEdges) {
		this.numEdges = numEdges;
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
