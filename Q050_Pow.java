/*Implement pow(x, n).*/
public class Q050_Pow {
	/*I couldn't find a clear explanation for an interative Log(n) solution so here's mine. The basic idea 
	 * is to decompose the exponent into powers of 2, so that you can keep dividing the problem in half. 
	 * For example, lets say

N = 9 = 2^3 + 2^0 = 1001 in binary. Then:

x^9 = x^(2^3) * x^(2^0)

We can see that every time we encounter a 1 in the binary representation of N, we need to multiply the 
answer with x^(2^i) where i is the ith bit of the exponent. Thus, we can keep a running total of repeatedly 
squaring x - (x, x^2, x^4, x^8, etc) and multiply it by the answer when we see a 1.

To handle the case where N=INTEGER_MIN we use a long (64-bit) variable. Below is solution:

*/
	public double myPow(double x, int n) {
		double ans = 1;
        long absN = Math.abs((long)n);
        while(absN > 0) {
            if((absN&1)==1) ans *= x;
            absN >>= 1;
            x *= x;
        }
        return n < 0 ?  1/ans : ans;
    }
}
