import static org.junit.Assert.*;

import org.junit.Test;

/*Determine whether an integer is a palindrome. Do this without extra space.*/
public class Q9_Palindrome_NumberQ {
	public boolean isPalindrome(int x) {
		int n = x;//x is always changing, if compare at the return it will be wrong
        int rev = 0;
        if(n<0) return false;
		while(n>0) {
			rev = 10*rev+n%10;
			n /= 10;
		}
		return rev==x;
    }
	
	
	static int result = 0;
	public static int reverseInteger(int x) {
		if(x>0) {
			result = 10*result+x%10;
			return reverseInteger(x/10);
 		}
		else return result;
	}
	
	
	@Test
	public void test_0() {
		assertEquals(true, isPalindrome(12321));
	}
	
	@Test
	public void test_1() {
		assertEquals(true, isPalindrome(0));
	}
	
	@Test
	public void test_2() {
		assertEquals(false, isPalindrome(12345));
	}
	
	@Test
	public void test_3() {
		assertEquals(true, isPalindrome(1));
	}
	
}
