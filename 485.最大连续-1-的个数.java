/*
 * @lc app=leetcode.cn id=485 lang=java
 *
 * [485] 最大连续1的个数
 */
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        if (nums == null) {
            return max;
        }
        int count = 0;
        for(int num : nums) {
            if(num == 1) {
                count++;
            } else {
                if ( count > max) {
                    max = count;
                }
                count = 0;
            }
        }
        return max > count ? max : count;
    }
}

