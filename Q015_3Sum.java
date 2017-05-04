import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

/*Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique 
 * triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]*/
public class Q015_3Sum {
	public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++) {
        	if(i==0||(i>0&&nums[i]!=nums[i-1])) {
        		int l = i+1, h = nums.length - 1, sum = 0-nums[i];
	        	while(l<h) {
	        		if(nums[l]+nums[h]==sum) {
		        		res.add(Arrays.asList(nums[i], nums[l], nums[h]));
		        		while(l<h&&nums[l]==nums[l+1]) l++;
		        		while(l<h&&nums[h]==nums[h-1]) h--;
		        		l++;
		        		h--;
		        	}else if(nums[l]+nums[h]<sum){
		        		l++;
		         	}else h--;
	        	}
        	}
        }
        return res;
    }
	/***************************************************************************************************************/
	/*
	 * for i 1..n
    int s1 = K - A[i]
    for j 1..i
        int s2 = s1 - A[j]
        if (set.contains(s2))
            print the numbers
    set.add(A[i])*/
	/***************************************************************************************************************/
	/*I believe we can modify @John Feminella's excellent answer to use binary search, thereby reducing the run 
	 * time to O(nlgn). The custom function binary_search(alist, value, low, high) returns the index of value if 
	 * found, else -10 if it terminates on the left side, -20 if it terminates on the right:

	def triplet_sum(alist, total):
	    alist.sort() #modifies the list in place - more efficient than sorted() but not great if we need the list 
	    unmodified
	    left, right = 0, len(alist) - 1
	    while right > left:
	        elem = total - alist[left] - alist[right]
	        mid = binary_search(alist, elem, left, right)
	        if mid >= 0: #found
	            return (alist[left], alist[mid], alist[right])
	        elif mid == -10: #terminated left 
	            right -= 1
	        elif mid == -20: #terminated right
	            left += 1
	    return None
	First sort the list - O(nlgn) time
	left starts as 0, and right as n-1 (last index)
	Binary search for the third element that completes the total sum - O(logn) time
	If found, return the triplet
	If the binary search terminates in the left side of the list, decrement right
	If the binary search terminates in the right side, increment left
	The while loop runs O(n) times, each time doing O(logn) work, for a total of O(nlogn). Let me know if 
	this helps, and I'd love to hear any improvements/suggestions.*/
	/***********************************************************************************************************/
/*		int i;
        for (i = 0; i < len ; i++) {
                int left = i + 1;
                int right = len - 1;

                while (right > left) {

                        printf ("values are %d %d %d\n", arr[i], arr[left], arr[right]);
                        if (arr[right] + arr[left] + arr[i] - sum == 0) {
                                printf ("final values are %d %d %d\n", arr[i], arr[left], arr[right]);
                                return 1;
                        }
                        if (arr[right] + arr[left] + arr[i] - sum > 0)
                                right--;
                        else
                                left++;

                }

        }
        return -1;*/
}
