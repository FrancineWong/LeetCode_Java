import java.util.Arrays;

public class Q473_Matchsticks_to_Square {
	/*According to https://en.wikipedia.org/wiki/Partition_problem, the partition problem (or number partitioning) 
	 * is the task of deciding whether a given multiset S of positive integers can be partitioned into two subsets 
	 * S1 and S2 such that the sum of the numbers in S1 equals the sum of the numbers in S2. The partition problem 
	 * is NP-complete.

	When I trying to think how to apply dynamic programming solution of above problem to this one (difference is 
	divid S into 4 subsets), I took another look at the constraints of the problem:
	The length sum of the given matchsticks is in the range of 0 to 10^9.
	The length of the given matchstick array will not exceed 15.
	Sounds like the input will not be very large... Then why not just do DFS? In fact, DFS solution passed judges.

	 */
	public boolean makesquare(int[] nums) {
		if(nums==null||nums.length<4) return false;
		int sum = 0;
		for(int num:nums) sum += num;
		if(sum%4!=0) return false;
		return dfs(nums, new int[4], 0, sum/4);
     }
	private boolean dfs(int[] nums, int[] sums, int index, int target) {
		if(index == nums.length) {
			if(sums[0]==target&&sums[1]==target&&sums[2]==target) {
				return true;
			}
			return false;
		}
		for(int i=0; i<4; i++) {
			if(sums[i]+nums[index]>target) continue;
			sums[i] += nums[index];
			if(dfs(nums, sums, index+1, target)) return true;
			sums[i] -= nums[index];
		}
		return false;
	}
}
