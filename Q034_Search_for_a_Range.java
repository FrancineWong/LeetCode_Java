import static org.junit.Assert.*;

import org.junit.Test;

/*34. Search for a Range   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 117564
Total Submissions: 380616
Difficulty: Medium
Contributors: Admin
Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].*/
public class Q034_Search_for_a_Range {
	public int[] searchRange(int[] nums, int target) {
		//find the first target and the last target, that's the range
		//sorted arrays
		//corner case: 1 or two elements
		int[] res = new int[2];
		int start = 0, end = nums.length - 1;
		while(start<=end) {
			int middle = (start+end)/2;
			if(nums[middle]<target) start = middle + 1;
			else if(nums[middle]>target) end = middle;
			else {
				int l = 1, r = 1;
				while(middle-l>=0&&nums[middle-l]==target) l++;
				while(middle+r<nums.length&&nums[middle+r]==target) r++;
				res[0] = middle-l+1;
				res[1] = middle+r-1;
				return res;
			}
		}
		res[0] = -1;
		res[1] = -1;
		return res;
    }
	/******************************************************************************************/
	public int[] searchRange_0(int[] nums, int target) {
        int start = Q034_Search_for_a_Range.firstGreaterEqual(nums, target);
		if (start == nums.length || nums[start] != target) {
			return new int[]{-1, -1};
		}
		return new int[]{start, Q034_Search_for_a_Range.firstGreaterEqual(nums, target + 1) - 1};
    }
    
    private static int firstGreaterEqual(int[] A, int target) {
		int low = 0, high = A.length;
		while (low < high) {
			int mid = low + ((high - low) >> 1);
			if (A[mid] < target) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return low;
	}
	/******************************************************************************************/
	/*def searchRange(self, nums, target):
    def search(lo, hi):
        if nums[lo] == target == nums[hi]:
            return [lo, hi]
        if nums[lo] <= target <= nums[hi]:
            mid = (lo + hi) / 2
            l, r = search(lo, mid), search(mid+1, hi)
            return max(l, r) if -1 in l+r else [l[0], r[1]]
        return [-1, -1]
    return search(0, len(nums)-1)*/
	
	@Test 
	public void test() {
		int[] expected = {3,4};
		int[] nums = {5,7,7,8,8,10};
		assertEquals(expected, searchRange(nums, 8));
	}
}
