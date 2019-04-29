/*
 * @lc app=leetcode.cn id=453 lang=java
 *
 * [453] 最小移动次数使数组元素相等
 */
class Solution {
    public int minMoves(int[] nums) {
        int min = nums[0];
        long sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (min > nums[i]) {
                min = nums[i];
            }
            sum += nums[i];
        }
        return (int)(sum - min * nums.length);
    }
}

