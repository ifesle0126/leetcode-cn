import java.util.*;

/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 *
 * https://leetcode-cn.com/problems/permutations-ii/description/
 *
 * algorithms
 * Medium (57.89%)
 * Likes:    256
 * Dislikes: 0
 * Total Accepted:    48.9K
 * Total Submissions: 84.5K
 * Testcase Example:  '[1,1,2]'
 *
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * 
 * 示例:
 * 
 * 输入: [1,1,2]
 * 输出:
 * [
 * ⁠ [1,1,2],
 * ⁠ [1,2,1],
 * ⁠ [2,1,1]
 * ]
 * 
 */

// @lc code=start
class Solution {

    private boolean[] visited = null;

    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> r = new ArrayList<>();

        if (nums == null || nums.length < 1) {
            return r;
        }

        visited = new boolean[nums.length];

        Arrays.sort(nums);

        backtracking(nums, r, new ArrayDeque<>(), 0);

        return r;

    }

    private void backtracking(int[] nums, List<List<Integer>> r, Deque<Integer> l, int d) {
        if (d == nums.length) {
            r.add(new ArrayList<>(l));
            return ;
        }
        for (int i = 0; i < nums.length; i++) {
            if(visited[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1]) {
                continue;
            }
            
            l.add(nums[i]);
            visited[i] = true;
            backtracking(nums, r, l, d + 1);
            l.removeLast();
            visited[i] = false;

        }
    }
}
// @lc code=end

