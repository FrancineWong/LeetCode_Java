/*Given an integer, write a function to determine if it is a power of three.

Follow up:
Could you do it without using any loop / recursion?*/
public class Q326_Power_of_Three {
	public boolean isPowerOfThree(int n) {
		//maxPower of three
		return n > 0 && (1162261467 % n == 0);
    }
}
