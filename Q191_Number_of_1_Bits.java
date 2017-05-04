import static org.junit.Assert.assertEquals;

import org.junit.Test;

/*Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the 
 * Hamming weight).

For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function 
should return 3.*/
public class Q191_Number_of_1_Bits {
	// you need to treat n as an unsigned value
	public int hammingWeight(int n) {
		int wgh = 0;
		while(n!=0) {
			wgh += n&1;
			n= n>>>1; //>> 补位不确定 >>>补位为0
		}
        return wgh;
    }
	
	@Test
	public void test(){
//		assertEquals(32, hammingWeight(4294967295));
	}
}
