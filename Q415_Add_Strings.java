import static org.junit.Assert.*;

import org.junit.Test;

/*Given two non-negative numbers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.*/

public class Q415_Add_Strings {
	public String addStrings(String num1, String num2) {
		if (num1.length() == 0) return num2;
        else if (num2.length() == 0) return num1;

        boolean hasUp = false;// 是否进位
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (i >=0 || j >= 0) {
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sum = n1 + n2 + (hasUp ? 1 : 0);
            if (sum >= 10) {
                sb.insert(0, Integer.toString(sum - 10));
                hasUp = true;
            } else {
                sb.insert(0, Integer.toString(sum));
                hasUp = false;
            }
            i--;
            j--;
        }
        if (hasUp) sb.insert(0, "1");
        return sb.toString();
    }
	
	@Test 
	public void test(){
		assertEquals("2", addStrings("1", "1"));
	}
	
	@Test
	public void test1(){
		assertEquals("100", addStrings("50", "50"));
	}
	
	@Test 
	public void test2(){
		assertEquals("100", addStrings("99", "1"));
	}
	
	@Test
	public void test3(){
		assertEquals("324649", addStrings("294814","29835"));
	}
	@Test
	public void test4(){
		assertEquals("602", addStrings("584", "18"));
	}
	@Test 
	public void test5(){
		assertEquals("400", addStrings("12", "388"));
	}

}
