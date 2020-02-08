/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 *
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 *
 * algorithms
 * Medium (36.82%)
 * Likes:    306
 * Dislikes: 0
 * Total Accepted:    59.4K
 * Total Submissions: 153.1K
 * Testcase Example:  '[5,7,7,8,8,10]\n8'
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * 
 * 示例 1:
 * 
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 
 * 示例 2:
 * 
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 * 
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length < 1) {
            return new int[]{-1, -1};
        }
        if(nums.length == 1) {
            return nums[0] == target ? new int[]{0, 0} : new int[]{-1,-1};
        }
        int b = 0;
        int e = nums.length -1;
        while (b <= e) {
            int m = (b + e) / 2;
            if(target > nums[m]) {
                b = m + 1;
            } else {
                e = m - 1;
            }
        }
        if(b < nums.length && nums[b] != target) {
            return new int[]{-1, -1};
        }
        int i = b;
        for (; i < nums.length; i++) {
            if(nums[i] != target) {
                return new int[]{b, i - 1};
            }
        }
        if(b < nums.length && nums[b] == target) {
            return new int[]{b, nums.length - 1};
        }
        return new int[]{-1, -1};
    }


}
// @lc code=end

