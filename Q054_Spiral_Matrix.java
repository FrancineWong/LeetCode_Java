import java.util.ArrayList;
import java.util.List;

/*Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].*/
public class Q054_Spiral_Matrix {
	public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();     
        spiral(matrix, res, 0);
        return res;
    }
	
	public void spiral(int[][] matrix, List<Integer> res,  int index) {
		int row = matrix.length;
		int column = matrix[0].length;
		int min = Math.min(row, column);
		if(index*2>min) return;
		else {
			for(int i=index; i<column-1-index; i++) res.add(matrix[index][i]);
			for(int j=index; j<row-1-index; j++) res.add(matrix[j][column-index-1]);
			for(int k=column-index-1; k>=1+index; k--) res.add(matrix[row-1-index][k]);
			for(int l=row-index-1; l>=1+index; l--) res.add(matrix[l][index]);
			spiral(matrix, res, index+1);
		}
		
	}
	
	public List<Integer> spiral_0(int[][] matrix) {
		List<Integer> res = new ArrayList<Integer>();     
		int index = 0;
		int row = matrix.length;
		int column = matrix[0].length;
		int min = Math.min(row, column);
		while(min>index*2) {
			for(int i=index; i<column-1-index; i++) res.add(matrix[index][i]);
			for(int j=index; j<row-1-index; j++) res.add(matrix[j][column-index-1]);
			for(int k=column-index-1; k>=1+index; k--) res.add(matrix[row-1-index][k]);
			for(int l=row-index-1; l>=1+index; l--) res.add(matrix[l][index]);
			index++;
		}
		return res;
	}
	/****************************************************************************************/
	public List<Integer> spiralOrder_0(int[][] matrix) {
List<Integer> res = new ArrayList<Integer>();
        
        if (matrix.length == 0) {
            return res;
        }
        
        int rowBegin = 0;
        int rowEnd = matrix.length-1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;
        
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // Traverse Right
            for (int j = colBegin; j <= colEnd; j ++) {
                res.add(matrix[rowBegin][j]);
            }
            rowBegin++;
            
            // Traverse Down
            for (int j = rowBegin; j <= rowEnd; j ++) {
                res.add(matrix[j][colEnd]);
            }
            colEnd--;
            
            if (rowBegin <= rowEnd) {
                // Traverse Left
                for (int j = colEnd; j >= colBegin; j --) {
                    res.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;
            
            if (colBegin <= colEnd) {
                // Traver Up
                for (int j = rowEnd; j >= rowBegin; j --) {
                    res.add(matrix[j][colBegin]);
                }
            }
            colBegin ++;
        }
        
        return res;
    
	}
}
