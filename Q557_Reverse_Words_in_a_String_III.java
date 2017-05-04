import java.util.Arrays;
import java.util.stream.Collectors;

public class Q557_Reverse_Words_in_a_String_III {
	public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        int l = 0, r = 0;
        while(l<s.length()&&r<s.length()) {
        	while(s.charAt(r)!=' '&&r<s.length()) r++;
        	res.append(reverse(s, l, r));
        	while(s.charAt(r)==' ') r++;
        	l = r;
        }
        return res.toString();
    }
	public String reverse(String s, int l, int r) {
		StringBuilder t = new StringBuilder();
		for(int i=r; i>=l; i--) {
			t.append(s.charAt(i));
		}
		return toString().toString();
	}
	/**************************************************/
	public String reverseWords_0(String s) {
        char[] ca = s.toCharArray();
        for (int i = 0; i < ca.length; i++) {
            if (ca[i] != ' ') {   // when i is a non-space
                int j = i;
                while (j + 1 < ca.length && ca[j + 1] != ' ') { j++; } // move j to the end of the word
                reverse(ca, i, j);
                i = j;
            }
        }
        return new String(ca);
    }

    private void reverse(char[] ca, int i, int j) {
        for (; i < j; i++, j--) {
            char tmp = ca[i];
            ca[i] = ca[j];
            ca[j] = tmp;
        }
    }
    /********************************************************/
    public String reverseWords_1(String s) {
        return Arrays.stream(s.split("\\s+"))
                     .map(StringBuilder::new)
                     .map(StringBuilder::reverse)
                     .collect(Collectors.joining(" "));
    }
    /***********************************************************/
    public String reverseWords_2(String s) {
        char[] c = s.toCharArray();
        int i = 0, j = 0;
        for(char cc: s.toCharArray()) {
            if(cc == ' ') {
                int end = j-1; 
            while(i<end) {
                char temp = c[i];
                c[i] = c[end];
                c[end] = temp;
                end--;
                i++;
            }
            i = j+1;
            } else if (j == s.length()-1) {
                int end = j; 
            while(i<end) {
                char temp = c[i];
                c[i] = c[end];
                c[end] = temp;
                end--;
                i++;
            }
            i = j+1;
            }
            j++;
        }
        return new String(c);
    }
}
