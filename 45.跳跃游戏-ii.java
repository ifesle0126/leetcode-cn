/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 *
 * https://leetcode-cn.com/problems/jump-game-ii/description/
 *
 * algorithms
 * Hard (33.09%)
 * Likes:    361
 * Dislikes: 0
 * Total Accepted:    29.6K
 * Total Submissions: 89.6K
 * Testcase Example:  '[2,3,1,1,4]'
 *
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 
 * 示例:
 * 
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 
 * 
 * 说明:
 * 
 * 假设你总是可以到达数组的最后一个位置。
 * 
 */

// @lc code=start
class Solution {


    /**
     * 贪心
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int sc = 0;
        int e = 0;
        int max = 0;
        for(int i=0; i < nums.length-1; i++) {
            max = Math.max(max, i+nums[i]);
            if( i == e ) {
                sc++;
                e = max;
            } 
        }
        return sc;
    }


    public int jump2(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return 0;
        }
        return jump2(nums, 0, 0, nums.length -1);
    }

    public int jump2(int[] nums, int start, int step, int min) {
        if(start >= nums.length) {
            return min;
        }
        if(start == nums.length - 1) {
            return step < min ? step : min;
        }
        int s = nums[start];
        for(int i = 1; i <= s; i++) {
            if(start + i >= nums.length) {
                break;
            }
            int m = jump2(nums, start + i, step + 1, min);
            if(m < min) {
                min = m;
            }
        }
        return min;
    }
}
// @lc code=end

