
public class Q005_Longest_Palindromic_Substring {
	private int lo, maxLen;
	public String longestPalindrome(String s) {
		if(s.length()<=1) return s;
		
		for(int i=0; i<s.length(); i++) {
			findPalin(s, i, i);
			findPalin(s, i, i+1);
		}
		return s.substring(lo, lo+maxLen);
    }
	
	public void findPalin(String s, int head, int tail) {
		while(head>=0&&tail<s.length()&&s.charAt(head)==s.charAt(tail)) {
			head--;
			tail++;
		}
		if(maxLen<tail-head-1) {
			maxLen = tail - head - 1;
			lo = head + 1;
		}
	}
	
}
