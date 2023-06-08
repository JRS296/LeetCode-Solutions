//Attempt #1 - 20mins
//Link: https://leetcode.com/problems/word-search/description/

class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean result = false;
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(dfs(board,word,i,j,0))
                {
                    result = true;
                }
            }
        }
        return result;
    }
    public boolean dfs(char[][] board, String word, int i, int j, int k)
    {
        int m = board.length;
        int n = board[0].length;
        if(i<0 || j<0 || i>=m || j>=n)
        {
            return false;
        }
        if(board[i][j] == word.charAt(k))
        {
            char temp = board[i][j];
            board[i][j]='#';
            if(k==word.length()-1)
            {
                return true;
            }
            else if(dfs(board, word, i-1, j, k+1) ||dfs(board, word, i+1, j, k+1) ||dfs(board, word, i, j-1, k+1) ||dfs(board, word, i, j+1, k+1))
            {
                return true;
            }
            board[i][j]=temp;
        }
        return false;
    }
}

/*
Runtime
180 ms
Beats
82.54%
Memory
40.7 MB
Beats
62.15%

TC - O(n^3)
SC
 */

//This did not work for some reason
class Solution {
    boolean flag = false;
    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j] == word.charAt(0)) {
                    StringBuilder temp = new StringBuilder();
                    helper(word, 0, temp, i, j, board);
                }
                else continue;
            }
        }

        return flag;
    }

    public void helper(String word, int curr, StringBuilder temp, int i, int j, char[][] board) {
        //System.out.println(curr + " " + word);
        if(i<0 || i>board.length || j<0 || j>board[0].length || curr>=word.length()-1) {
            return;
        }
        if(temp.toString()==word && curr==word.length()-1) {
            flag = true;
            return;
        }
        System.out.println(word.charAt(curr) + " " + curr);
        if(board[i][j] == word.charAt(curr)) {
            char x = board[i][j];
            board[i][j]='#';

            temp.append(word.charAt(curr));
            helper(word, curr+1, temp, i+1, j, board);
            helper(word, curr+1, temp, i-1, j, board);
            helper(word, curr+1, temp, i, j+1, board);
            helper(word, curr+1, temp, i, j-1, board);

            board[i][j]=x;
        }
    }
}