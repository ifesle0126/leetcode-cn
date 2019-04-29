import java.util.*;

/*
 * @lc app=leetcode.cn id=448 lang=java
 *
 * [448] 找到所有数组中消失的数字
 */
class Solution {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> r = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if(nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                r.add(i + 1);
            }
        }
        return r;
    }

    public List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> r = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int n : nums) {
            set.add(n);
        }
        for(int i = 1; i <= nums.length; i++) {
            if(!set.contains(i)) {
                r.add(i) ;
            }
        }
        return r;
    }
}

