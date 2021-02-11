/*
 * @lc app=leetcode.cn id=713 lang=java
 *
 * [713] 乘积小于K的子数组
 *
 * https://leetcode-cn.com/problems/subarray-product-less-than-k/description/
 *
 * algorithms
 * Medium (37.49%)
 * Likes:    222
 * Dislikes: 0
 * Total Accepted:    12K
 * Total Submissions: 32K
 * Testcase Example:  '[10,5,2,6]\n100'
 *
 * 给定一个正整数数组 nums。
 * 
 * 找出该数组内乘积小于 k 的连续的子数组的个数。
 * 
 * 示例 1:
 * 
 * 
 * 输入: nums = [10,5,2,6], k = 100
 * 输出: 8
 * 解释: 8个乘积小于100的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
 * 
 * 
 * 说明:
 * 
 * 
 * 0 < nums.length <= 50000
 * 0 < nums[i] < 1000
 * 0 <= k < 10^6
 * 
 * 
 */

// @lc code=start
import java.util.*;

class Solution {

    public int numSubarrayProductLessThanK_(int[] nums, int k) {
        if (k <= 1) return 0;
        int prod = 1, ans = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k) prod /= nums[left++];
            ans += right - left + 1;
        }
        return ans;
    }

    // wrong answer
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int i = 0;
        int r = 0;
        while (i < nums.length) {
            if (nums[i] < k) {
                r++;
            } else {
                break;
            }
            int s = nums[i];
            int j = i + 1;
            while (j < nums.length && s * nums[j] < k) {
                s = s * nums[j++];
                r++;
            }
            i++;
        }
        return r;      
    }
}


// @lc code=end

