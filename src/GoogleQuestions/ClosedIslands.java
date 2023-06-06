package GoogleQuestions;

import java.util.Objects;

public class ClosedIslands {
    public int closedIslands(int[][] grid) {
        if(grid.length == 0|| Objects.isNull(grid)) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        boolean[][] visited = new boolean[rows][cols];

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == 0 && !visited[i][j]) {
                    if(dfs(grid, i, j, rows, cols, visited)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public boolean dfs(int[][] grid, int i, int j, int rows, int cols, boolean[][] visited) {
        if (i < 0 || i >= rows || j < 0 || j >= cols)
            return false;

        if (grid[i][j] == 1 || visited[i][j])
            return true;

        visited[i][j] = true;

        boolean isClosed = true;
        isClosed = isClosed & dfs(grid, i+1, j, rows, cols, visited);
        isClosed = isClosed & dfs(grid, i-1, j, rows, cols, visited);
        isClosed = isClosed & dfs(grid, i, j+1, rows, cols, visited);
        isClosed = isClosed & dfs(grid, i, j-1, rows, cols, visited);

        return isClosed;
    }
    public static void main(String[] args) {
        ClosedIslands c = new ClosedIslands();
        int[][] grid = {{'1','1','1','1','1','1','1','0'}, {'1','0','0','0','0','1','1','0'},
                {'1','0','1','0','1','1','1','0'}, {'1','0','0','0','0','1','0','1'}, {'1','1','1','1','1','1','1','0'}};
        System.out.println(c.closedIslands(grid));
    }
}
