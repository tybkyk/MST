package MST;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Prim {
	
	private GraphList gList;
	int[][] weight;
	private int MAX = Integer.MAX_VALUE;
	/////////////////////////////////////some inner class
	private class Alter_Edge {
		  int start;
		  int end;
		  
		  public Alter_Edge (int s, int e) {
		    start = s;
		    end = e;
		  }
		  
		  public String toString() {
		    return "" + (start+1) + "-" + (end+1);
		  }
		  
		  
		  
		  
	}
	private class Pair {
		  int key;
		  int priority;
		  
		  public Pair (int k, int p) {
		    key = k;
		    priority = p;
		  }
		  
		  public String toString() {
		    return "(" + key + ",p=" + priority + ")";
		  }
	}
	
	public class PriorityComparator implements Comparator<Pair> {
		  public int compare(Pair first, Pair second) {
		    return first.priority - second.priority;
		  }
		}
	/////////////////////////////////////////////////////////
	public Prim(int[][] weight)
	{
		this.weight=weight;
		
	}
	
	
	public Prim(GraphList gList) {
		this.gList = gList;
	}
	
	public void Prim_ArrayLst()
	{
		
		int vertexNum = gList.getNumVertices();
		int []lowestW=new int[vertexNum];
		int []edge=new int[vertexNum];
		boolean []checked=new boolean[vertexNum];
		
		for(int i=0; i<vertexNum; i++){
			lowestW[i] = gList.getWeightFromUtoV(1, i + 1) == -1 ? MAX: gList.getWeightFromUtoV(1, i + 1);
			checked[i] = false;
			edge[i] = 1;
		}
		checked[0]=true;

		for(int i=0; i<vertexNum; i++){
			int min = MAX;
			int nextpick = 1;
			for(int k=1; k<vertexNum; k++){
				if(lowestW[k]<min&&(!checked[k])){
					min=lowestW[k];
					nextpick=k;
//					try {
//						Thread.sleep(10);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//						}
				}
			}
//			if(i<vertexNum-1)
//				System.out.println((nextpick + 1)+"--"+edge[nextpick]+" with weight"+lowestW[nextpick]);
			checked[nextpick]=true;
			
			for(int k=1; k < vertexNum; k++){
				if(((gList.getWeightFromUtoV(1, i + 1) == -1 ? MAX: gList.getWeightFromUtoV(1, i + 1))<lowestW[k])&&(!checked[k])){
					lowestW[k]= (gList.getWeightFromUtoV(1, i + 1) == -1 ? MAX: gList.getWeightFromUtoV(1, i + 1));
				    edge[k]=nextpick+1;
//				    try {
//						Thread.sleep(10);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//						}
				}
			}
		}
	}
	
	public void Prim_PriorityQueue()
	{
		
		int n = gList.getNumVertices();
	    Alter_Edge[] mst = new Alter_Edge[n-1];

	    PriorityQueue<Pair> pq = new PriorityQueue<Pair>(n, new PriorityComparator());
	    for (int i = 1; i < n; i++) {
	      pq.add(new Pair(i, Integer.MAX_VALUE));
	      mst[i-1] = new Alter_Edge(i, -1);
	    }
	    pq.add(new Pair(0, 0));

	    while (!pq.isEmpty()) {
	      int u = pq.remove().key;

	      for (int v = 0; v < n; v++) {
	        int Tweight = gList.getWeightFromUtoV(u + 1, v + 1) == -1 ? MAX: gList.getWeightFromUtoV(u + 1, v + 1);
	        if (Tweight > 0) {
	          for (Pair pv : pq) {
	            if ((pv.key == v) && (Tweight < pv.priority)) {
	              mst[v-1].end = u;
	              pq.remove(pv);
	              pv.priority = Tweight;
	              pq.add(pv);
	              break;
	            }
	          }
	        }
	      }
	    }
//	    for (Alter_Edge e : mst) {
//	    	System.out.println(e + " with weight" + (gList.getWeightFromUtoV(e.start + 1, e.end + 1) == -1 ? MAX: gList.getWeightFromUtoV(e.start + 1, e.end + 1)));
//	    }

	}
}
