
public class Q495_Teemo_Attacking {
	public int findPoisonedDuration(int[] timeSeries, int duration) {
		if(timeSeries==null||timeSeries.length==0||duration==0) return 0;
        int cnt = 0;
        
        for(int i=0; i<timeSeries.length-1; i++) {
        	if(timeSeries[i+1]-timeSeries[i]>duration) cnt += duration;
        	else cnt += timeSeries[i+1] - timeSeries[i];
        }
        cnt += duration;
        return cnt;
    }
}
