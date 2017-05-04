import java.util.ArrayList;
import java.util.List;

/*Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?*/
public class Q119_Pascals_Triangle_II {
	public List<Integer> getRow(int rowIndex) {
		List<Integer> ret = new ArrayList<Integer>();
        //第一个数是1，第二个数是列数
        ret.add(1);
        for(int i=1; i<=rowIndex; i++){
        	for(int j=i-1; j>=1; j--) {
        	    int temp = ret.get(j-1)+ret.get(j);
        		ret.set(j, temp);
        	}
        	ret.add(1);
        }
        return ret;
    }
}
