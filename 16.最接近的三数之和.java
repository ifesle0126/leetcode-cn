import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 *
 * https://leetcode-cn.com/problems/3sum-closest/description/
 *
 * algorithms
 * Medium (41.05%)
 * Likes:    355
 * Dislikes: 0
 * Total Accepted:    70.7K
 * Total Submissions: 165.3K
 * Testcase Example:  '[-1,2,1,-4]\n1'
 *
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target
 * 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * 
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * 
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 * 
 * 
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = 0;
        int gap = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length - 2; i++) {
            int n1 = nums[i];
            int b = i + 1;
            int e = nums.length - 1;
            while (b < e) {
                int s = n1 + nums[b] + nums[e];
                int gap_tmp = Math.abs(s - target);
                if(gap_tmp < gap) {
                    gap = gap_tmp;
                    sum = s;
                }
                if(s > target) {
                    e--;
                } else {
                    b++;
                }
            }
        }
        
        return sum;
    }
}
// @lc code=end

