/*We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I'll tell you whether the number is higher or lower.

You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):

-1 : My number is lower
 1 : My number is higher
 0 : Congrats! You got it!
Example:
n = 10, I pick 6.

Return 6.*/

/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Q374_Guess_Number_Higher_or_Lower extends GuessGame{
	
	//Binary search	
	/*lo = 1, hi = size(A)
   while lo <= hi:
      mid = lo + (hi-lo)/2
      if A[mid] == target:
         return mid            
      else if A[mid] < target: 
         lo = mid+1
      else:
         hi = mid-1*/
	public int guessNumber(int n) {	
		int l = 1, h = n;
        int m = 0;
		while(l<=h) {
			m = l+(h-l)/2;
			if(guess(m)==0) return m;
			else if(guess(m)==1) l = m+1;
			else if(guess(m)==-1) h = m-1;
		}
		return l;
    }
}
