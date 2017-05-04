import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
 * */

public class Q171_Excel_Sheet_Column_Number {
	public int titleToNumber(String s) {
        int result = 0;
       
        for(int i=0; i<s.length(); i++){
        	result = s.charAt(i)-'A'+1+result*26;
        }
        return result;
    }
	
	@Test
	public void test(){
		assertEquals(28, titleToNumber("AB"));
	}
	
	@Test
	public void test1(){
		assertEquals(26, titleToNumber("Z"));
	}
	
	@Test 
	public void test2(){
		assertEquals(1, titleToNumber("A"));
	}

}
