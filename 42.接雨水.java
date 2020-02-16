/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 *
 * https://leetcode-cn.com/problems/trapping-rain-water/description/
 *
 * algorithms
 * Hard (48.49%)
 * Likes:    858
 * Dislikes: 0
 * Total Accepted:    53.1K
 * Total Submissions: 109.5K
 * Testcase Example:  '[0,1,0,2,1,0,1,3,2,1,2,1]'
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 
 * 
 * 
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢
 * Marcos 贡献此图。
 * 
 * 示例:
 * 
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * 
 */
import java.util.*;


// @lc code=start
class Solution {

    public int trap(int[] height) {
        if(height.length <= 1) {
            return 0;
        }
        int sum = 0;
        int max_left = Math.max(height[0], height[1]);
        int max_right_index = -1;
        int max_right = 0;
        for(int i = 1; i < height.length; i++) {
            if(height[i] > max_left) {
                    max_left = height[i];                
            } 
            if(max_right_index == -1 || max_right_index < i) {
                max_right = 0;
                for(int j = i; j < height.length; j++) {
                    // max_right = Math.max(max_right, height[j]);
                    if(max_right < height[j]) {
                        max_right = height[j];
                        max_right_index = j;
                    }
                }
            } 
            sum += (Math.min(max_left, max_right) - height[i]);
        }
        return sum;
    }

    public int trap2(int[] height) {
        int sum = 0;
        for(int i = 1; i < height.length; i++) {
            int left = 0;
            int right = 0;
            for(int j = i; j >= 0; j--) {
                left = Math.max(left, height[j]);
            }
            for(int j = i; j < height.length; j++) {
                right = Math.max(right, height[j]);
            }
            sum += (Math.min(left, right) - height[i]);
        }
        return sum;
    }
}
// @lc code=end

