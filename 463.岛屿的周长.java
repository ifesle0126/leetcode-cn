/*
 * @lc app=leetcode.cn id=463 lang=java
 *
 * [463] 岛屿的周长
 */
class Solution {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int area = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    area += 4;
                    if(i - 1 >= 0 && grid[i-1][j] == 1) {
                        area -= 2;
                    }
                    if(j - 1 >= 0 && grid[i][j-1] == 1) {
                        area -= 2;
                    }
                }
            }
        }
        return area;
    }
}

