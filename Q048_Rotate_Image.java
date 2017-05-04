/*You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?*/
public class Q048_Rotate_Image {
	public void rotate(int[][] matrix) {
		for(int i = 0; i < matrix.length / 2; i++){
	        int[] temp = matrix[i];
	        matrix[i] = matrix[matrix.length - i - 1];
	        matrix[matrix.length - i - 1] = temp;
	    }

	    for(int i = 0; i < matrix.length; i++){
	        for(int j = i+1; j < matrix[i].length; j++){
	            int temp = matrix[i][j];
	            matrix[i][j] = matrix[j][i];
	            matrix[j][i] = temp;
	        }
	    }
    }
	/********************************************************************************************/
	/*
	 * clockwise rotate
	 * first reverse up to down, then swap the symmetry 
	 * 1 2 3     7 8 9     7 4 1
	 * 4 5 6  => 4 5 6  => 8 5 2
	 * 7 8 9     1 2 3     9 6 3
	*/
	public void rotate_0(int[][] matrix) {
		for(int i = 0; i < matrix.length / 2; i++){
            int[] temp = matrix[i];
            matrix[i] = matrix[matrix.length - i - 1];
            matrix[matrix.length - i - 1] = temp;
        }
    
        for(int i = 0; i < matrix.length; i++){
            for(int j = i+1; j < matrix[i].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
	}
	/********************************************************************************************/
	/*
	 * anticlockwise rotate
	 * first reverse left to right, then swap the symmetry
	 * 1 2 3     3 2 1     3 6 9
	 * 4 5 6  => 6 5 4  => 2 5 8
	 * 7 8 9     9 8 7     1 4 7
	*/
	public void anti_rotate(int[][] matrix) {
//	    for (auto vi : matrix) reverse(vi.begin(), vi.end());
	    for (int i = 0; i < matrix.length; ++i) {
	    	for (int j = 0; j < i; ++j) {
	    		int temp = matrix[i][j];
	        	matrix[i][j] = matrix[j][i];
	        	matrix[j][i] = temp;
	    	}
	    }
	}
	
}
