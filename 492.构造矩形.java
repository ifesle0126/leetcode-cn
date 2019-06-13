/*
 * @lc app=leetcode.cn id=492 lang=java
 *
 * [492] 构造矩形
 */
class Solution {

    public int[] constructRectangle(int area) {
        int w = 1;
        int l = area;
        while (w * w <= area) {
            if (area % w == 0) {
                l = area / w;
            }
            w = w + 1;
        }

        return new int[]{l, area / l};
    }


    public int[] constructRectangle2(int area) {
        int l = area;
        int w = 1;
        while (l > w) {
            if (area % l == 0) {
                w = area / l;
            }
            l = l - 1;
        }

        return new int[]{area / w, w};
    }
}

