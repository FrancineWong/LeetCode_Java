import static org.junit.Assert.assertEquals;

import org.junit.Test;

/*Given an integer, write a function to determine if it is a power of two.*/
public class Q231_Power_of_Two {
	public boolean isPowerOfTwo(int n) {
		if(n<=0) return false;
		while(n>1){
			if(n%2!=0) return false;
			n /= 2;
		}
		return true;
    }
	
	@Test
	public void test(){
		assertEquals(true, isPowerOfTwo(2));
	}
	@Test
	public void test1(){
		assertEquals(true, isPowerOfTwo(2048));
	}
	
	@Test
	public void test2(){
		assertEquals(false, isPowerOfTwo(5));
	}
}
