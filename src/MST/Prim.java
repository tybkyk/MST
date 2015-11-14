package MST;

public class Prim {
	static int MAX = Integer.MAX_VALUE;
	static int[][] weight = {
			   {MAX, 6, 9, 5, 13},  
			   {6, MAX, 6,7,8},  
			   {9,6,MAX,9,3},  
			   {5,7,9,MAX,3},  
			   {13,8,3,3,MAX}  
			 };
	static int vertexNum = weight.length;
	static int []lowestW=new int[vertexNum];
	static int []edge=new int[vertexNum];
	static boolean []checked=new boolean[vertexNum];
	
	public void prim()
	{
		for(int i=0; i<vertexNum; i++){
			lowestW[i] = weight[0][i];
			checked[i] = false;
			edge[i] = i;
		}
		checked[0]=true;
		
		for(int i=0; i<vertexNum; i++){
			int min = MAX;
			int nextpick = 0;
			for(int k=1; k<vertexNum; k++){
				if(lowestW[k]<min&&(!checked[k])){
					min=lowestW[k];
					nextpick=k;
				}
			}
			if(i<vertexNum)
				System.out.println(nextpick+"-->"+edge[nextpick]+" with weight"+lowestW[nextpick]);
			checked[nextpick]=true;
			
			for(int k=1; k<vertexNum; k++){
				if(lowestW[k]<min&&(!checked[k])){
					lowestW[k]=weight[nextpick][k];
				     edge[k]=nextpick;
				}
			}
		}
	}
}
