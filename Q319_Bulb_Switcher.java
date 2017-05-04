
public class Q319_Bulb_Switcher {
	public int bulbSwitch(int n) {
        int count = 0;       
        for(int i=1; i<=n; i++) {
        	count += n%i;
        }      
        return count;
    }
	/******************************************************************/
	public int bulbSwitch_0(int n) {
		return (int) Math.sqrt(n);
	}
	/*int bulbSwitch(int n) {
	    return sqrt(n);
	}
	A bulb ends up on iff it is switched an odd number of times.
	
	Call them bulb 1 to bulb n. Bulb i is switched in round d if and only if d divides i. So bulb i ends up on 
	if and only if it has an odd number of divisors.
	
	Divisors come in pairs, like i=12 has divisors 1 and 12, 2 and 6, and 3 and 4. Except when i is a square, 
	like 36 has divisors 1 and 36, 2 and 18, 3 and 12, 4 and 9, and double divisor 6. So bulb i ends up on if 
	and only if i is a square.
	
	So just count the square numbers.
	
	Let R = int(sqrt(n)). That's the root of the largest square in the range [1,n]. And 1 is the smallest root. 
	So you have the roots from 1 to R, that's R roots. Which correspond to the R squares. So int(sqrt(n)) is the 
	answer. (C++ does the conversion to int automatically, because of the specified return type).*/
	/*As we know that there are n bulbs, let's name them as 1, 2, 3, 4, ..., n.

You first turn on all the bulbs.
Then, you turn off every second bulb.(2, 4, 6, ...)
On the third round, you toggle every third bulb.(3, 6, 9, ...)
For the ith round, you toggle every i bulb.(i, 2i, 3i, ...)
For the nth round, you only toggle the last bulb.(n)
If n > 6, you can find that bulb 6 is toggled in round 2 and 3.

Later, it will also be toggled in round 6, and round 6 will be the last round when bulb 6 is toggled.

Here, 2,3 and 6 are all factors of 6 (except 1).

Prove:

We can come to the conclusion that the bulb i is toggled k times.

Here, k is the number of i's factors (except 1).

k + 1 will be the total number of i's factors

For example:

Factors of 6: 1, 2, 3, 6 (3 factors except 1, so it will be toggled 3 times)
Factors of 7: 1, 7 (1 factors except 1, so it will be toggled once)
....
Now, the key problem here is to judge whether k is even or odd.

Since all bulbs are on at the beginning, we can get:

If k is odd, the bulb will be off in the end.(after odd times of toggling).
If k is even, the bulb i will be on in the end (after even times of toggling).
As we all know, a natural number can divided by 1 and itself, and all factors appear in pairs.

When we know that p is i's factor, we are sure q = i/p is also i's factor.

If i has no factor p that makes p = i/p, k+ 1 is even.

If i has a factor p that makes p = i/p (i = p^2, i is a perfect square of p), k+ 1 is odd.

So we get that in the end:

If i is a perfect square , k+ 1 is odd, k is even (bulb i is on).
If i is NOT a perfect square , k+ 1 is even, k is odd (bulb i is off).
We want to find how many bulbs are on after n rounds (In the end).

That means we need to find out how many perfect square numbers are NO MORE than n.

The number of perfect square numbers which are no more than n, is the square root of the maximum perfect square number which is NO MORE than n

Result:

The square root of the maximum perfect square number which is NO MORE than n is the
integer part of sqrt(n).

(If i = 1, it will NEVER be toggled, k is 0 (even) here which meets the requirement.)*/
}
