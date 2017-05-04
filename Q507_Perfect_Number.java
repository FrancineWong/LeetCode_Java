
public class Q507_Perfect_Number {
	public boolean checkPerfectNumber(int num) {
		//TLE
		int sum = 0;
        for(int i=1; i<num; i++) {
        	if(num%i==0) sum += i;
        }
        return sum==num;
    }
	public boolean checkPerfectNumber_0(int num) {
		if(num==1) return false;
		int sum = 0;
		for(int i=2; i<=Math.sqrt(num); i++) {
			if(num%i==0) {
				sum += i;
				if(i!=num/i) sum += num/i;
			}
		}
		sum++;
		return sum==num;
	}
	public boolean checkPerfectNumber_1(int num) {
		if(num==1) return false;
		int sum = 0;
		for(int i=2; i<=Math.sqrt(num); i++) {
			if(num%i==0) sum += i+num/i;
		}
		sum++;
		return sum==num;
	}
}
