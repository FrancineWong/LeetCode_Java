import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the 
 * array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.*/
public class Q219_Contains_Duplicate_II {
	public boolean containsNearbyDuplicate_0(int[] nums, int k) {
		//run time error
		int min = Integer.MAX_VALUE;
        if(nums==null||nums.length<=1) return false;
		for(int i=0; i<nums.length; i++) {
			for(int j=nums.length-1; j>i; j--) {
				if(nums[i]==nums[j]) {
					if((j-i+1)<=min) min = j-i;
				}
			}
		}
        return min<=k;
    }
	
	public boolean containsNearByDuplicate_1(int[] nums, int k) {
		int min = Integer.MAX_VALUE;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i=0; i<nums.length; i++) {
			map.put(nums[i], 0);
		}
		for(int i=0; i<nums.length; i++) {
			map.put(nums[i], map.get(nums[i])+1);
		}
		
		for(int i=0; i<nums.length; i++) {
			if(map.get(nums[i])>=2) {
				int j = 1;
				while(nums[i+j]!=nums[i]) j++; //index out of bound exception
				if(j<=min) min = j;
			}
		}
		return min<=k;
	}
	
	/*************************************************************/
	/*Explanation: It iterates over the array using a sliding window. The front of the window is at i, the rear 
	 * of the window is k steps back. The elements within that window are maintained using a set. While adding 
	 * new element to the set, if add() returns false, it means the element already exists in the set. At that 
	 * point, we return true. If the control reaches out of for loop, it means that inner return true never 
	 * executed, meaning no such duplicate element was found.*/
	public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i-k-1]);
            if(!set.add(nums[i])) return true;
        }
        return false;
 }
}
