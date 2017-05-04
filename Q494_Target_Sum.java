
public class Q494_Target_Sum {
	//find a subset of nums that need to be positive, rest are negative, such that the sum is equal to target
	//                  sum(P) - sum(N) = target
	//sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) +sum(N)
	//                        2* sum(P) = target + sum(nums)
	public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for(int n:nums) sum += n;
        return sum<S||(S+sum)%2>0?0:subsetSum(nums, (S+sum)>>>1);
    }
	public int subsetSum(int[] nums, int s) {
		int[] dp = new int[s+1];
		dp[0] = 1;
		for(int n:nums) {
			for(int i=s; i>=n; i--) {
				dp[i] += dp[i-n];
			}
		}
		return dp[s];
	}
}
