import java.util.Arrays;
import java.util.Comparator;

public class Q435_Non_overlapping_Intervals {
	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	public int eraseOverlapIntervals(Interval[] intervals) {
		if(intervals.length==0) return 0;
		Arrays.sort(intervals, new Comparator<Interval>(){
			public int compare(Interval v1, Interval v2) {
				return v1.end - v2.end;
			}
		});
		int end = intervals[0].end;
		int count = 1;
		for(int i=0; i<intervals.length; i++) {
			if(intervals[i].start>=end) {
				end = intervals[i].end;
				count++;
			}
		}
        return intervals.length-count;
    }
}
