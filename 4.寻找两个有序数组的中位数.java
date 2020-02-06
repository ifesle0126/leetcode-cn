/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个有序数组的中位数
 *
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/description/
 *
 * algorithms
 * Hard (35.25%)
 * Likes:    2121
 * Dislikes: 0
 * Total Accepted:    138.5K
 * Total Submissions: 377.5K
 * Testcase Example:  '[1,3]\n[2]'
 *
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * 
 * 示例 1:
 * 
 * nums1 = [1, 3]
 * nums2 = [2]
 * 
 * 则中位数是 2.0
 * 
 * 
 * 示例 2:
 * 
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 
 * 则中位数是 (2 + 3)/2 = 2.5
 * 
 * 
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length == 1 && nums2.length == 1) {
            return (double)((nums1[0] + nums2[0]) / 2.0);
        }
        int total_len = nums1.length + nums2.length;
        int half_len = total_len / 2;
        int i1 = 0;
        int i2 = 0;
        double nums = 0;
        double prenums = 0;
        while(i1 + i2 <= half_len) {
            prenums = nums;
            if (i1 == nums1.length) {
                nums = nums2[i2];
                i2++;
            } else if (i2 == nums2.length) {
                nums = nums1[i1];
                i1++;
            } else if(nums1[i1] < nums2[i2]) {
                nums = nums1[i1];
                i1++;
            } else {
                nums = nums2[i2];
                i2++;
            }
        }
        System.out.println(i1 + " " + i2 + " " + prenums + " " + nums);
        if(total_len % 2 == 1) {
            return nums;
        } else {
            return (prenums + nums) / 2;
        }
    }
}
// @lc code=end

