/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 *
 * https://leetcode-cn.com/problems/maximum-subarray/description/
 *
 * algorithms
 * Easy (49.67%)
 * Likes:    1706
 * Dislikes: 0
 * Total Accepted:    177.7K
 * Total Submissions: 357.7K
 * Testcase Example:  '[-2,1,-3,4,-1,2,1,-5,4]'
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 
 * 示例:
 * 
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 
 * 
 * 进阶:
 * 
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * 
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int max_tmp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(max_tmp < 0) {
                max_tmp = nums[i];
            } else {
                max_tmp = max_tmp + nums[i];
            }
            if(max_tmp >= max) {
                max = max_tmp;
            }

        }
        return max;
    }
}
// @lc code=end

