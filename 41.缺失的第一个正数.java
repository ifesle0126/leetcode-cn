/*
 * @lc app=leetcode.cn id=41 lang=java
 *
 * [41] 缺失的第一个正数
 */

// @lc code=start
class Solution {
    public int firstMissingPositive(int[] nums) {
        int[] tmp = new int[nums.length + 1];
        boolean has_one = false;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                has_one = true;
            }
            if(nums[i] < 1 || nums[i] > nums.length) {
                nums[i] = 1;
            }
            tmp[nums[i]]++;
        }
        if(!has_one) {
            return 1;
        }
        for(int i = 1; i < tmp.length; i++) {
            if(tmp[i] == 0) {
                return i;
            }
        }
        return tmp.length;        
    }
}
// @lc code=end

