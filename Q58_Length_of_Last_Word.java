import static org.junit.Assert.*;

import org.junit.Test;

/*Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of 
 * last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.*/
public class Q58_Length_of_Last_Word {
	public int lengthOfLastWord(String s) {
        int len = 0;
        int index = s.length()-1;
        while(index>=0&&s.charAt(index) ==' ') index--;
        while(index>=0&&s.charAt(index)!=' ') {
        	len++;
        	index--;
        }
        return len;
    }
	
	@Test
	public void test_0() {
		assertEquals(1, lengthOfLastWord("a "));
	}
	
}
