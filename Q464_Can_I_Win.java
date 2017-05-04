import java.util.HashMap;

public class Q464_Can_I_Win {
	//game play--top-down dp, brute-force
	public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
		if(desiredTotal<=0) return true;
		if(maxChoosableInteger*(maxChoosableInteger+1)/2<desiredTotal) return false;
		char[] state = new char[maxChoosableInteger];
		for(int i=0; i<maxChoosableInteger; i++) state[i] = '0';
		return dfs(desiredTotal, state, new HashMap<>());
    }
	private boolean dfs(int total, char[] state, HashMap<String, Boolean> map) {
		String key = new String(state);
		if(map.containsKey(key)) return map.get(key);
		for(int i=0; i<state.length; i++) {
			if(state[i]=='0') {
				state[i] = '1';
				if(total<=i+1||!dfs(total-(i+1), state, map)) {
					map.put(key, true);
					state[i] = '0';
					return true;
				}
				state[i] = '0';
			}
		}
		map.put(key, false);
		return false;
	}
}
