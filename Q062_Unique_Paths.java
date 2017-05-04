

/*A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right 
corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?*/
public class Q062_Unique_Paths {
	/*This is a fundamental DP problem. First of all, let's make some observations.
	 * Since the robot can only move right and down, when it arrives at a point, there are only two possibilities:
	 * It arrives at that point from above (moving down to that point)
	 * It arrives at that point from left (moving right to that point).
	 * Thus, we have the following state equations: suppose the number of paths to arrive at a point (i, j) is 
	 * denoted as P[i][j], it is easily concluded that P[i][j] = P[i - 1][j] + P[i][j - 1].
	 * The boundary conditions of the above equation occur at the leftmost column (P[i][j - 1] does not exist) 
	 * and the uppermost row (P[i - 1][j] does not exist). These conditions can be handled by initialization 
	 * (pre-processing) --- initialize P[0][j] = 1, P[i][0] = 1 for all valid i, j. Note the initial value is 1 
	 * instead of 0!
	 * */
	public int uniquePaths(int m, int n) {
		int[][] path = new int[m][n];
		for(int j=0; j<n; j++) path[0][j] = 1;
		for(int i=0; i<m; i++) path[i][0] = 1;
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                path[i][j] = path[i - 1][j] + path[i][j - 1];
        return path[m - 1][n - 1];
    }
	/*As can be seen, the above solution runs in O(n^2) time and costs O(m*n) space. However, you may have observed 
	 * that each time when we update path[i][j], we only need path[i - 1][j] (at the same column) and path[i][j - 1] 
	 * (at the left column). So it is enough to maintain two columns (the current column and the left column) 
	 * instead of maintaining the full m*n matrix. Now the code can be optimized to have O(min(m, n)) 
	 * space complexity.*/ 
	//C++
	public int uniquePaths_0(int m, int n) {
        if (m > n) return uniquePaths(n, m); 
        int[] pre = new int[m];
        for(int i=0; i<m; i++) pre[i] = 1;
        int[] cur = new int[n];
        for(int j=0; j<n; j++) cur[j] = 1;
        for (int j = 1; j < n; j++) {
            for (int i = 1; i < m; i++)
                cur[i] = cur[i - 1] + pre[i];
           // swap(pre, cur); swap two arrays
            //swap m and n only to make the running time O(min(m, n)) :-)
        }
        return pre[m - 1];
    }
	/*Further inspecting the above code, we find that keeping two columns is used to recover pre[i], which is just 
	 * cur[i] before its update. So there is even no need to use two vectors and one is just enough. Now the space 
	 * is further saved and the code also gets much shorter.*/
	public int uniquePaths_1(int m, int n) {
        if (m > n) return uniquePaths(n, m);
        int[] cur = new int[n];
        for(int j=0; j<n; j++) cur[j] = 1;
        for (int j = 1; j < n; j++)
            for (int i = 1; i < m; i++)
                cur[i] += cur[i - 1]; 
        return cur[m - 1];
    }
}
