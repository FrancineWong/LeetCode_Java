
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Q436_Find_Right_Interval {
	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	public int[] findRightInterval(Interval[] intervals) {
		TreeMap<Integer, Integer> tmp = new TreeMap<>();
        for (int i=0; i<intervals.length; i++) {
            tmp.put(intervals[i].start, i);
        }

        int[] ret = new int[intervals.length];
        for (int i=0; i<intervals.length; i++) {
            Map.Entry<Integer, Integer> item =  tmp.ceilingEntry(intervals[i].end);
            if (item != null) {
                ret[i] = item.getValue();
            }
            else {
                ret[i] = -1;
            }
        }
        return ret;
     }
	
	public int[] findRightInterval_0(Interval[] intervals) {
		int[] res = new int[intervals.length];
		int[] v = new int[intervals.length];
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<intervals.length; i++) {
			map.put(intervals[i].start, i);
			v[i] = intervals[i].start;
		}
		Arrays.sort(v);
		int index = 0;
		for(Interval a:intervals) {
			for(int i=0; i<v.length; i++) {
				if(v[i]<a.end) break;
				res[index++] = i>0?map.get(v[i-1]):-1;
			}
		}
		return res;
	}
}
