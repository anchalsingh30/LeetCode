package GoogleQuestions;

public class NumberOfIslands {
    public int numIslands(int[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++) { //grid.length=4
            for(int j = 0; j < grid[0].length; j++) { //grid[0].length=5
                if(grid[i][j] == '1') {
                    count++; //1
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
    public void dfs(int[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i+1, j); //i=1,2,3
        dfs(grid, i-1, j); //i=2,
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
    }
    public static void main(String[] args) {
        NumberOfIslands n = new NumberOfIslands();
        int[][] grid = {{'1','1','1','1','0'}, {'1','1','0','1','0'}, {'1','1','0','0','0'}, {'0','0','0','0','0'}};
        System.out.println(n.numIslands(grid));
    }
}
