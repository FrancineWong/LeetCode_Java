import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? 
 * Find all unique quadruplets in the array which gives the sum of target.

Note: The solution set must not contain duplicate quadruplets.

For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]*/
public class Q018_4Sum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        if(nums.length<4) return res;
        for(int i=0; i<nums.length-3; i++) {
        	if(i>0&&nums[i]==nums[i-1]) continue;
            	for(int j=i+1; j<nums.length-2; j++) {
            		if(j>(i+1)&&nums[j]==nums[j-1]) continue;
            		    int l = j+1, h = nums.length-1;
                		while(l<h){
                		    int sum = nums[i] + nums[j] + nums[l] + nums[h];
                		    if(sum==target) {
                    			res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[h]));
                    			while(l<h&&nums[l]==nums[l+1]) l++;
                    			while(l<h&&nums[h]==nums[h-1]) h--;
                    			l++;
                    			h--;
                    		}else if(sum<target) l++;
                    		else h--;
                		}
            	}
        }
        return res;
    }
	
}
