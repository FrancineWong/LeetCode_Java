/*Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those 
horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.*/
public class Q079_Word_Search {
	/*1. Cre­ate a solu­tion matrix of the same struc­ture as Matrix.
	2. Try each cell a start­ing point.
	3. Check cur­rent cell is not already used and char­ac­ter in it matches with the char­ac­ter in the word at index 
	(starts will 0).
	4. Check if index = length of the word, means we have found the word. return true and print the solu­tion matrix.
	5. If above cri­te­ria matches, mark that cell with a num­ber When­ever any cell matches with the cri­te­ria, put a 
	num­ber cor­re­spond­ing to it in solu­tion matrix. (start with 0 and keep incre­ment­ing it, it will show us the 
	path for the word).
	6. Now try to solve rest of the prob­lem recur­sively by mak­ing index +1. Check all 8 direc­tions ( up, down, left 
	right, diag­o­nally up-left, diag­o­nally up-right, diag­o­nally down-left, diag­o­nally down-right). Check the 
	bound­ary con­di­tions as well
	7. If none of the 8 recur­sive calls return true, BACKTRACK and undo the changes ( put 0 to cor­re­spond­ing cell 
	in solu­tion matrix) and return false.
	8. Choose dif­fer­ent start­ing point.
	9. If all the start­ing points tried and solu­tion not found, return false
	*/
	/**********************************Wrong answer cannot figure out why************************************/
	int path = 1;
	public boolean exist(char[][] board, String word) {
		int rowLen = board.length;
		int columnLen = board[0].length;
		int[][] mark = new int[rowLen][columnLen];
		for(int i=0; i<rowLen; i++) {
			for(int j=0; j<columnLen; j++) {
				mark[i][j] = 0;
			}
		}
		for(int i=0; i<rowLen; i++) {
			for(int j=0; j<columnLen; j++) {
				if(backtrack(board, word, mark, 0, i, j)) return true;
			}
		}
		return false;
    }

	public boolean backtrack(char[][] board, String word, int[][] mark,  int index, int i, int j) {
		if (mark[i][j] != 0 || word.charAt(index) != mark[i][j]) {
			return false;
		}
		int rowLen = board.length;
		int columnLen = board[0].length;
		if(index==word.length()) return true;
		if(i<0||j<0||i==rowLen||j==columnLen) return false;
		
		mark[i][j] = path++;
		boolean exist = backtrack(board, word, mark, index+1, i+1, j)
				|| backtrack(board, word, mark,  index+1, i, j+1)
				|| backtrack(board, word, mark, index+1, i-1, j)
				||	backtrack(board, word, mark,  index+1, i, j-1);
		mark[i][j]=0;
		path--;
		return exist;
	}
	/*************************************************************************************/
	public boolean exist_0(char[][] board, String word) {
	    char[] w = word.toCharArray();
	    for (int y=0; y<board.length; y++) {
	    	for (int x=0; x<board[y].length; x++) {
	    		if (exist(board, y, x, w, 0)) return true;
	    	}
	    }
	    return false;
	}

	private boolean exist(char[][] board, int y, int x, char[] word, int i) {
		if (i == word.length) return true;
		if (y<0 || x<0 || y == board.length || x == board[y].length) return false;
		if (board[y][x] != word[i]) return false;
		board[y][x] ^= 256;
		boolean exist = exist(board, y, x+1, word, i+1)
			|| exist(board, y, x-1, word, i+1)
			|| exist(board, y+1, x, word, i+1)
			|| exist(board, y-1, x, word, i+1);
		board[y][x] ^= 256;
		return exist;
	}
}
