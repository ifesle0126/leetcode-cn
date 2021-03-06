/*
 * @lc app=leetcode.cn id=209 lang=java
 *
 * [209] 长度最小的子数组
 *
 * https://leetcode-cn.com/problems/minimum-size-subarray-sum/description/
 *
 * algorithms
 * Medium (41.86%)
 * Likes:    229
 * Dislikes: 0
 * Total Accepted:    34.7K
 * Total Submissions: 83K
 * Testcase Example:  '7\n[2,3,1,2,4,3]'
 *
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
 * 
 * 示例: 
 * 
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * 
 * 
 * 进阶:
 * 
 * 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 * 
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (s <= 0 || nums == null || nums.length < 1) {
            return 0;
        }
        int b = 0;
        int e = b + 1;
        int min = nums.length;
        int sum = nums[b];
        boolean f = true;
        while (b <= e && e <= nums.length) {
            if (sum >= s) {
                min = Math.min(min, e - b);
                sum = sum - nums[b];
                b++;
                f = false;
            } else {
                sum = e < nums.length? sum + nums[e] : sum;
                e++;
            }
        }
        if(f) {
            return 0;
        }
        return min;
    }
}


class Solution3 {
    public int minSubArrayLen(int s, int[] nums) {
        if (s <= 0 || nums == null || nums.length < 1) {
            return 0;
        }

        int i = 0;

        int min_count = Integer.MAX_VALUE;
        while (i < nums.length) {
            int j = i;
            int count = 0;
            int sum = 0;
            while (j < nums.length) {
                sum = sum + nums[j];
                count++;
                if (sum >= s) {
                    if (count < min_count) {
                        min_count = count;
                    }
                    break;
                }
                j++;
            }
            i++;
        }
        if (min_count == Integer.MAX_VALUE) {
            min_count = 0;
        }
        return min_count;
    }
}

// 不连续的
class Solution2 {
    public int minSubArrayLen(int s, int[] nums) {
        if (s <= 0 || nums == null || nums.length < 1) {
            return 0;
        }

        return recursive(nums, 0, 0, s);
    }

    private int recursive(int[] nums, int i, int count, int s) {
        if (i > nums.length - 1) {
            return nums.length;
        }
        if (s - nums[i] <= 0) {
            return count + 1;
        }        
        return Math.min(recursive(nums, i + 1, count + 1, s - nums[i]), 
            recursive(nums, i + 1, count, s));
    }
}
// @lc code=end

