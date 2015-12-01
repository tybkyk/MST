package MST;


public class Matrix {
	
	private int rc;
	private int[][] matrix;
	
	public Matrix(int rc) {
		this.rc = rc;
		this.matrix = new int[rc][rc];
	}
	
	public int[][] generateRandomMaxtrix(int density) {
		for(int r = 0; r < rc; r++) {
			for(int c = 0; c < rc; c++) {
				matrix[r][c] = -1;
			}
		}
		for(int r = 0; r < rc; r++) {
			for(int c = 0; c < rc; c++) {
				if(matrix[r][c] == -1){
					if(Math.random() * 10 > density)
						matrix[r][c] = (int) (Math.random() * 10);				
					else
						matrix[r][c] = Integer.MAX_VALUE;
					matrix[c][r] = matrix[r][c];
				}
				if(r == c)
					matrix[r][c] = Integer.MAX_VALUE;
			}
		}
	return matrix;
	}
}
