//Attempt #1 - DNA
//Link: https://leetcode.com/problems/surrounded-regions/description/

class Solution {

    int row;
    int col;
    boolean flag = false;

    public void solve(char[][] board) {
        row = board.length;
        col = board[0].length;

        for (int r = 0; r < row; r++) {
            if (board[r][0] == 'O') {
                dfs(r, 0, board);
            }
            if (board[r][col - 1] == 'O') {
                dfs(r, col - 1, board);
            }
        }
        for (int c = 0; c < col; c++) {
            if (board[0][c] == 'O') {
                dfs(0, c, board);
            }
            if (board[row - 1][c] == 'O') {
                dfs(row - 1, c, board);
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';

                if (board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }

    }

    public void dfs(int r, int c, char[][] board) {

        if (r < 0 || r >= row || c < 0 || c >= col || board[r][c] != 'O')
            return;

        board[r][c] = '#';

        dfs(r + 1, c, board);
        dfs(r - 1, c, board);
        dfs(r, c + 1, board);
        dfs(r, c - 1, board);
    }
}