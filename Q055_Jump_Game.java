
/*Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.*/
public class Q055_Jump_Game {
	public boolean canJump(int[] nums) {
		int i = 0;
		// i <= reach, the furthest "start point" that I can reach
        // start point + nums[i] >= n, win!
        // start point + nums[i] < n, lose!
        // so greedy
	    for (int reach = 0; i < nums.length && i <= reach; ++i)
	        reach = Math.max(i + nums[i], reach);
	    return i == nums.length;
    }
}
