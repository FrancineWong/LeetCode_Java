/*You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest
 *  version of your product fails the quality check. Since each version is developed based on the previous 
 *  version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the 
following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function 
to find the first bad version. You should minimize the number of calls to the API.*/

public class Q278_First_Bad_Version {
	/* The isBadVersion API is defined in the parent class VersionControl.
    boolean isBadVersion(int version); */
	public int firstBadVersion(int n) {
		if(n<1) return 0;
        return binarySearch(1, n);
    }
	
	public int binarySearch(int low, int high) {
		if(low==high) return high;
		int m = (low+high)/2;
		if(isBadVersion(m)&&(!isBadVersion(m-1))) return m;
		else if(isBadVersion(m)) {
			high = m;
		}else if(!isBadVersion(m)){
			low = m+1;
		}
		return binarySearch(low, high);
	}

	private boolean isBadVersion(int m) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/******************************************************/
	public int firstBadVersion_0(int n) {
        int start = 1, end = n;
        while (start < end) {
            int mid = start + (end-start) / 2;
            if (!isBadVersion(mid)) start = mid + 1;
            else end = mid;            
        }        
        return start;
    }
}
