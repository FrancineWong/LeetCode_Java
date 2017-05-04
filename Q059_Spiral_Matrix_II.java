/*Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]*/
public class Q059_Spiral_Matrix_II {
	public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if(n==0) return matrix;
   
        int rowBegin = 0;
        int rowEnd = n-1;
        int colBegin = 0;
        int colEnd = n-1;
        
        int num = 1;
        
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            for (int j = colBegin; j <= colEnd; j ++) {
                matrix[rowBegin][j] = num++;
            }
            rowBegin++;
            for (int j = rowBegin; j <= rowEnd; j ++) {
                matrix[j][colEnd] = num++;
            }
            colEnd--;
            if (rowBegin <= rowEnd) {
                for (int j = colEnd; j >= colBegin; j --) {
                    matrix[rowEnd][j] = num++;
                }
            }
            rowEnd--;
            if (colBegin <= colEnd) {
                for (int j = rowEnd; j >= rowBegin; j --) {
                    matrix[j][colBegin] = num++;
                }
            }
            colBegin ++;
        }
    
        return matrix;
    }
}
