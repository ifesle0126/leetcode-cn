/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 *
 * https://leetcode-cn.com/problems/search-a-2d-matrix/description/
 *
 * algorithms
 * Medium (37.63%)
 * Likes:    144
 * Dislikes: 0
 * Total Accepted:    35.7K
 * Total Submissions: 94.9K
 * Testcase Example:  '[[1,3,5,7],[10,11,16,20],[23,30,34,50]]\n3'
 *
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 
 * 
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 
 * 
 * 示例 1:
 * 
 * 输入:
 * matrix = [
 * ⁠ [1,   3,  5,  7],
 * ⁠ [10, 11, 16, 20],
 * ⁠ [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * matrix = [
 * ⁠ [1,   3,  5,  7],
 * ⁠ [10, 11, 16, 20],
 * ⁠ [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 * 
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1) {
            return false;
        }
        if(matrix.length == 1 && (matrix[0] == null || matrix[0].length < 1)) {
            return false;
        }
        int b = 0;
        int e = matrix.length -1;
        while (b <= e) {
            int m = (b + e) / 2;
            int n = matrix[m][0];
            if (n == target) {
                return true;
            } else if (n < target) {
                b = m + 1;
            } else if (n > target) {
                e = m - 1;
            }
        }
        int bb = e < 0 ? 0 : e;
        int bbb = 0;
        e = matrix[bb].length - 1;
        while (bbb <= e) {
            int m = (bbb + e) / 2;
            int n = matrix[bb][m];
            if (n == target) {
                return true;
            } else if (n > target) {
                e = m - 1;
            } else if (n < target) {
                bbb = m + 1;
            }
        }
        return false;
    }
}
// @lc code=end

