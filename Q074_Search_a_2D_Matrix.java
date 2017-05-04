/*Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.*/
public class Q074_Search_a_2D_Matrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		//run time error
		if(matrix==null||matrix.length==0) return false;
        int rl = 0, rh = matrix.length-1;
		int cl = 0, ch = matrix[0].length-1;

		while(rl<=rh) {
			int rm = (rl+rh)/2;
			int cm = (cl+ch)/2;
			if(target==matrix[rm][cm]) return true;
			else if(target>matrix[rm][cm]) {
				rl = rm+1;
			}
			else {
				rh = rm;
			}
		}
		while(cl<=ch) {
			int cm = (cl+ch)/2;
			if(target==matrix[rl][cm]) return true;
			else if(target>matrix[rl][cm]) cl = cm+1;
			else ch = cm;
		}
		
        return false;
    }
	/*******************************************************************/
	public boolean searchMatrix_0(int[][] matrix, int target) {
		int row_num = matrix.length;
		int col_num = matrix[0].length;
		
		int begin = 0, end = row_num * col_num - 1;
		
		while(begin <= end){
			int mid = (begin + end) / 2;
			int mid_value = matrix[mid/col_num][mid%col_num];
			
			if( mid_value == target){
				return true;
			
			}else if(mid_value < target){
				//Should move a bit further, otherwise dead loop.
				begin = mid+1;
			}else{
				end = mid-1;
			}
		}
		
		return false;
	}
}
