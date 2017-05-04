/*Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, 
 * inclusive.

For example, given the range [5, 7], you should return 4.

*/
public class Q201_Bitwise_AND_of_Numbers_Range {
	/* 1. last bit of (odd number & even number) is 0
	 * 2. when m != n, There is at least an odd number and an even number, so the last bit position result is 0.
	 * 3. Move m and n rigth a position.
	 * */
	public int rangeBitwiseAnd(int m, int n) {
		if(m == 0){
            return 0;
        }
        int moveFactor = 1;
        while(m != n){
            m >>= 1;
            n >>= 1;
            moveFactor <<= 1;
        }
        return m * moveFactor;
    }
	/******************************************************************************/
	public int rangeBitwiseAnd_0(int m, int n) {
	    int step = 0;
	    while(m!=n){
	        m >>= 1;
	        n >>= 1;
	        step ++;
	    }
	    return m<<step;
	}
	/******************************************************************************/
	/* 最后的数是该数字范围内所有的数的左边共同的部分, 每相邻的数相差一个比特位
	 * 发现了规律后，我们只要写代码找到左边公共的部分即可，我们可以从建立一个32位都是1的mask，然后每次向左移一位，比较m和n是否相同，
	 * 不同再继续左移一位，直至相同，然后把m和mask相与就是最终结果，代码如下：*/
	public int rangeBitwiseAnd_1(int m, int n) {
		int d = Integer.MAX_VALUE;
		while ((m & d) != (n & d)) {
		    d <<= 1;
		}
		return m & d;
	}
}
