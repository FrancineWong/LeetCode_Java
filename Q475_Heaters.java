import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

/*Winter is coming! Your first job during the contest is to design a standard heater with fixed warm radius to 
 * warm all the houses.

Now, you are given positions of houses and heaters on a horizontal line, find out minimum radius of heaters so that
 all houses could be covered by those heaters.

So, your input will be the positions of houses and heaters seperately, and your expected output will be the minimum 
radius standard of heaters.

Note:
Numbers of houses and heaters you are given are non-negative and will not exceed 25000.
Positions of houses and heaters you are given are non-negative and will not exceed 10^9.
As long as a house is in the heaters' warm radius range, it can be warmed.
All the heaters follow your radius standard and the warm radius will the same.
Example 1:
Input: [1,2,3],[2]
Output: 1
Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard, then all the houses
 can be warmed.
Example 2:
Input: [1,2,3,4],[1,4]
Output: 1
Explanation: The two heater was placed in the position 1 and 4. We need to use radius 1 standard, then all the 
houses can */
public class Q475_Heaters {
	public int findRadius(int[] houses, int[] heaters) {
		
        int[] dif = new int[heaters.length+1];
        for(int i=0; i<dif.length; i++) {
        	if(i==0) dif[i]=heaters[0]-houses[0];
        	else if(i==dif.length-1) dif[i] = houses[houses.length-1]-heaters[heaters.length-1];
        	else dif[i] = heaters[i]-heaters[i-1];
        }
        int max = 0;
        for(int i=1; i<dif.length-1; i++) {
        	if(dif[i]>=max) max = dif[i];
        }
        if(max>=dif[0]*2&&max>=dif[dif.length-1]) return max/2;
        else return dif[0]>dif[dif.length-1]?dif[0]:dif[dif.length-1];
    }
	
	@Test
	public void test_0() {
		int[] hou = {1,2,3,5,15};
		int[] het = {2,30};
		assertEquals(13, findRadius(hou, het));
	}
	
	@Test
	public void test_1() {
		int[] hou = {1,2,3,4};
		int[] het = {1,4};
		assertEquals(1, findRadius(hou, het));
	}
	/*The idea is to leverage decent Arrays.binarySearch() function provided by Java.

	For each house, find its position between those heaters (thus we need the heaters array to be sorted).
	Calculate the distances between this house and left heater and right heater, get a MIN value of those two values. 
	Corner cases are there is no left or right heater.
	Get MAX value among distances in step 2. It's the answer.
	Time complexity: max(O(nlogn), O(mlogn)) - m is the length of houses, n is the length of heaters.

*/
	public int findRadius_1(int[] houses, int[] heaters) {
		Arrays.sort(heaters);
	    int result = 0;
	    
	    for (int house : houses) {
	        int index = Arrays.binarySearch(heaters, house);
	        if (index < 0) {
	            index = ~index;
	            int dist1 = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
	            int dist2 = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;
	            
	            result = Math.max(result, Math.min(dist1, dist2));
	        }
	    }
	    
	    return result;
	}
	
}