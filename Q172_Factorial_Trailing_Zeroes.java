import static org.junit.Assert.assertEquals;

import org.junit.Test;

/*Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.*/

public class Q172_Factorial_Trailing_Zeroes {
	
	//Run time expired
	public int trailingZeroes(int n) {
		int fct = 1;
        for(int i=1; i<=n; i++){
        	fct *= i;
        }
        int num=0;
        while(fct%10==0){
        	num++;
        	fct /= 10;
        }
        return num;
    }
	
	public int trailingZeros_1(int n){
		int num_10 = n/10;
		//some of the numbers are power of 5 should be considered in
		int pow_5 = 5;
		int num = 0;
		int sum = 0;
		while(pow_5<=n){
			sum += num++;
			pow_5 *= 5;
		}
		if((n-num_10*10)>=5) sum += 1;
		return n>=5?(num_10*2+sum):(num_10*2);
	}
	
	/*This question is pretty straightforward.

	Because all trailing 0 is from factors 5 * 2.

	But sometimes one number may have several 5 factors, for example, 25 have two 5 factors, 125 have three 5 factors. 
	In the n! operation, factors 2 is always ample. So we just count how many 5 factors in all number from 1 to n.*/
	
	public int trailingZeros_2(int n) {
		return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
	}
	
	@Test
	public void test_0() {
		assertEquals(24, trailingZeros_1(100));
	}
	
	@Test
	public void test_1() {
		assertEquals(1, trailingZeros_1(9));
	}
	
	@Test
	public void test_2() {
		assertEquals(18, trailingZeros_1(75));
	}
	
	@Test
	public void test_3() {
		assertEquals(0, trailingZeros_1(0));
	}
	
	@Test
	public void test_4() {
		assertEquals(1, trailingZeros_1(5));
	}
	
	@Test
	public void test_5() {
		assertEquals(6, trailingZeros_1(25));
	}
	
}
