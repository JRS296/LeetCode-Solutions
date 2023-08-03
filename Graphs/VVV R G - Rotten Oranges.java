//Attempt #1 - 35mins
//Link: https://leetcode.com/problems/rotting-oranges/description/

class Solution {
    int num = 0;

    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int count_fresh = 0;
        // Put the position of all rotten oranges in queue
        // count the number of fresh oranges
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[] { i, j });
                }
                if (grid[i][j] != 0) {
                    count_fresh++;
                }
            }
        }

        if (count_fresh == 0)
            return 0;
        int countMin = 0, cnt = 0;
        int dx[] = { 0, 0, 1, -1 };
        int dy[] = { 1, -1, 0, 0 };

        // bfs starting from initially rotten oranges
        while (!queue.isEmpty()) {
            int size = queue.size();
            cnt += size;
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int x = point[0] + dx[j];
                    int y = point[1] + dy[j];

                    if (x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == 0 ||
                            grid[x][y] == 2)
                        continue;

                    grid[x][y] = 2;
                    queue.offer(new int[] { x, y });
                }
            }
            if (queue.size() != 0) {
                countMin++;
            }
        }
        return count_fresh == cnt ? countMin : -1;
    }

    private void fill(int[][] image, int sr, int sc, int color, int newColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color)
            return;
        image[sr][sc] = newColor;
        fill(image, sr + 1, sc, color, newColor);
        fill(image, sr - 1, sc, color, newColor);
        fill(image, sr, sc + 1, color, newColor);
        fill(image, sr, sc - 1, color, newColor);
    }
}