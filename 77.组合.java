import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 *
 * https://leetcode-cn.com/problems/combinations/description/
 *
 * algorithms
 * Medium (73.40%)
 * Likes:    238
 * Dislikes: 0
 * Total Accepted:    42.9K
 * Total Submissions: 58.4K
 * Testcase Example:  '4\n2'
 *
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 
 * 示例:
 * 
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * ⁠ [2,4],
 * ⁠ [3,4],
 * ⁠ [2,3],
 * ⁠ [1,2],
 * ⁠ [1,3],
 * ⁠ [1,4],
 * ]
 * 
 */

// @lc code=start
import java.util.*;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> r = new ArrayList<>();
        if (n < 1 || k < 1) {
            return r;
        }
        int[] nums = new int[n];
        for (int i = 1; i <= n; i++) {
            nums[i -1] = i;
        }
        backtracking(nums, r, new ArrayDeque<>(), 0, k);
        return r;
    }

    private void backtracking(int[] nums, List<List<Integer>> r, Deque<Integer> l, int i, int k) {
        if (l.size() == k) {
            r.add(new ArrayList<>(l));
            return;
        }
        for (int ii = i; ii < nums.length; ii++) {
            if(l.size() > k) {
                return;
            }
            l.add(nums[ii]);
            backtracking(nums, r, l, ii + 1, k);
            l.removeLast();
        }

    }
}
// @lc code=end

