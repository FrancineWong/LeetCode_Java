import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*Given a nested list of integers represented as a string, implement a parser to deserialize it.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Note: You may assume that the string is well-formed:

String is non-empty.
String does not contain white spaces.
String contains only digits 0-9, [, - ,, ].
Example 1:

Given s = "324",

You should return a NestedInteger object which contains a single integer 324.
Example 2:

Given s = "[123,[456,[789]]]",

Return a NestedInteger object containing a nested list with 2 elements:

1. An integer containing value 123.
2. A nested list containing two elements:
    i.  An integer containing value 456.
    ii. A nested list with one element:
         a. An integer containing value 789.*/
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
/*This approach will just iterate through every char in the string (no recursion).

If encounters '[', push current NestedInteger to stack and start a new one.
If encounters ']', end current NestedInteger and pop a NestedInteger from stack to continue.
If encounters ',', append a new number to curr NestedInteger, if this comma is not right after a brackets.
Update index l and r, where l shall point to the start of a integer substring, while r shall points to the end+1 
of substring.
*/
public class Q385_Mini_Parser {
	public NestedInteger deserialize(String s) {
	      //return a NestedInteger with a single integer
			if(s.charAt(0)!='[') return new NestedInteger(Integer.parseInt(s));
			
			int len = s.length();
			Stack<NestedInteger> stack = new Stack<>();
			StringBuilder num = new StringBuilder();
			
			for(int i=0; i<len; i++) {
				switch(s.charAt(i)) {
				case '[' :
					stack.push(new NestedInteger());
					break;
				case ',' :
					//judge if it's a num before ','
					if(num.length() != 0) {
						stack.peek().add(new NestedInteger(Integer.parseInt(num.toString())));
						num.delete(0, num.length()); //clear num
					}
					break;
				case ']' :
					//judge if it's a num before ','
					if(num.length()!=0) {
						stack.peek().add(new NestedInteger(Integer.parseInt(num.toString())));
						num.delete(0, num.length()); //clear num
					}
					NestedInteger ni = stack.pop();
					if(!stack.isEmpty()) {
						stack.peek().add(ni);
					}else{
						return ni;
					}
					break;
				default:
					num.append(s.charAt(i));
					break;
				}
			}
			return null;
	    }
	/*This approach will just iterate through every char in the string (no recursion).
	If encounters '[', push current NestedInteger to stack and start a new one.
	If encounters ']', end current NestedInteger and pop a NestedInteger from stack to continue.
	If encounters ',', append a new number to curr NestedInteger, if this comma is not right after a brackets.
	Update index l and r, where l shall point to the start of a integer substring, while r shall points to the end+1 of substring.*/
	public NestedInteger deserialize_1(String s) {
	    if (s.isEmpty())
	        return null;
	    if (s.charAt(0) != '[') // ERROR: special case
	        return new NestedInteger(Integer.valueOf(s));
	        
	    Stack<NestedInteger> stack = new Stack<>();
	    NestedInteger curr = null;
	    int l = 0; // l shall point to the start of a number substring; 
	               // r shall point to the end+1 of a number substring
	    for (int r = 0; r < s.length(); r++) {
	        char ch = s.charAt(r);
	        if (ch == '[') {
	            if (curr != null) {
	                stack.push(curr);
	            }
	            curr = new NestedInteger();
	            l = r+1;
	        } else if (ch == ']') {
	            String num = s.substring(l, r);
	            if (!num.isEmpty())
	                curr.add(new NestedInteger(Integer.valueOf(num)));
	            if (!stack.isEmpty()) {
	                NestedInteger pop = stack.pop();
	                pop.add(curr);
	                curr = pop;
	            }
	            l = r+1;
	        } else if (ch == ',') {
	            if (s.charAt(r-1) != ']') {
	                String num = s.substring(l, r);
	                curr.add(new NestedInteger(Integer.valueOf(num)));
	            }
	            l = r+1;
	        }
	    }
	    
	    return curr;
	}
	/*这道题让我们实现一个迷你解析器用来把一个字符串解析成NestInteger类，关于这个嵌套链表类的题我们之前做过三道，Nested List Weight Sum II，
	 * Flatten Nested List Iterator，和Nested List Weight Sum。应该对这个类并不陌生了，我们可以先用递归来做，思路是，首先判断s是否为空，
	 * 为空直接返回，不为空的话看首字符是否为'['，是的话说明s为一个整数，我们直接返回结果。如果首字符是'['，且s长度小于等于2，说明没有内容，直接返回结果。
	 * 反之如果s长度大于2，我们从i=1开始遍历，我们需要一个变量start来记录某一层的其实位置，用cnt来记录跟其实位置是否为同一深度，cnt=0表示同一深度，
	 * 由于中间每段都是由逗号隔开，所以当我们判断当cnt为0，且当前字符是逗号或者已经到字符串末尾了，我们把start到当前位置之间的字符串取出来递归调用函数，
	 * 把返回结果加入res中，然后start更新为i+1。如果遇到'['，计数器cnt自增1，若遇到']'，计数器cnt自减1。参见代码如下*/
	//答案有问题，并不能
	public NestedInteger desetialize_0(String s) {
		NestedInteger res = new NestedInteger();
		if(s.isEmpty()) return res;
		if(s.length()<=2) return res;
		if(s.charAt(0)!='[') {
		    res.setInteger(Integer.parseInt(s));
			return res;
		}
		int start = 1, cnt = 0;
		for(int i=1; i<s.length(); i++) {
			if(cnt==0&&(s.charAt(i)==','||i==s.length()-1)) {
				res.add(deserialize(s.substring(start, i-start)));
				start = i+1;
			}else if(s.charAt(i)=='[') ++cnt;
			else if(s.charAt(i)==']') --cnt;
		}
		return res;
	}
}
