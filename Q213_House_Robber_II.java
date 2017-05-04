/*Note: This is an extension of House Robber.

After robbing those houses on that street, the thief has found himself a new place for his thievery so that 
he will not get too much attention. This time, all houses at this place are arranged in a circle. That means 
the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the 
same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum
 amount of money you can rob tonight without alerting the police.

*/
/*这道题是之前那道House Robber 打家劫舍的拓展，现在房子排成了一个圆圈，则如果抢了第一家，就不能抢最后一家，因为首尾相连了，
 * 所以第一家和最后一家只能抢其中的一家，或者都不抢，那我们这里变通一下，如果我们把第一家和最后一家分别去掉，各算一遍能抢的最大值，
 * 然后比较两个值取其中较大的一个即为所求。那我们只需参考之前的House Robber 打家劫舍中的解题方法，然后调用两边取较大值*/
public class Q213_House_Robber_II {
	public int rob_5(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        int[] a = new int[nums.length-1];
        int[] b = new int[nums.length-1];
        for(int i = 0; i<nums.length-1; i++) {
            a[i] = nums[i];
            b[i] = nums[i+1];
        }
        return Math.max(houseRob(a), houseRob(b));
    }
    public int houseRob(int[] nums) {
        int a = 0, b = 0;
        for(int i = 0; i<nums.length; i++) {
            if(i%2 == 0) {
                a += nums[i];
                a = Math.max(a, b);
            } else {
                b += nums[i];
                b = Math.max(a, b);
            }
        }
        return Math.max(a, b);
    }
	/*************************************************************************************/
	public int rob(int[] nums) {
        if(nums.length<=1) return nums==null?0:nums[0];
        return Math.max(rob(nums, 0, nums.length-1), rob(nums, 1, nums.length));
    }
	public int rob(int[] nums, int left, int right) {
		if(right - left <= 1) return nums[left];
		int[] dp = new int[right];
		dp[left] = nums[left];
		dp[left+1] = Math.max(nums[left], nums[left+1]);
		for(int i = left + 2; i<right; i++) dp[i] = Math.max(nums[i]+dp[i-2], dp[i-1]);
		return dp[right];
	}
    /**********************************************************************************/
    public int rob_0(int[] nums) {
            if (nums.length <= 1) return nums==null ? 0 : nums[0];
            return Math.max(rob_0(nums, 0, nums.length - 1), rob_0(nums, 1, nums.length));
    }
    public int rob_0(int[] nums, int left, int right) {
        int a = 0, b = 0;
        for (int i = left; i < right; ++i) {
            int m = a, n = b;
            a = n + nums[i];
            b = Math.max(m, n);
        }
        return Math.max(a, b);
    }
        /**************************************************************************************/
    public int rob_1(int[] nums) {
        if (nums.length <= 1) return nums==null ? 0 : nums[0];
        int[] v1 = nums, v2 = nums;
//        v1.erase(v1.begin()); v2.pop_back();
        return Math.max(rob_house(v1), rob_house(v2));
    }
    int rob_house(int[] nums) {
        int a = 0, b = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i % 2 == 0) {
                a += nums[i];
                a = Math.max(a, b);
            } else {
                b += nums[i];
                b = Math.max(a, b);
            }
        }
        return Math.max(a, b);
    }
}