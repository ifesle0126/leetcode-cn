/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 *
 * https://leetcode-cn.com/problems/permutations/description/
 *
 * algorithms
 * Medium (74.62%)
 * Likes:    588
 * Dislikes: 0
 * Total Accepted:    98.2K
 * Total Submissions: 131.6K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * 
 * 示例:
 * 
 * 输入: [1,2,3]
 * 输出:
 * [
 * ⁠ [1,2,3],
 * ⁠ [1,3,2],
 * ⁠ [2,1,3],
 * ⁠ [2,3,1],
 * ⁠ [3,1,2],
 * ⁠ [3,2,1]
 * ]
 * 
 */

// @lc code=start
import java.util.*;

class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> r = new ArrayList<>();

        if (nums == null || nums.length < 1) {
            return r;
        }

        boolean[] visited = new boolean[nums.length];

        backtracking(nums, 0, r, new ArrayDeque<>(), visited);

        return r;

    }

    private void backtracking(int[] nums, int i, List<List<Integer>> r, Deque<Integer> l, boolean[] visited) {
        if (i == nums.length) {
            r.add(new ArrayList<>(l));
            return;
        }
        for(int ii = 0; ii < nums.length; ii++) {
            if(!visited[ii]) {           
                l.add(nums[ii]);
                visited[ii] = true;
                backtracking(nums, i + 1, r, l, visited);
                l.removeLast();
                visited[ii] = false;
            }
        }
    }
}
// @lc code=end

