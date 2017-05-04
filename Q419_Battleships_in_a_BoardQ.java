/*Given an 2D board, count how many battleships are in it. The battleships are represented with 'X's, empty 
 * slots are represented with '.'s. You may assume the following rules:

You receive a valid board, made of only battleships or empty slots.
Battleships can only be placed horizontally or vertically. In other words, they can only be made of the shape 
1xN (1 row, N columns) or Nx1 (N rows, 1 column), where N can be of any size.
At least one horizontal or vertical cell separates between two battleships - there are no adjacent battleships.
Example:
X..X
...X
...X
In the above board there are 2 battleships.
Invalid Example:
...X
XXXX
...X
This is an invalid board that you will not receive - as battleships will always have a cell separating between 
them.
Follow up:
Could you do it in one-pass, using only O(1) extra memory and without modifying the value of the board?*/
public class Q419_Battleships_in_a_BoardQ {
	/*Going over all cells, we can count only those that are the first cell of the battleship. First cell will be defined as the most top-left cell. We can check for 
	 * first cells by only counting cells that do not have an 'X' to the left and do not have an 'X' above them*/
	public int countBattleships(char[][] board) {
		int m = board.length;
		if(m==0) return 0;
		int n = board[0].length;
		
		int count = 0;
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(board[i][j]=='.') continue;
				if(i>0&&board[i-1][j]=='X') continue;
				if(j>0&&board[i][j-1]=='X') continue;
				count++;
			}
		}
        return count;
    }
	public int count(char[][] b) {
		int len1 = b.length;
		if(len1==0) return 0;
		int len2 = b[0].length;
		int count = 0;
		int[] dx = {0,0,-1,1};
		int[] dy = {-1,1,0,0};
		for(int i=0; i<len1; i++) {
			for(int j=0; j<len2; j++) {
				if(b[i][j]=='X') {
					b[i][j]='.'; // 标记已经访问
					count++;
					int pos1 = i;
					int pos2 = j;
					for(int k=0; k<4; k++) {
						//一直沿着同一个方向搜索
						while(pos1+dx[k]>=0&&pos1+dx[k]<len1&&pos2+dy[k]>=0&&pos2+dy[k]<len2&&b[pos1+dx[k]][pos2+dy[k]]=='X') {
							b[pos1+dx[k]][pos2+dy[k]] = '.';
							pos1 += dx[k];
							pos2 += dy[k];
						}
					}
				}
			}
		}
		return count;
	}
}
