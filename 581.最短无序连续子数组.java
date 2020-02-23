/*
 * @lc app=leetcode.cn id=581 lang=java
 *
 * [581] 最短无序连续子数组
 *
 * https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/description/
 *
 * algorithms
 * Easy (34.04%)
 * Likes:    236
 * Dislikes: 0
 * Total Accepted:    18.4K
 * Total Submissions: 54.1K
 * Testcase Example:  '[2,6,4,8,10,9,15]'
 *
 * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * 
 * 你找到的子数组应是最短的，请输出它的长度。
 * 
 * 示例 1:
 * 
 * 
 * 输入: [2, 6, 4, 8, 10, 9, 15]
 * 输出: 5
 * 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * 
 * 
 * 说明 :
 * 
 * 
 * 输入的数组长度范围在 [1, 10,000]。
 * 输入的数组可能包含重复元素 ，所以升序的意思是<=。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int findUnsortedSubarray(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int startIndex = -1;
        int endIndex   = -1;

        // find endIndex
        int maxSoFar = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < maxSoFar) {
                endIndex = i;
            }
            maxSoFar = Math.max(maxSoFar, nums[i]);
        }

        // find startIndex
        int minSoFar = nums[nums.length - 1];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > minSoFar) {
                startIndex = i;
            }
            minSoFar = Math.min(minSoFar, nums[i]);
        }

        if (startIndex == -1 || endIndex == -1) {
            return 0;
        }
        return endIndex - startIndex + 1;

    }
}
// @lc code=end

