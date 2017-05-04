import static org.junit.Assert.*;

import org.junit.Test;

/**Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
 */

public class Q168_Excel_Sheet_Column_Title {
	String result = "";
	public String convertToTitle(int n) {
		if(n==0){
			return result;
		}else{
			return convertToTitle((n-1)/26)+(char)('A'+(n-1)%26);
		}		
    }
	
	@Test 
	public void test(){
		assertEquals("A", convertToTitle(1));
	}
	@Test
	public void test1(){
		assertEquals("AB", convertToTitle(28));
	}
	
	@Test
	public void test2(){
		assertEquals("Z", convertToTitle(26));
	}

}
