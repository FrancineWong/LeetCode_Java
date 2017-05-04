import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/*Count the number of segments in a string, where a segment is defined to be a contiguous sequence of 
 * non-space characters.

Please note that the string does not contain any non-printable characters
Example:

Input: "Hello, my name is John"
Output: 5
*/
public class Q434_Number_of_Segments_in_a_String {
	public int countSegments(String s) {
		int num = 0;
		if(s.length()==0) return 0;
        for(int i=0; i<s.length()-1; i++){
        	if(s.charAt(i)!=' '&&s.charAt(i+1)==' '){
        		num++;
        	}
        }
        if(s.charAt(s.length()-1)!=' ') num++;
        return num;
    }
	
	@Test
	public void test_0(){
		assertEquals(5, countSegments("Hello, my name is John"));
	}
	
	@Test
	public void test_1(){
		assertEquals(0, countSegments("             "));
	}
	@Test
	public void test_2(){
		assertEquals(5, countSegments("  Hello, my name is John "));
	}
}
