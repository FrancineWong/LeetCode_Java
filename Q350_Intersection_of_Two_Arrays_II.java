import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/*Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:
 Each element in the result should appear as many times as it shows in both arrays.
 The result can be in any order.
Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you 
cannot load all elements into the memory at once?
 * */

public class Q350_Intersection_of_Two_Arrays_II {
	public int[] intersect(int[] nums1, int[] nums2) {
		if(nums1==null||nums2==null) return null;
		
		List<Integer> result = new ArrayList<Integer>();
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int index1 = 0;
		int index2 = 0;
		while(index1<nums1.length&&index2<nums2.length){
			if(nums1[index1]<nums2[index2]) {
				index1++;
			}else if(nums1[index1]==nums2[index2]) {
				result.add(nums1[index1]);
				index1++;
				index2++;
			}else {
				index2++;
			}
		}
		int[] finalResult = new int[result.size()];
		for(int i=0; i<result.size(); i++){
			finalResult[i] = result.get(i);
		}
		return finalResult;
	}
	
	@Test
	public void test(){
		int[] expected = new int[]{2,2};
		int[] result = intersect(new int[]{1,2,2,1},new int[]{2,2});
		assertEquals(expected, result);
	}
	
	@Test
	public void test1(){
		int[] expected = new int[]{};
		int[] result = intersect(new int[]{1,2,3,4}, new int[]{5,6,7,8});
		assertEquals(expected, result);
	}
	
	@Test
	public void test2(){
		int[] expected = new int[]{};
		int[] result = intersect(new int[]{}, new int[]{});
		assertEquals(expected, result);
	}
	

}








