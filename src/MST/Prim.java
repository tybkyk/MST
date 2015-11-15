package MST;

public class Prim {
	public Prim(int[][] weight)
	{
		int MAX = Integer.MAX_VALUE;	
		int vertexNum = weight.length;
		int []lowestW=new int[vertexNum];
		int []edge=new int[vertexNum];
		boolean []checked=new boolean[vertexNum];
		
		for(int i=0; i<vertexNum; i++){
			lowestW[i] = weight[0][i];
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
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			if(i<vertexNum-1)
				System.out.println((nextpick + 1)+"-->"+edge[nextpick]+" with weight"+lowestW[nextpick]);
			checked[nextpick]=true;
			
			for(int k=1; k<vertexNum; k++){
				if((weight[nextpick][k]<lowestW[k])&&(!checked[k])){
					lowestW[k]=weight[nextpick][k];
				    edge[k]=nextpick+1;
				    try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

}
