/*
 * @lc app=leetcode.cn id=217 lang=java
 *
 * [217] 存在重复元素
 *
 * https://leetcode-cn.com/problems/contains-duplicate/description/
 *
 * algorithms
 * Easy (47.47%)
 * Total Accepted:    47.6K
 * Total Submissions: 100.3K
 * Testcase Example:  '[1,2,3,1]'
 *
 * 给定一个整数数组，判断是否存在重复元素。
 * 
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 * 
 * 示例 1:
 * 
 * 输入: [1,2,3,1]
 * 输出: true
 * 
 * 示例 2:
 * 
 * 输入: [1,2,3,4]
 * 输出: false
 * 
 * 示例 3:
 * 
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 * 
 */
import java.util.*;


class Solution {


    public boolean containsDuplicate(int[] nums) {
        byte[] mark = new byte[150000];
        for (int i : nums) {
            int j = i/8;
            int k = i%8;
            int check = 1<<k;
            if ((mark[j] & check) != 0) {
                return true;
            }
            mark[j]|=check;
        }
        return false;
    }

    public boolean containsDuplicate3(int[] nums) {
        BitSet bitSet = new BitSet(Integer.MAX_VALUE);
        bitSet.set(0, Integer.MAX_VALUE, false);
        for (int num : nums) {
            boolean b = bitSet.get(num);
            if(b) {
                return true;
            } else {
                bitSet.set(num, true);
            }
        }
        return false;
    }

    public boolean containsDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            boolean b = set.add(num);
            if (!b) {
                return true;
            }
        }
        return false;
    }
}

