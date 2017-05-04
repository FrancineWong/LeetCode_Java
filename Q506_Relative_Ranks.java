import java.util.Arrays;

public class Q506_Relative_Ranks {
	/*Basically this question is to find out the score -> ranking mapping. The easiest way is to sort those scores 
	 * in nums. But we will lose their original order. We can create (score , original index) pairs and sort them by 
	 * score decreasingly. Then we will have score -> ranking (new index) mapping and we can use original index to 
	 * create the result.

	Time complexity: O(NlgN). Space complexity: O(N). N is the number of scores.
	
	Example:
	
	nums[i]    : [10, 3, 8, 9, 4]
	pair[i][0] : [10, 3, 8, 9, 4]
	pair[i][1] : [ 0, 1, 2, 3, 4]
	
	After sort:
	pair[i][0] : [10, 9, 8, 4, 3]
	pair[i][1] : [ 0, 3, 2, 4, 1]*/
	public String[] findRelativeRanks(int[] nums) {
		int[][] pair = new int[nums.length][2];
		for(int i=0; i<nums.length; i++) {
			pair[i][0] = nums[i];
			pair[i][1] = i;
		}
		Arrays.sort(pair, (a,b)->(b[0]-a[0]));
        String[] rank = new String[nums.length];
        for(int i=0; i<nums.length; i++) {
        	if(i==0) rank[pair[i][1]]="Gold Medal";
        	else if(i==1) rank[pair[i][1]] = "Silver Medal";
        	else if(i==2) rank[pair[i][1]] = "Bronze Medal";
        	else rank[pair[i][1]] = (i+1) + "";
        }
        
        return rank;
    }
	public String[] findRelativeRanks_0(int[] nums) {
        Integer[] index = new Integer[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            index[i] = i;
        }
        
        Arrays.sort(index, (a, b) -> (nums[b] - nums[a]));
        
        String[] result = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                result[index[i]] = "Gold Medal";
            }
            else if (i == 1) {
                result[index[i]] = "Silver Medal";
            }
            else if (i == 2) {
                result[index[i]] = "Bronze Medal";
            }
            else {
                result[index[i]] = (i + 1) + "";
            }
        }

        return result;
    }
}
