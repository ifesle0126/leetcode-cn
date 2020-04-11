/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 *
 * https://leetcode-cn.com/problems/subsets/description/
 *
 * algorithms
 * Medium (77.13%)
 * Likes:    529
 * Dislikes: 0
 * Total Accepted:    77.7K
 * Total Submissions: 100.7K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 
 * 说明：解集不能包含重复的子集。
 * 
 * 示例:
 * 
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * ⁠ [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * 
 */

// @lc code=start
import java.util.*;


class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> r = new ArrayList<>();
        if (nums == null || nums.length < 1) {
            return r;
        }
        backtracking(nums, 0, r, new ArrayDeque<>());
        return r;
    }

    private void backtracking(int[] nums, int i, List<List<Integer>> r, Deque<Integer> l) {
        
        r.add(new ArrayList<>(l));
        for (int ii = i; ii < nums.length; ii++) {
            l.add(nums[ii]);
            backtracking(nums, ii + 1, r, l);
            l.removeLast();
        }
    }
}
// @lc code=end

