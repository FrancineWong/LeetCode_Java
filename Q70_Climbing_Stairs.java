import java.util.Arrays;

/*You are climbing a stair case. It takes n steps to reach to the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?*/

public class Q70_Climbing_Stairs {
	//time limit 
	public int climbStairs_0(int n) {
		if(n<0) return 0;
        else if(n==0) return 1;
        else return climbStairs(n-1) + climbStairs(n-2);
    }
	/***********************************************/
	public int climbStairs(int n) {
		int[] memo = new int[n+1];
		Arrays.fill(memo, -1);
		return climbStairs(n, memo);
	}
	
	public int climbStairs(int n, int[] memo) {
		if(n<0) return 0;
		else if(n==0) return 1;
		else if(memo[n]>-1) return memo[n];
		else {
			memo[n] = climbStairs(n-1, memo) + climbStairs(n-2, memo);
			return memo[n];
		}
	}
	
}
