import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=561 lang=java
 *
 * [561] 数组拆分 I
 */
class Solution {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for(int i = 0; i < nums.length; i+=2) {
            sum+=nums[i];
        }
        return sum;
    }


    /**
     * time limit
     * @param nums
     * @return
     */
    public int arrayPairSum_Error(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[i] < nums[j]) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
            if((i + 1) % 2 == 0) {
                sum += nums[i];
            }
        }
        return sum;
    }
}

