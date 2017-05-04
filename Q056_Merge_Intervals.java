import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/*Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].*/
public class Q056_Merge_Intervals {
	public class Interval {
			int start;
			int end;
			Interval() { start = 0; end = 0; }
			Interval(int s, int e) { start = s; end = e; }
	}
	public List<Interval> merge(List<Interval> intervals) {
		int len = intervals.size();
		System.out.println(len);
        List<Interval> merg = new ArrayList<Interval>();
        int[] start = new int[len];
        int[] end = new int[len];
        
        for(int i=0; i<len; i++) {
        	start[i] = intervals.get(i).start;
        	end[i] = intervals.get(i).end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        for( int i=0; i<len-1; i++) {
        	if(end[i]<start[i+1]) {
        	    merg.add(new Interval(start[i], end[i]));
        	} else {
        		start[i+1] = start[i];
        	}
        }
        merg.add(new Interval(start[len-1], end[len-1]));
        return merg;
    }
	/*******************************************************************************/
/*The idea is to sort the intervals by their starting points. Then, we take the first interval and compare its end
 *  with the next intervals starts. As long as they overlap, we update the end to be the max end of the overlapping 
 *  intervals. Once we find a non overlapping interval, we can add the previous "extended" interval and start over.
 *  Sorting takes O(n log(n)) and merging the intervals takes O(n). So, the resulting algorithm takes O(n log(n)).
 *  I used an anonymous comparator and a for-each loop to try to keep the code clean and simple.*/
	public List<Interval> merge_0(List<Interval> intervals) {
	    if (intervals.size() <= 1)
	        return intervals;
	    
	    // Sort by ascending starting point using an anonymous Comparator
	    Collections.sort(intervals, new Comparator<Interval>() {
	        public int compare(Interval i1, Interval i2) {
	            return Integer.compare(i1.start, i2.start);
	        }
	    });
	    
	    List<Interval> result = new LinkedList<Interval>();
	    int start = intervals.get(0).start;
	    int end = intervals.get(0).end;
	    
	    for (Interval interval : intervals) {
	        if (interval.start <= end) // Overlapping intervals, move the end if needed
	            end = Math.max(end, interval.end);
	        else {                     // Disjoint intervals, add the previous one and reset bounds
	            result.add(new Interval(start, end));
	            start = interval.start;
	            end = interval.end;
	        }
	    }
	    
	    // Add the last interval
	    result.add(new Interval(start, end));
	    return result;
	}
}
