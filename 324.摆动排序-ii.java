/*
 * @lc app=leetcode.cn id=324 lang=java
 *
 * [324] 摆动排序 II
 *
 * https://leetcode-cn.com/problems/wiggle-sort-ii/description/
 *
 * algorithms
 * Medium (35.12%)
 * Likes:    128
 * Dislikes: 0
 * Total Accepted:    10.3K
 * Total Submissions: 29.4K
 * Testcase Example:  '[1,5,1,1,6,4]'
 *
 * 给定一个无序的数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 * 
 * 示例 1:
 * 
 * 输入: nums = [1, 5, 1, 1, 6, 4]
 * 输出: 一个可能的答案是 [1, 4, 1, 5, 1, 6]
 * 
 * 示例 2:
 * 
 * 输入: nums = [1, 3, 2, 2, 3, 1]
 * 输出: 一个可能的答案是 [2, 3, 1, 3, 1, 2]
 * 
 * 说明:
 * 你可以假设所有输入都会得到有效的结果。
 * 
 * 进阶:
 * 你能用 O(n) 时间复杂度和 / 或原地 O(1) 额外空间来实现吗？
 * 
 */

// @lc code=start
class Solution {

    public void wiggleSort(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int p = bsSelect(nums, (nums.length - 1) / 2 + 1);
        // Reverse Dutch National Flag with Wiggle Indexing (StefanPochmann's Virtual Indexing).
        // Thanks to apolloydy for reversing this thing.
        final int n = nums.length;
        int m = 0, r = nums.length - 1;
        int lw = 1, mw = 1, rw = (1 + 2 * (nums.length - 1)) % (n | 1);
        while (m <= r) {
            if (nums[mw] > p) {
                int tmp = nums[mw];
                nums[mw] = nums[lw];
                nums[lw] = tmp;
                mw = (mw + 2) % (n | 1);
                ++m;
                lw = (lw + 2) % (n | 1);
            } else if (nums[mw] < p) {
                int tmp = nums[mw];
                nums[mw] = nums[rw];
                nums[rw] = tmp;
                rw = (rw - 2 + (n | 1)) % (n | 1);
                --r;
            } else {
                mw = (mw + 2) % (n | 1);
                ++m;
            }
        }
    }
    
    private int bsSelect(int[] nums, int k) {
        if (k < 1 || k > nums.length) {
            throw new IllegalArgumentException("length=" + nums.length + " k=" + k);
        }
        int left = Integer.MIN_VALUE, right = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = (left < 0 && right > 0) ? (left + right) / 2 : left + (right - left) / 2;
            int cl = 0, cg = 0, d = 0;
            for (int n : nums) {
                if (n < mid) {
                    if (++cl > k - 1) {
                        d = +1; // mid larger than kth
                        break;
                    }
                } else if (n > mid) {
                    if (++cg > (nums.length - k)) {
                        d = -1; // mid smaller than kth
                        break;
                    }
                }
            }
            if (d == 0) {
                return mid;
            } else if (d < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        throw new AssertionError();
    }
    
}
// @lc code=end

