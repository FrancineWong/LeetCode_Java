/*Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.*/
public class Q125_Valid_Palindrome {
	
	public boolean isPalindrome(String s) {
		if(s==null||s=="") return true;
		int start = 0; 
		int end = s.length()-1;
		while(start<end) {
			if(!isChar(s.charAt(start))) start++;
			else if(!isChar(s.charAt(end))) end--;
			else if(!isEqual(s.charAt(start), s.charAt(end))) return false;
			start++;
			end--;
		}
        return true;
    }
	
	public boolean isEqual(char a, char b) {
		if(a-b==0) return true;
		else if(Math.abs(a-b)==32) return true;
		else return false;
	}
	
	public boolean isChar(char c) {
		if((c>='a'&&c<='z')||(c>='A'&&c<='Z')||(c>='0'&&c<='9')) return true;
		else return false;
	}

	
}
