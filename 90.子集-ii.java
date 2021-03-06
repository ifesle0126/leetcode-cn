import java.util.*;

/*
 * @lc app=leetcode.cn id=90 lang=java
 *
 * [90] 子集 II
 *
 * https://leetcode-cn.com/problems/subsets-ii/description/
 *
 * algorithms
 * Medium (59.58%)
 * Likes:    191
 * Dislikes: 0
 * Total Accepted:    28.5K
 * Total Submissions: 47.9K
 * Testcase Example:  '[1,2,2]'
 *
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 
 * 说明：解集不能包含重复的子集。
 * 
 * 示例:
 * 
 * 输入: [1,2,2]
 * 输出:
 * [
 * ⁠ [2],
 * ⁠ [1],
 * ⁠ [1,2,2],
 * ⁠ [2,2],
 * ⁠ [1,2],
 * ⁠ []
 * ]
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums); //排序
        getAns(nums, 0, new ArrayList<>(), ans);
        return ans;
    }
    
    private void getAns(int[] nums, int start, ArrayList<Integer> temp, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            //和上个数字相等就跳过
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            temp.add(nums[i]);
            getAns(nums, i + 1, temp, ans);
            temp.remove(temp.size() - 1);
        }
    }
}


class Solution2 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> r = new ArrayList<>();
        if (nums == null || nums.length < 1) {
            return r;
        }
        Arrays.sort(nums);
        backtracking(nums, 0, r, new ArrayDeque());
        return r;
    }

    private void backtracking(int[] nums, int i, List<List<Integer>> r, Deque<Integer> l) {
        r.add(new ArrayList<>(l));
        for (int ii = i; ii < nums.length; ii++) {
            if (ii > i && nums[ii] == nums[ii - 1]) {
                continue;
            }
            l.add(nums[ii]);
            backtracking(nums, ii + 1, r, l);
            l.removeLast();
        }
    }

}

// @lc code=end

