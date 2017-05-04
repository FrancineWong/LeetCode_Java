/*You are a professional robber planning to rob houses along a street. Each house has a certain amount 
 * of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses 
 * have security system connected and it will automatically contact the police if two adjacent houses were 
 * broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum
 amount of money you can rob tonight without alerting the police.*/
public class Q198_House_Robber {
	
	//dynamic programming
	
	public int rob(int[] nums) {
        // If we rob the even one, than we can not rob the odd one, and vice versa. So 'a' is even, and 'b' is odd.
		int a = 0;
	    int b = 0;
	    for (int i=0; i<nums.length; i++)
	    {
	        if (i%2==0) a = max(a+nums[i], b);
	        else b = max(a, b+nums[i]);
	    }
	    return max(a, b);
    }

	private int max(int i, int j) {
		if(i>j) return i;
		else return j;
	}
}
