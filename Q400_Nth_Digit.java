/*Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...

Note:
n is positive and will fit within the range of a 32-bit signed integer (n < 231).

Example 1:

Input:
3

Output:
3
Example 2:

Input:
11

Output:
0

Explanation:
The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.*/
public class Q400_Nth_Digit {
	
	int[] seq = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
	
	public int findNthDigit(int n) {
		int len = 1, base = 1;
        while (n > 9L * base * len) {
          n -= 9 * base * len;
          len++;
          base *= 10;
        }
        int start = (n-1)/len + base, remain = (n-1)%len;
        while (remain-->0)
          base /= 10;
        return (start/base)%10;
    }
}
