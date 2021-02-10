/*
 * @lc app=leetcode.cn id=977 lang=java
 *
 * [977] 有序数组的平方
 *
 * https://leetcode-cn.com/problems/squares-of-a-sorted-array/description/
 *
 * algorithms
 * Easy (73.34%)
 * Likes:    199
 * Dislikes: 0
 * Total Accepted:    95.6K
 * Total Submissions: 130.3K
 * Testcase Example:  '[-4,-1,0,3,10]'
 *
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * 
 * 
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 10^4
 * -10^4 
 * nums 已按 非递减顺序 排序
 * 
 * 
 * 
 * 
 * 进阶：
 * 
 * 
 * 请你设计时间复杂度为 O(n) 的算法解决本问题
 * 
 * 
 */
import java.util.*;


// @lc code=start
class Solution {

    public int[] sortedSquares(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int[] r = new int[nums.length];
        int index = nums.length - 1;
        while (index >= 0 &&i <= j) {
            int ii = nums[i] * nums[i];
            int jj = nums[j] * nums[j];
            if (ii >= jj) {
                r[index--] = ii;
                i++;
            } else {
                r[index--] = jj;
                j--;
            }
        }
        return r;

    }


    // public int[] sortedSquares(int[] nums) {
    //     for (int i = 0; i < nums.length; i++) {
    //         nums[i] = nums[i] * nums[i];
    //     }
    //     Arrays.sort(nums);
    //     return nums;
    // }
}
// @lc code=end

