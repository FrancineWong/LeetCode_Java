import static org.junit.Assert.*;

import org.junit.Test;

/*You are given a map in form of a two-dimensional integer grid where 1 represents land 
 * and 0 represents water. Grid cells are connected horizontally/vertically (not diagonally). 
 * The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells). The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

Example:

[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

Answer: 16

 * */

public class Q463_Island_Perimeter {
	public int islandPerimeter(int[][] grid) {
        //1的周围有多少0就多大周长
		int pMeter = 0;
		int[][] temp = new int[grid.length+2][grid[0].length+2];
		for(int i=0; i<temp.length; i++){
			temp[i][0] = 0;
			temp[i][temp[0].length-1] = 0;
		}
		for(int j=0; j<temp[0].length; j++){
			temp[0][j] = 0; 
			temp[temp.length-1][j]=0;
		}
		
		for(int i=1; i<temp.length-1; i++){
			for(int j=1; j<temp[0].length-1; j++){
				temp[i][j] = grid[i-1][j-1];
			}
		}
		for(int i=1; i<temp.length-1; i++){
			for(int j=1; j<temp[0].length-1; j++){
				if(temp[i][j]==1){
					if(temp[i-1][j]==0) pMeter++;
					if(temp[i+1][j]==0) pMeter++;
					if(temp[i][j-1]==0) pMeter++;
					if(temp[i][j+1]==0) pMeter++;
				}
			}
		}
		return pMeter;
    }
	
	@Test
	public void test(){
		int pMeter = 16;
		int[][] test = {{0,1,0,0},
		                {1,1,1,0},
		                {0,1,0,0},
		                {1,1,0,0}};
		assertEquals(pMeter, islandPerimeter(test));
	}
	
	@Test 
	public void test1(){
		int pMeter = 4;
		int[][] test = {{1},{0}};
		assertEquals(pMeter, islandPerimeter(test));
	}
	/*每一个陆地单元格的周长为4，当两单元格上下或者左右相邻时，令周长减2。
	h = len(grid)
        w = len(grid[0]) if h else 0
        ans = 0
        for x in range(h):
            for y in range(w):
                if grid[x][y] == 1:
                    ans += 4
                    if x > 0 and grid[x - 1][y]:
                        ans -= 2
                    if y > 0 and grid[x][y - 1]:
                        ans -= 2
        return ans
*/
	
}
