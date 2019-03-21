import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 求众数
 *
 * https://leetcode-cn.com/problems/majority-element/description/
 *
 * algorithms
 * Easy (58.22%)
 * Total Accepted:    29K
 * Total Submissions: 49.8K
 * Testcase Example:  '[3,2,3]'
 *
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 * 
 * 示例 1:
 * 
 * 输入: [3,2,3]
 * 输出: 3
 * 
 * 示例 2:
 * 
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 * 
 * 
 */
import java.util.*;

class Solution {
    public int majorityElement(int[] nums) {
        if ( nums.length == 1) {
            return nums[0];
        }
         Map<Integer, Integer> numberCount = new HashMap<>();
         for(int i : nums) {
             Integer old = numberCount.put(i, 1);
             if(old != null) {
                 if (old + 1 > nums.length /2 ) {
                     return i;
                 }
                 numberCount.put(i, old + 1);
             }
             
         }
         return -1;
    }
}

