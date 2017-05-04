import java.util.ArrayList;
import java.util.List;
/*Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, 
 * the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the 
 * right and bottom edges.

Water can only flow in four directions (up, down, left, or right) from a cell to another one with height 
equal or lower.

Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.

Note:
The order of returned grid coordinates does not matter.
Both m and n are less than 150.
Example:

Given the following 5x5 matrix:

  Pacific ~   ~   ~   ~   ~ 
       ~  1   2   2   3  (5) *
       ~  3   2   3  (4) (4) *
       ~  2   4  (5)  3   1  *
       ~ (6) (7)  1   4   5  *
       ~ (5)  1   1   2   4  *
          *   *   *   *   * Atlantic

Return:

[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).*/
public class Q417_Pacific_Atlantic_Water_Flow {
	/*这道题给了我们一个二维数组，说是数组的左边和上边是太平洋，右边和下边是大西洋，假设水能从高处向低处流，问我们所有能流向两大洋的点的
	 * 集合。刚开始我们没有理解题意，以为加括号的点是一条路径，连通两大洋的，但是看来看去感觉也不太对，后来终于明白了，是每一个点单独都
	 * 路径来通向两大洋。那么就是典型的搜索问题，那么我最开始想的是对于每个点来搜索是否能到达边缘，只不过搜索的目标点不在是一个单点，而
	 * 是所有的边缘点，找这种思路写出的代码无法通过OJ大数据集，那么我们就要想办法来优化我们的代码，优化的方法跟之前那道Surrounded 
	 * Regions很类似，都是换一个方向考虑问题，既然从每个点像中间扩散会TLE，那么我们从边缘当作起点开始遍历搜索，然后标记能到达的点位
	 * true，分别标记出pacific和atlantic能到达的点，那么最终能返回的点就是二者均为true的点。我们可以先用DFS来遍历二维数组，参见
	 * 代码如下：

*/
	int dx[] = {0,0,-1,1};
    int dy[] = {1,-1,0,0}; 
    //判断一个节点能否流通到海洋
    private void flow(boolean visited[][],int matrix[][],int x,int y,int n,int m ){
        visited[x][y] = true;
        for(int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(nx>=0 && nx<n && ny>=0 && ny<m){
                //一个节点是只能留到不高于自己高度的节点，但是我们这里是反过来找能从nxny留到xy的节点，所以这里注意下
                if(visited[nx][ny]==false && matrix[nx][ny]>=matrix[x][y])
                    flow(visited,matrix,nx,ny,n,m);
            }
        }
    }
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<int[]>();
        int n = matrix.length;
        if(n==0) return res;
        int m = matrix[0].length;
        boolean PV[][] = new boolean[n][m];
        boolean AV[][] = new boolean[n][m];
        // 这里从所有临海的地方到这回去判断某个节点是否能流到对应的地方
        for(int i=0;i<n;i++){
            flow(PV,matrix,i,0,n,m);
            flow(AV,matrix,i,m-1,n,m);
        }
        for(int i=0;i<m;i++){
            flow(PV,matrix,0,i,n,m);
            flow(AV,matrix,n-1,i,n,m);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(PV[i][j] && AV[i][j])
                    res.add(new int[] {i,j});
            }
        }
        return res;

    }
}
