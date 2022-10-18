//Attempt #1 - 20mins
//Link: https://leetcode.com/explore/learn/card/hash-table/185/hash_table_design_the_key/1126/

class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Check Rows
        for (int i = 0; i < board.length; i++) {
            HashMap<Character, Integer> hm1 = new HashMap<Character, Integer>();
            for (int j = 0; j < board[0].length; j++) {
                // int x = board[i][j] - '0';
                char x = board[i][j];
                if (x == '.') {
                    continue;
                } else if (hm1.containsKey(x)) {
                    return false;
                }
                hm1.put(x, j);
            }
        }
        // Check Columns
        for (int j = 0; j < board[0].length; j++) {
            HashMap<Character, Integer> hm1 = new HashMap<Character, Integer>();
            for (int i = 0; i < board.length; i++) {
                // int x = board[i][j] - '0';
                char x = board[i][j];
                if (x == '.') {
                    continue;
                } else if (hm1.containsKey(x)) {
                    return false;
                }
                hm1.put(x, j);
            }
        }
        // Check 9 3x3 boxes

        return true;
    }
}

/*
 * 473 / 507 test cases passed.
 * Time Complexity: O(n^2)
 */

// Attempt #2 - 1hour
class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Check Rows
        for (int i = 0; i < board.length; i++) {
            HashMap<Character, Integer> hm1 = new HashMap<Character, Integer>();
            for (int j = 0; j < board[0].length; j++) {
                // int x = board[i][j] - '0';
                char x = board[i][j];
                if (x == '.') {
                    continue;
                } else if (hm1.containsKey(x)) {
                    return false;
                }
                hm1.put(x, j);
            }
        }
        // Check Columns
        for (int j = 0; j < board[0].length; j++) {
            HashMap<Character, Integer> hm1 = new HashMap<Character, Integer>();
            for (int i = 0; i < board.length; i++) {
                // int x = board[i][j] - '0';
                char x = board[i][j];
                if (x == '.') {
                    continue;
                } else if (hm1.containsKey(x)) {
                    return false;
                }
                hm1.put(x, j);
            }
        }
        // Check 9 3x3 boxes
        for (int i = 0; i < 9; i++) {
            ArrayList<String> q = new ArrayList<String>(
                    Arrays.asList("0022", "0325", "0628", "3052", "3355", "3658", "6082", "6385", "6688"));
            int x1 = q.get(i).charAt(0) - '0';
            int y1 = q.get(i).charAt(1) - '0';
            int x2 = q.get(i).charAt(2) - '0';
            int y2 = q.get(i).charAt(3) - '0';
            // System.out.println(x1 + " " + y1 + " * " + x2 + " " + y2);
            ArrayList<Character> q2 = new ArrayList<Character>();
            for (int j = x1; j <= x2; j++) {
                for (int k = y1; k <= y2; k++) {
                    char x = board[j][k];
                    if (x != '.') {
                        // System.out.print(board[j][k]+" ");
                        if (q2.contains(x)) {
                            return false;
                        }
                        q2.add(x);
                    }
                }
            }
            // System.out.println(q2);
            // System.out.println("***");
        }
        return true;
    }

}

/*
* public static void print2DMatrix(
* int arr[][], int rows, int columns) {
* // Iterate over the range [0, rows*columns]
* for (int i = 0; i < rows * columns; i++) {
* // Find row and column index
* int row = i / columns;
* int col = i % columns;
* System.out.print(arr[row][col] + " ");
* }
* }
*/

/*
* 507 / 507 test cases passed.
* Status: Accepted
* Runtime: 9 ms - beats 45%
* Memory Usage: 47.9 MB - beats 35%
* 
* Time Complexity: O(n^3) - pretty bad, but good compared to rest
* Space COmplexity: Some big number
*/
// Optimal Solution:
//Makes use of HashSet to Check for not possible to add condition
public boolean isValidSudoku(char[][] board) {
    for(int i = 0; i<9; i++){
        HashSet<Character> rows = new HashSet<Character>();
        HashSet<Character> columns = new HashSet<Character>();
        HashSet<Character> cube = new HashSet<Character>();
        for (int j = 0; j < 9;j++){
            if(board[i][j]!='.' && !rows.add(board[i][j]))
                return false;
            if(board[j][i]!='.' && !columns.add(board[j][i]))
                return false;
            int RowIndex = 3*(i/3);
            int ColIndex = 3*(i%3);
            if(board[RowIndex + j/3][ColIndex + j%3]!='.' && !cube.add(board[RowIndex + j/3][ColIndex + j%3]))
                return false;
        }
    }
    return true;
}

/*
507 / 507 test cases passed.
Status: Accepted
Runtime: 2 ms - beats 97%
Memory Usage: 42.1 MB - beats 95%

Time Complexity: O(n^2) - Very Good
Space Complexity:  - Very Good 
 */