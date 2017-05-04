/*Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.*/
public class Q063_Unique_Paths_II {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        //flip upper left cell (the start cell): 1 => 0 or 0 => 1
        obstacleGrid[0][0] ^= 1;  
        //first row: if 1, then 0; otherwise, left cell
        for(int i = 1; i < n; i++)
            obstacleGrid[0][i] = obstacleGrid[0][i] == 1 ? 0 : obstacleGrid[0][i - 1];       
        //first column: if 1, then 0; otherwise, top cell
        for(int i = 1; i < m; i++)
            obstacleGrid[i][0] = obstacleGrid[i][0] == 1 ? 0 : obstacleGrid[i - 1][0];            
        //rest: if 1, then 0; otherwise, left cell + top cell
        for(int i = 1; i < m; i++)
            for(int j = 1; j < n; j++)
                obstacleGrid[i][j] = obstacleGrid[i][j] == 1 ? 0 : obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];                
        //return lower right cell (the end cell)
        return obstacleGrid[m - 1][n - 1];
    }
	/***********************************************************************/
	//dp[x] is the paths number to column x in the current row.
	/*Array dp stores the number of paths which passing this point. The whole algorithm is to sum up the paths 
	 * from left grid and up grid. 'if (row[j] == 1) dp[j] = 0; means if there is an obstacle at this point. 
	 * All the paths passing this point will no longer valid. In other words, the grid right of the obstacle 
	 * can be reached only by the grid which lies up to it.*/
	public int uniquePathsWithObstacles_0(int[][] obstacleGrid) {
	    int width = obstacleGrid[0].length;
	    int[] dp = new int[width];
	    dp[0] = 1;
	    for (int[] row : obstacleGrid) {
	        for (int j = 0; j < width; j++) {
	            if (row[j] == 1)
	                dp[j] = 0;
	            else if (j > 0)
	                dp[j] += dp[j - 1];
	        }
	    }
	    return dp[width - 1];
	}
}
