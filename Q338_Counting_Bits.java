/**Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number 
 * of 1's in their binary representation and return them as an array.

Example:
For num = 5 you should return [0,1,1,2,1,2].

Follow up:

It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time 
O(n) /possibly in a single pass?
Space complexity should be O(n).
Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any 
other language.

Hint:
You should make use of what you have produced already.*/
public class Q338_Counting_Bits {
	/*f[i] = f[i >> 1] + (i & 1) . This is more straight-forward. Right shit by 1 bit, compare to previously, 
	 * the number of set bit would either reduce by 1(when number is odd) or no change(when number is even), 
	 * that is why we add ( i & 1 ) which reflects whether the number is even or odd.
	 * 倒过来想，一个数 * 2 就是把它的二进制全部左移一位，也就是说 1的个数是相等的。
		那么我们可以利用这个结论来做。
		res[i /2] 然后看看最低位是否为1即可（上面*2一定是偶数，这边比如15和14除以2都是7，但是15时通过7左移一位并且+1得到，14则是直接左移）
		所以res[i] = res[i >>1] + (i&1)*/
	public int[] countBits(int num) {
		//An easy recurrence for this problem is f[i] = f[i / 2] + i % 2.
		int[] f = new int[num + 1];
	    for (int i=1; i<=num; i++) f[i] = f[i >> 1] + (i & 1);
	    return f;
    }
	/*想一想，当一个数为2的整数幂的时候，1的个数为1，比如2（10) 和4(100)，8(1000)

	在这之后就是前一个序列的数+1 比如 9(1001) = 1(1) + 8 (1) = 2
	
	就是把一个数分解为小于它的最大2的整数幂 + x
	
	*/
	public int[] countBits_0(int num) {
        int[] res = new int[num+1];
        int pow2 = 1,before =1;
        for(int i=1;i<=num;i++){
            if (i == pow2){
                before = res[i] = 1;
                pow2 <<= 1;
            }
            else{
                res[i] = res[before] + 1;
                before += 1;
            }
        }
        return res;
    }
}
