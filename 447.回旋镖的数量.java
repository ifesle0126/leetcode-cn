import java.util.*;

/*
 * @lc app=leetcode.cn id=447 lang=java
 *
 * [447] 回旋镖的数量
 */
class Solution {

    public int numberOfBoomerangs(int[][] points) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            map.clear();
            for (int j = 0; j < points.length; j++) {
                if(i == j) {
                    continue;
                }
                int distance = (points[j][0] - points[i][0]) * (points[j][0] - points[i][0]) + (points[j][1] - points[i][1]) * (points[j][1] - points[i][1]);
                int size = map.getOrDefault(distance, 0);
                count += size * 2;
                map.put(distance, size + 1);
            }
        }
        return count;
    }
}

