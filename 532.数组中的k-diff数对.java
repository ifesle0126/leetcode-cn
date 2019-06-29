/*
 * @lc app=leetcode.cn id=532 lang=java
 *
 * [532] 数组中的K-diff数对
 */
import java.util.*;

class Solution {
    public int findPairs(int[] nums, int k) {
        if(k == 0) {
            int repeat = 0;
            Set<Integer> set = new HashSet<>();
            Set<Integer> items = new HashSet<>();
            for (int num : nums) {
                if (set.contains(num)) {
                    items.add(num);
                } else {
                    set.add(num);
                }
            }
            return items.size();
        }
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == nums[i + 1] && k > 0) {
                continue;
            }
            int ii = nums[i] + k;
            int j = i + 1;
            while (j < nums.length && nums[j] < ii) {
                j++;
            }
            if(j < nums.length && nums[j] == ii) {
                count++;
            }
        }
        return count;
    }
}

