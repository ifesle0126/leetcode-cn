/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 *
 * https://leetcode-cn.com/problems/two-sum/description/
 *
 * algorithms
 * Easy (44.27%)
 * Total Accepted:    235.1K
 * Total Submissions: 531K
 * Testcase Example:  '[2,7,11,15]\n9'
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 
 * 示例:
 * 
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * 
 * 
 */
import java.util.*;


class Solution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        for(int i = 0; i < nums.length; i++) {
            int left = target - nums[i];
            if(map.containsKey(left)) {
                return new int[]{map.get(left), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[2];
    }

    public int[] twoSum2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++){
                int n = nums[i] + nums[j];
                if(n == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }


}
