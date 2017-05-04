import java.util.Arrays;

public class Q377_Combination_Sum_IV {
	//run time error, occupied too much memory
	public int combinationSum4(int[] nums, int target) {
	    if (target == 0) {
	        return 1;
	    }
	    int res = 0;
	    for (int i = 0; i < nums.length; i++) {
	        if (target >= nums[i]) {
	            res += combinationSum4(nums, target - nums[i]);
	        }
	    }
	    return res;
	}
	/*for a DP solution, we just need to figure out a way to store the intermediate results, to avoid the same 
	 * combination sum being calculated many times. We can use an array to save those results, and check if there 
	 * is already a result before calculation. We can fill the array with -1 to indicate that the result hasn't 
	 * been calculated yet. 0 is not a good choice because it means there is no combination sum for the target.*/
	private int[] dp;
	public int combinationSum4_0(int[] nums, int target) {
	    dp = new int[target + 1];
	    Arrays.fill(dp, -1);
	    dp[0] = 1;
	    return helper(nums, target);
	}

	private int helper(int[] nums, int target) {
	    if (dp[target] != -1) {
	        return dp[target];
	    }
	    int res = 0;
	    for (int i = 0; i < nums.length; i++) {
	        if (target >= nums[i]) {
	            res += helper(nums, target - nums[i]);
	        }
	    }
	    dp[target] = res;
	    return res;
	}
	//bottom-up
	public int combinationSum4_1(int[] nums, int target) {
	    int[] comb = new int[target + 1];
	    comb[0] = 1;
	    for (int i = 1; i < comb.length; i++) {
	        for (int j = 0; j < nums.length; j++) {
	            if (i - nums[j] >= 0) {
	                comb[i] += comb[i - nums[j]];
	            }
	        }
	    }
	    return comb[target];
	}
}
