/*
 * @lc app=leetcode.cn id=509 lang=java
 *
 * [509] 斐波那契数
 */
import java.util.*;

class Solution {

    public int fib(int N) {
        if(N <= 1) {
            return N;
        }
        int a = 0;
        int b = 1;
        for (int i = 3; i <= N; i++) {
            int tmp = a + b;
            a = b;
            b = tmp;
        }
        return a + b;
    }

    /**
     * 
     */
    public int fib_store(int N) {
        if(N <= 1) {
            return N;
        }
        Map<Integer, Integer> map = new HashMap<>();
        return fib(N, map);
    }

    public int fib(int N, Map<Integer, Integer> map) {
        if(map.containsKey(N)){
            return map.get(N);
        }
        if(N == 0) return 0;
        if(N == 1) return 1;
        map.put(N, fib(N - 1, map) + fib(N - 2, map));
        return map.get(N);
    }

    /**
     * 
     * @param N
     * @return
     */
    public int fib_recursion(int N) {
        if(N == 0) {
            return 0;
        }
        if(N == 1){
            return 1;
        }
        return fib(N - 1) + fib(N - 2);
    }
}

