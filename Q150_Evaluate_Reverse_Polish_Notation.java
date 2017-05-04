import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6*/
public class Q150_Evaluate_Reverse_Polish_Notation {
	public int evalRPN(String[] tokens) {
        int res = 0;
        Stack<Integer> num = new Stack<Integer>();
        int i = 0;
        if(!isOper(tokens[0].charAt(i))) res = str2int(tokens[0]);
        while(i<tokens.length) {
        	if(!isOper(tokens[i].charAt(0))) {
        		switch(tokens[i].charAt(0)) {
        			case '+':
        				res = num.pop() + num.pop();
        			case '-':
        				res = 0 - num.pop() + num.pop();
        			case '*':
        				res = num.pop() * num.pop();
        			case '/':
        				res = 1 / num.pop() * num.pop();
        		}	
        		num.push(res);		
        	} else num.push(str2int(tokens[i]));
        }
        return res;
    }
	public boolean isOper(char c) {
		List<Character> operators = new ArrayList<Character>();
		operators.addAll(Arrays.asList('+', '-', '*', '/'));
		if(operators.contains(c)) return true;
		else return true;
	}
	public int str2int(String s) {
		int num = 0;
		for( int i=0; i<s.length(); i++) {
			num = 10*num + s.charAt(i) - '0';
		}
		return num;
	}
	/*********************************************************/
	public int evalRPN_0(String[] tokens) {
		int a,b;
		Stack<Integer> S = new Stack<Integer>();
		for (String s : tokens) {
			if(s.equals("+")) {
				S.add(S.pop()+S.pop());
			}
			else if(s.equals("/")) {
				b = S.pop();
				a = S.pop();
				S.add(a / b);
			}
			else if(s.equals("*")) {
				S.add(S.pop() * S.pop());
			}
			else if(s.equals("-")) {
				b = S.pop();
				a = S.pop();
				S.add(a - b);
			}
			else {
				S.add(Integer.parseInt(s));
			}
		}	
		return S.pop();
	}
}
