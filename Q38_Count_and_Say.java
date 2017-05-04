import static org.junit.Assert.assertEquals;

import org.junit.Test;

/*The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.*/
public class Q38_Count_and_Say {
	public String countAndSay(int n) {
        String ret = "1";
        for(int i=1; i<=n; i++) ret = builder(ret);
        return ret;
    }
	
	public String builder(String num) {
		StringBuilder sb = new StringBuilder();
        char last = num.charAt(0);
        int count = 1;
        for(int i = 1;i<num.length();i++){
            if(num.charAt(i) == last){
                count++;
            }else{
                sb.append(String.valueOf(count));
                sb.append(last);
                last = num.charAt(i);
                count = 1;//set back count to 1 for a different char
            }
        }
        sb.append(count);
        sb.append(last);
        return sb.toString();
	}
	//sub function test
	@Test
	public void test_0() {
		assertEquals("11", builder("1"));
	}
	@Test
	public void test_1() {
		assertEquals("21", builder("11"));
	}
	@Test
	public void test_2() {
		assertEquals("1211", builder("21"));
	}
	@Test
	public void test_3() {
		assertEquals("111221", builder("1211"));
	}
}
