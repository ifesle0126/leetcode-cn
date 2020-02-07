import java.util.*;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 *
 * https://leetcode-cn.com/problems/3sum/description/
 *
 * algorithms
 * Medium (22.91%)
 * Likes:    1764
 * Dislikes: 0
 * Total Accepted:    151.5K
 * Total Submissions: 598.1K
 * Testcase Example:  '[-1,0,1,2,-1,-4]'
 *
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0
 * ？找出所有满足条件且不重复的三元组。
 * 
 * 注意：答案中不可以包含重复的三元组。
 * 
 * 
 * 
 * 示例：
 * 
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 
 * 满足要求的三元组集合为：
 * [
 * ⁠ [-1, 0, 1],
 * ⁠ [-1, -1, 2]
 * ]
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Arrays.sort(nums);
        // List<List<Integer>> res = new LinkedList<>(); 
        // for (int i = 0; i < nums.length-2; i++) {
        //     if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
        //         int lo = i+1, hi = nums.length-1, sum = 0 - nums[i];
        //         while (lo < hi) {
        //             if (nums[lo] + nums[hi] == sum) {
        //                 res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
        //                 while (lo < hi && nums[lo] == nums[lo+1]) lo++;
        //                 while (lo < hi && nums[hi] == nums[hi-1]) hi--;
        //                 lo++; hi--;
        //             } else if (nums[lo] + nums[hi] < sum) lo++;
        //             else hi--;
        //        }
        //     }
        // }
        // return res;

        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++) {
            if(i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int n1 = nums[i];
                int b = i + 1;
                int e = nums.length - 1;
                while(b < e) {
                    int n2 = nums[b];
                    int n3 = nums[e];
                    if(n1 + n2 + n3 == 0) {
                        list.add(new ArrayList<>(Arrays.asList(n1, n2, n3)));
                        while (b < e && nums[b] == nums[b+1]) b++;
                        while (b < e && nums[e] == nums[e-1]) e--;
                        b++;
                        e--;
                    } else if (n2 + n3 < -n1) {
                        b++;
                    } else {
                        e--;
                    }
                }
             }
        }
        return list;
    }
}
// @lc code=end

