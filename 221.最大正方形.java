/*
 * @lc app=leetcode.cn id=221 lang=java
 *
 * [221] 最大正方形
 *
 * https://leetcode-cn.com/problems/maximal-square/description/
 *
 * algorithms
 * Medium (38.99%)
 * Likes:    236
 * Dislikes: 0
 * Total Accepted:    22.6K
 * Total Submissions: 57.9K
 * Testcase Example:  '[["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]'
 *
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 * 
 * 示例:
 * 
 * 输入: 
 * 
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * 
 * 输出: 4
 * 
 */

// @lc code=start
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
        return 0;
          
      int max = 0, n = matrix.length, m = matrix[0].length;
      
      // dp(i, j) represents the length of the square 
      // whose lower-right corner is located at (i, j)
      // dp(i, j) = min{ dp(i-1, j-1), dp(i-1, j), dp(i, j-1) }
      int[][] dp = new int[n + 1][m + 1];
      
      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
          if (matrix[i - 1][j - 1] == '1') {
            dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
            max = Math.max(max, dp[i][j]);
          }
        }
      }
      
      // return the area
      return max * max;
    }
}
// @lc code=end

