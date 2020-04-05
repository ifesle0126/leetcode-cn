import java.util.*;

/*
 * @lc app=leetcode.cn id=220 lang=java
 *
 * [220] 存在重复元素 III
 */

// @lc code=start
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length <= 1) {
            return false;
        }

        if (nums.length >=2 && k > 0) {
            long iLong = (long)nums[1];
            long jLong = (long)nums[0];
            if (Math.abs(iLong - jLong) <= t) 
                return true;
        }
        for (int i = 0; i < nums.length; ++i) {
            for (int j = Math.max(i - k, 0); j < i; ++j) {
                long iLong = (long)nums[i];
                long jLong = (long)nums[j];
                if (Math.abs(iLong - jLong) <= t) 
                    return true;
            }
        }
        return false;
    }
}


class Solution2 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        for (int i = 0; i < nums.length; i++) {
            int end = i + k < nums.length ? i + k : nums.length - 1;
            boolean f = subNearBy(nums, i, end, t);
            if(f) {
                return f;
            }
        }
        return false;
    }

    private boolean subNearBy(int[] nums, int i, int k, int t) {
        int[] r = subSort(nums, i, i + k);
        int min = Integer.MAX_VALUE;
        for (int ii = i; ii < r.length - 1; ii++) {
            if (Math.abs(r[ii + 1] - r[ii]) < min) {
                min = r[ii + 1] - r[ii];
            }
        }
        if (min > t) {
            return false;
        }
        return subNearByTrace(r, 0, r.length - 1, t);
    }

    private boolean subNearByTrace(int[] r, int i, int j, int t) {
        if (i > j) {
            return false;
        }
        if (Math.abs(r[j] - r[i]) == t) {
            return true;
        }
        return subNearByTrace(r, i + 1, j, t) || subNearByTrace(r, i, j - 1, t);
    }

    private int[] subSort(int[] nums, int beg, int end) {
        int[] r = new int[end - beg + 1];
        for (int i = beg; i < r.length; i++) {
            r[i-beg] = nums[i];
        }
        Arrays.sort(r);
        return r;
    }
}
// @lc code=end

