
public class Q299_Bulls_and_Cows {
	public String getHint_0(String secret, String guess) {
		int bulls = 0;
	    int cows = 0;
	    int[] numbers = new int[10];
	    for (int i = 0; i<secret.length(); i++) {
	        if (secret.charAt(i) == guess.charAt(i)) bulls++;
	        else {
	            if (numbers[secret.charAt(i)-'0']++ < 0) cows++;
	            /*numbers[secret.charAt(i)-'0'] is negative only 
	            if this character appeared in the guess more times then in the secret which means that this character 
	            in the secret can be matched with one of the previous characters in the guest. I hope this explanation 
	            makes sense.*/
	            if (numbers[guess.charAt(i)-'0']-- > 0) cows++;
	        }
	    }
	    return bulls + "A" + cows + "B";
	}
	
}
