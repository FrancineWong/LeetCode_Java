import java.util.HashSet;
import java.util.Set;

/*
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.

Set 可以保证唯一性

 */
public class IntersectionOfTwoArrays {
	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set = new HashSet<Integer>();
		for(int i=0; i<nums1.length; i++){
			for(int j=0; j<nums2.length; j++){
				if(nums1[i]==nums2[j]){
					set.add(nums1[i]);
					continue;
				}
			}
		}
		int[] result = new int[set.size()];
		int i = 0;
		for(Integer val:set) result[i++] = val;
		return result;
    }

}
