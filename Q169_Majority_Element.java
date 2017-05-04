import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*Given an array of size n, find the majority element. The majority element is the 
 * element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in 
the array.
 * */
public class Q169_Majority_Element {
	public int majorityElement(int[] nums) {
		int max = 0;
        HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++) count.put(nums[i], 0);
        for(int i=0; i<nums.length; i++) count.put(nums[i], count.get(nums[i])+1);
        for(Map.Entry<Integer, Integer> entry: count.entrySet()){
        	if(entry.getValue()>(nums.length/2)) max = entry.getKey();
        }
        return max;
    }
	
	public int majorElement(int[] nums){
		int max = 1, i=0, result = nums[0];
		Arrays.sort(nums);
		while(i<nums.length){
			if(nums[i]==nums[i+1]){
				max++;
			}else{
				max=1;
			}
			i++;
			if(max>(nums.length/2)) result = nums[i]; break;
		}
		return result;
	}
}
