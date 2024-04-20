/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 *
 * https://leetcode-cn.com/problems/move-zeroes/description/
 *
 * algorithms
 * Easy (53.40%)
 * Total Accepted:    41.2K
 * Total Submissions: 77.2K
 * Testcase Example:  '[0,1,0,3,12]'
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 
 * 示例:
 * 
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 
 * 说明:
 * 
 * 
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * 
 * 
 */
class Solution {

    public void moveZeroes3(int[] nums) {
        int insertPosition = 0;
        int index = 0;
        while(index < nums.length) {
            if(nums[index] != 0) {
                nums[insertPosition] = nums[index];
                insertPosition++;
            }
            index++;
        }
        while(insertPosition < nums.length) {
            nums[insertPosition++] = 0;
        }
    }

    public void moveZeroes2(int[] nums) {
        int index = 0;
        while (index < nums.length) {
            int num = nums[index];
            if(num == 0) {
                int innerIndex = index + 1;
                while (innerIndex < nums.length && nums[innerIndex] == 0) {
                    innerIndex++;
                }
                if(innerIndex == nums.length){
                    return;
                }
                int tmp = nums[innerIndex];
                nums[innerIndex] = nums[index];
                nums[index] = tmp;
                
            } 
            index++;
        }
    }

    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = i + 1;
        while (j < nums.length) {
            if (nums[i] == 0) {
                if (nums[j] != 0) {
                    nums[i] = nums[j];
                    nums[j] = 0;
                    i++;
                }
            } else {
                i++;
            }
            j++;
        }
    }
}

