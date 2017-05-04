import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Test;

/*Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, 
replace the number by the sum of the squares of its digits, and repeat the process until the number equals 
1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which 
this process ends in 1 are happy numbers.

Example: 19 is a happy number

12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
*/
/*当出现非1的重复平方和时，返回False*/

public class Q202_Happy_Number {
	HashSet<Integer> buffer = new HashSet<Integer>();
	public boolean isHappy(int n) {
        if(n==1) return true;
        int num = 0;
        while(n>0){
        	num += Math.pow(n%10, 2);
        	n /= 10;
        }
        if(buffer.contains(num)) return false;
        else buffer.add(num);
        return isHappy(num);
    }
	
	@Test
	public void test(){
		assertEquals(true, isHappy(19));
	}
	@Test
	public void test1(){
		assertEquals(true, isHappy(7));
	}
	
	@Test
	public void test2(){
		assertEquals(false, isHappy(2));
	}
}
