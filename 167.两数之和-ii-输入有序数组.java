/*
 * @lc app=leetcode.cn id=167 lang=java
 *
 * [167] 两数之和 II - 输入有序数组
 *
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/description/
 *
 * algorithms
 * Easy (48.00%)
 * Total Accepted:    18.7K
 * Total Submissions: 38.9K
 * Testcase Example:  '[2,7,11,15]\n9'
 *
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * 
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * 
 * 说明:
 * 
 * 
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 
 * 
 * 示例:
 * 
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 * 
 */
class Solution {


    public int[] twoSum(int[] numbers, int target) {
        if(numbers == null || numbers.length < 1) {
            return new int[2];
        }
        int b = 0;
        int e = numbers.length - 1;
        while(b < e) {
            if(numbers[b] + numbers[e] == target) {
                return new int[]{b + 1, e + 1};
            } else if (numbers[b] + numbers[e] > target) {
                e--;
            } else {
                b++;
            }
        }
        return new int[2];
    }


    public int[] twoSum2(int[] numbers, int target) {
        if(numbers == null || numbers.length < 1) {
            return new int[2];
        }
        int b = 0;
        int e = b + 1;
        while (b < numbers.length - 1) {
            if(numbers[b] + numbers[e] == target) {
                return new int[]{b + 1, e + 1};
            } else if (numbers[b] + numbers[e] < target) {
                e++;
            } else if (numbers[b] + numbers[e] > target) {
                b++;
                e = b + 1;
            }
            if (e > numbers.length - 1) {
                b++;
                e = b + 1;
            }
        }
        return new int[2];
    }
}

