package MST;


public class Matrix {
	
	private int row;
	private int column;
	private int[][] matrix;
	
	public Matrix(int row, int column) {
		this.row = row;
		this.column = column;
		this.matrix = new int[row][column];
	}
	
	public int[][] generateRandomMaxtrix(int range) {
		for(int r = 0; r < row; r++) {
			for(int c = 0; c < column; c++) {
				matrix[r][c] = (int) (Math.random() * range);
			}
		}
	return matrix;
	}
}
