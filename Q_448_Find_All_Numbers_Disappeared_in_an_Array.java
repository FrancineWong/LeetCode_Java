import java.util.List;
import java.util.ArrayList;

/*
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and 
 * others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count 
as extra space.

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]
*/
public class Q_448_Find_All_Numbers_Disappeared_in_an_Array {
	public List<Integer> findDisappearedNumbers_1(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        int len = nums.length;
        int[] buffer = new int[len+1];
        for(int k=1; k<=len; k++) buffer[k] = 0;
        for(int i=0; i<len; i++) buffer[nums[i]]++;
        for(int j=1; j<=len; j++){
        	if(buffer[j] == 0) result.add(j);
        }
        return result;
    }
	
	public List<Integer> findDisappearedNumbers_2(int[] nums) {
		/*The basic idea is that we iterate through the input array and mark elements as negative using 
		 * nums[nums[i] -1] = -nums[nums[i]-1]. In this way all the numbers that we have seen will be 
		 * marked as negative. In the second iteration, if a value is not marked as negative, it implies 
		 * we have never seen that index before, so just add it to the return list.
*/
		List<Integer> ret = new ArrayList<Integer>();
        
        for(int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if(nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                ret.add(i+1);
            }
        }
        return ret;
    }
}
