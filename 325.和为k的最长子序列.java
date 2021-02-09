/*
 * @lc app=leetcode.cn id=325 lang=java
 *
 * [325] 和为k的最长子序列
 *
 * Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.
 * 
 * Example 1:
 *    Given nums = [1, -1, 5, -2, 3], k = 3,
 *    return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)
 * 
 *    Example 2:
 *    Given nums = [-2, -1, 2, 1], k = 1,
 *    return 2. (because the subarray [-1, 2] sums to 1 and is the longest)
 *
 *    Follow Up:
 *    Can you do it in O(n) time?
 */
import java.util.*;

// @lc code=start
class Solution {

    public int maxSubArrayLen(int[] nums, int k) {
        int max_len = 0;
        int[] sums = new int[nums.length];
        for (int i = 0; i< nums.length; i++) {
            if (i == 0) {
                sums[i] = nums[i];
            } else {
                sums[i] = sums[i - 1] + nums[i];
            }
            
        }
        for (int i = 0; i < nums.length; i++) {
            if(sums[i] == k) {
                max_len = Math.max(max_len, i + 1);
            }
            for (int j = i; i > 0 && j < nums.length; j++) {
                if (sums[j] - sums[i - 1] == k) {
                    max_len = Math.max(max_len, j - i + 1);
                }
            }
        }

        return max_len;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        int k = 5;
        Solution solution = new Solution();
        int max = solution.maxSubArrayLen(nums, k);
        System.out.println(max);
    }
    
}
// @lc code=end

