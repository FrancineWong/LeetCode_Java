import java.util.HashSet;

/*
 * Given an array of integers, find if the array contains any duplicates. 
 * Your function should return true if any value appears at least twice in the array, 
 * and it should return false if every element is distinct.
 * */

public class Q217_Contains_Duplicate {
	
	/*run time exceeded*/
	public boolean containsDuplicate(int[] nums) {
		for(int i=0; i<nums.length; i++){
			for(int j=i+1; j<nums.length; j++){
				if(nums[i]==nums[j]) return true;
			}
		}
        return false;
    }
	/*run time error end*/
	
	
	/**/
	public boolean containsDupalicates(int[] nums){
		HashSet<Integer> buffer = new HashSet<Integer>();
		for(int i:nums) buffer.add(i);
		return buffer.size()==nums.length?false:true;
	}
}
