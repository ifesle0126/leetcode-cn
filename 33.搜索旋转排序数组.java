/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 *
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/description/
 *
 * algorithms
 * Medium (36.58%)
 * Likes:    501
 * Dislikes: 0
 * Total Accepted:    70.8K
 * Total Submissions: 194.8K
 * Testcase Example:  '[4,5,6,7,0,1,2]\n0'
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * 
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 
 * 你可以假设数组中不存在重复的元素。
 * 
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 
 * 示例 1:
 * 
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 
 * 
 * 示例 2:
 * 
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 * 
 */

// @lc code=start

class Solution {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        int b = 0;
        int e = nums.length - 1;
        while(b < e) {
            int m = (b + e) / 2;
            int n = nums[m];
            if(n == target) {
                return m;
            }
            if(nums[b] <= n) {
                if(target >= nums[b] && target < n) {
                    e = m - 1;
                } else {
                    b = m + 1;
                }
            } else {
                if(target > n && target <= nums[e]) {
                    b = m + 1;
                } else {
                    e = m - 1;
                }
            }
        }
        return nums[b] == target ? b : -1;
    }
}


class Solution2 {
    public int search(int[] nums, int target) {
        if(nums.length < 1) {
            return -1;
        }
        int r = -1;
        int i;
        for(i = 0; i < nums.length - 2; i++) {
            if(nums[i] > nums[i+1]) {
                break;
            }
        }
        r = search2(nums, 0, i, target);
        System.out.println(i);
        if(r != -1) {
            return r;
        } else {
            r = search2(nums, i + 1, nums.length -1, target);
        }
        return r;
    }

    private int search2(int[] nums, int beg, int end, int target) {
        if(beg > end) {
            return -1;
        }
        if(beg == end && target != nums[beg]) {
            return -1;
        }
        int mid = (beg + end) / 2;
        if(target < nums[mid]) {
            return search2(nums, beg, mid - 1, target);
        } else if (target > nums[mid]) {
            return search2(nums, mid + 1, end, target);
        } else {
            return mid;
        }
    }
}
// @lc code=end

