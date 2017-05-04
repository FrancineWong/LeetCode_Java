import java.util.ArrayList;
import java.util.List;

/*Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

Formally the function should:
Return true if there exists i, j, k 
such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
Your algorithm should run in O(n) time complexity and O(1) space complexity.

Examples:
Given [1, 2, 3, 4, 5],
return true.

Given [5, 4, 3, 2, 1],
return false.*/

public class Q334_Increasing_Triplet_Subsequence {
	//Similar, longest increasing subSequence
	/*Continuously update the range covered by 2 numbers represented by A[0] & A[1]. Initially they are 
	 * initialized by INT_MAX and we keep lowering their values. If anytime we find a number larger than A[1], 
	 * return true.*/
	/*我们遍历数组，维护一个最小值，和倒数第二小值，遍历原数组的时候，如果当前数字小于等于最小值，更新最小值，如果小于等于倒数第二小值，
	 * 更新倒数第二小值，如果当前数字比最小值和倒数第二小值都大，说明此时有三个递增的子序列了，直接返回ture，否则遍历结束返回false*/
	public boolean increasingTriplet(int[] nums) {
		int[] A = new int[2];
		A[0] = Integer.MAX_VALUE;
		A[1] = Integer.MAX_VALUE;
        if (nums.length < 3)
            return false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < A[0])
                A[0] = nums[i];
            else if (nums[i] > A[0] && nums[i] < A[1])
                A[1] = nums[i];
            else if (nums[i] > A[1])
                return true;
            else
                continue;
        }
        return false;
    }
	/************************  O(n)   **************************/
	public boolean increasingTriplet_0(int[] nums) {
        int len=nums.length;
        if(len<=3) return false;
        return LIS(nums)>=3;
    }
    
    public int LIS(int[] nums){
        List<Integer> result = new ArrayList<Integer>();
        result.add(Integer.MIN_VALUE);
        for(int num:nums){
            if(result.get(result.size()-1)<num)   
                result.add(num);
            else {
                int index=binarySearch(result, num);
                result.set(index, num);
            }
        }
        return result.size()-1;
    }
    
    public int binarySearch(List<Integer> nums, int target){
        int start=-1, end=nums.size()-1;
        int mid=0;
        while(end-start>1){
            mid=(start+end)/2;
            if(nums.get(mid)>=target) end=mid;
            else start=mid;
        }
        return end;
    }
    /***********************************************************************/
    /*这道题让我们求一个无序数组中是否有任意三个数字是递增关系的，我最先相处的方法是用一个dp数组，dp[i]表示在i位置之前小于等于
     * nums[i]的数字的个数(包括其本身)，我们初始化dp数组都为1，然后我们开始遍历原数组，对当前数字nums[i]，我们遍历其之前的所有数字，
     * 如果之前某个数字nums[j]小于nums[i]，那么我们更新dp[i] = max(dp[i], dp[j] + 1)，如果此时dp[i]到3了，则返回true，
     * 若遍历完成，则返回false*/
    public boolean increasingTriplet_1(int[] nums) {
        int[] dp = new int[nums.length];
        for(int i=0; i<nums.length; i++) dp[i] = 1;
        for (int i = 1; i < nums.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if (dp[i] >= 3) return true;
                }
            }
        }
        return false;
    }
}
