/*
 * @lc app=leetcode.cn id=475 lang=java
 *
 * [475] 供暖器
 */
import java.util.*;


class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int j = 0;
        int pre = heaters[0];
        int res = 0;
        for (int i = 0; i < houses.length; i++) {
            int positionHouse = houses[i];
            while (j < heaters.length - 1 && heaters[j] < positionHouse) {
                pre = heaters[j];
                j++;
            }
            int distanceToPreHeater = Math.abs(positionHouse - pre);
            int distanceToAfterHeater = Math.abs(positionHouse - heaters[j]);
            res = Math.max(res, Math.min(distanceToPreHeater, distanceToAfterHeater));
        }
        return res;
    }
}

