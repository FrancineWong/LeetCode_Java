import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

/*Write a program to check whether a given number is an ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly 
while 14 is not ugly since it includes another prime factor 7.

Note that 1 is typically treated as an ugly number.*/
public class Q263_Ugly_Number {
//	static final List<Integer> ugly = new ArrayList<Integer>(){{
//		ugly.add(2);
//		ugly.add(3);
//		ugly.add(5);
//	}};
	
//	public static final List<Integer> ugly = Collections.unmodifiableList(
//		    new ArrayList<Integer>() {/**
//				 * 
//				 */
//				private static final long serialVersionUID = 1L;
//
//			{
//		        add(2);
//		        add(3);
//		        add(5);
//		    }});
	
	public boolean isUgly(int num) {
		List<Integer> ugly = new ArrayList<Integer>();
		ugly.add(2);
		ugly.add(3);
		ugly.add(5);
		if(num==1) return true;
		//find the prime factors
		int pr = 0;
		if(num%2==0) return isUgly(num/2);
		else{
			for(int i=3; i<Math.sqrt(num); i+=2){
				if(num%i==0) pr=i;
			}
		}
		if(pr==0) pr = num;
		if(!ugly.contains(pr)) return false;
		else return isUgly(num/pr);
    }
	
	public boolean isUgly_1(int num) {
		//Just divide by 2, 3 and 5 as often as possible and then check whether we arrived at 1.
		//Also try divisor 4 if that makes the code simpler / less repetitive.
		for (int i=2; i<6 && num>0; i++)
		    while (num % i == 0)
		        num /= i;
		return num == 1;
	}
	
	@Test
	public void test_0() {
		assertEquals(false, isUgly(14));
	}
	
	@Test
	public void test_1() {
		assertEquals(true, isUgly(5));
	}
	@Test
	public void test_2() {
		assertEquals(true, isUgly(4));
	}
	@Test
	public void test_3() {
		assertEquals(true, isUgly(3));
	}
	
	@Test
	public void test_4() {
		assertEquals(true, isUgly(9));
	}
	@Test
	public void test_5() {
		assertEquals(true, isUgly(2));
	}
}
