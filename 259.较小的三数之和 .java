/**
 * 
 * Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.
 * Example:
 * Input: nums = [-2,0,1,3], and target = 2
 * Output: 2 
 * Explanation: Because there are two triplets which sums are less than 2:
 *              [-2,0,1]
 *              [-2,0,3]
 * Follow up: Could you solve it in O(n2) runtime?
 */
import java.util.*; 
class Solution {

    int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int r = 0;
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] < target) {
                    r += (k - j);
                    j++;
                } else {
                    k--;
                }
            }
        }
        return r;
    }
    
}
