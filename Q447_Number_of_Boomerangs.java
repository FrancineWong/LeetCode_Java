import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/*Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of 
 * points (i, j, k) such that the distance between i and j equals the distance between i and k 
 * (the order of the tuple matters).

Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points 
are all in the range [-10000, 10000] (inclusive).

Example:
Input:
[[0,0],[1,0],[2,0]]

Output:
2

Explanation:
The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]*/

public class Q447_Number_of_Boomerangs {
	//O(N^3) too complex
	public int numberOfBoomerangs_1(int[][] points) {
        int number = 0;
        for(int i=0; i<points.length-2; i++){
        	for(int j=i+1; j<points.length-1; j++){
        		for(int k=j+1; k<points.length; k++){
        			int distance1 = (int) (Math.pow(points[i][0]-points[j][0], 2)-
        					Math.pow(points[i][1]-points[j][1], 2));
        			int distance2 = (int) (Math.pow(points[i][0]-points[k][0], 2)-
        					Math.pow(points[i][1]-points[k][1], 2));
        			int distance3 = (int) (Math.pow(points[j][0]-points[k][0], 2)-
        					Math.pow(points[j][1]-points[k][1], 2));
        			if(distance1==distance2||distance1==distance3||distance2==distance3){
        				number++;
        			}
        		}
        	}
        }
        return number*2;
    }
	
	//路径搜索，相同距离，相同起点
	//tag hash table
	/*For every i, we capture the number of points equidistant from i. Now for this i, we have to calculate 
	 * all possible permutations of (j,k) from these equidistant points.
	Total number of permutations of size 2 from n different points is nP2 = n!/(n-2)! = n * (n-1). */
	public int numberOfBoomerangs(int[][] points){
		int res = 0;
	    Map<Integer, Integer> map = new HashMap<>();
	    for(int i=0; i<points.length; i++) {
	        for(int j=0; j<points.length; j++) {
	            if(i == j)
	                continue;
	            int d = getDistance(points[i], points[j]);                
	            map.put(d, map.getOrDefault(d, 0) + 1);
	        }
	        
	        for(int val : map.values()) {
	            res += val * (val-1);
	        }            
	        map.clear();
	    }    
	    return res;
	}
	private int getDistance(int[] a, int[] b) {
	    int dx = a[0] - b[0];
	    int dy = a[1] - b[1];
	    return dx*dx + dy*dy;
	}

	
	@Test
	public void test(){
		int[][] points = {{0,0},{1,0},{2,0}};
		assertEquals(2,numberOfBoomerangs(points));
	}
}
