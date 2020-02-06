/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 *
 * https://leetcode-cn.com/problems/container-with-most-water/description/
 *
 * algorithms
 * Medium (56.17%)
 * Likes:    1088
 * Dislikes: 0
 * Total Accepted:    133K
 * Total Submissions: 218.1K
 * Testcase Example:  '[1,8,6,2,5,4,8,3,7]'
 *
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为
 * (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * 
 * 
 * 
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 
 * 
 * 
 * 示例:
 * 
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 * 
 */

// @lc code=start
class Solution {

    public int maxArea(int[] height) {
        int L = height.length, lo = 0, hi = L-1;
        int max = 0;
        while(lo<hi) {	  
            int loMax = height[lo], hiMax = height[hi];      
    
            int candidate = (hi-lo) * (loMax<hiMax ? loMax : hiMax);
            max = candidate > max ? candidate : max;
    
            if(height[lo]<=height[hi]) 
                while(lo<hi && height[lo]<=loMax) ++lo; 
            else 
                while(hi>lo && height[hi]<=hiMax) --hi;
        }
        return max;
    }

    public int maxArea_timeLimit(int[] height) {
        int b = 0;
        int e = height.length - 1;
        int max = 0;
        while (b < e) {
            int w = e - b;
            int h = height[b] < height[e] ? height[b] : height[e];
            int max_tmp = w * h;
            if (max_tmp > max) {
                max = max_tmp;
            }
            if(height[b] < height[e]) {
                while(b + 1 < e && height[b + 1] < height[b]) {
                    b++;
                }
            } else {
                while(e - 1 > b && height[e - 1] < height[e]) {
                    e--;
                }
            }
        }
        return max;
    }
}
// @lc code=end

