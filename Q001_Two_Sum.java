import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/*Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
UPDATE (2016/2/13):
The return format had been changed to zero-based indices. Please read the above updated description carefully.*/

public class Q001_Two_Sum {
	//array, hash table
	//this method won't pass[0,2,3,0],0, we have to check the value from the end to the beginning
	public int[] twoSum(int[] nums, int target) {
        int[] res = {0,0};
        HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
        for(int i = 0; i<nums.length; i++) {
        	h.put(nums[i], i);
        }
        for(int i=0; i<nums.length; i++) {
        	if(h.containsKey(target - nums[i])) {
        		res[1] = i;
        		res[0] = h.get(target-nums[i]);
        	}
        }
        
        return res;
    }
	//This is method check the last number makes the target 
	public int[] twoSum_0(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[1] = i;
                result[0] = map.get(target - nums[i]);
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }
	
}
