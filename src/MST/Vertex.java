package MST;

public class Vertex {
	private int key = -1;
	private Edge  adjacentE = null;
	
	
	public Vertex(int key, Edge e) {
		this.key = key;
		this.adjacentE = e;
	}
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public Edge getAdjacentE() {
		return adjacentE;
	}
	public void setAdjacentE(Edge adjacentE) {
		this.adjacentE = adjacentE;
	}
	
	
	
}
