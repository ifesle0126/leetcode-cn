/*
 * @lc app=leetcode.cn id=496 lang=java
 *
 * [496] 下一个更大元素 I
 */
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] re = new int[nums1.length];
        int index = 0;
        for (int num1 : nums1) {
            int i = 0;
            while(nums2[i++] != num1);
            i--;
            int j;
            for (j = i + 1; j < nums2.length; j++) {
                if(nums2[j] > num1) {
                    re[index++] = nums2[j];
                    break;
                }
            }
            if(j == nums2.length) {
                re[index++] = -1;
            }
        }
        return re;
    }
}

