/*Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example:
Given num = 16, return true. Given num = 5, return false.

Follow up: Could you solve it without loops/recursion?

*/
public class Q342_Power_of_Four {
	public boolean isPowerOfFour(int num) {
		if(Math.log(num) / Math.log(2)%2!=0) return false;
        else return true;
    }
}
