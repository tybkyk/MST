package MST;


public class Edge implements Comparable<Edge>{
	
	private int start;
	private int end;
	private int weight;
	private Edge nextEdge = null; //next edge in adjacent list.
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
	public Edge getNextEdge() {
		return nextEdge;
	}

	public void setNextEdge(Edge nextEdge) {
		this.nextEdge = nextEdge;
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
