import java.util.*;

/**
 * 将给出的32位整数x翻转。
 *  例1:x=123，返回321
 *  例2:x=-123，返回-321
 *  你有注意到翻转后的整数可能溢出吗？因为给出的是32位整数，则其数值范围为[−2^{31}, 2^{31} − 1][−2 
 *  31
 *  ,2 
 *  31
 *  −1]。翻转可能会导致溢出，如果反转后的结果会溢出就返回 0。
 */
public class ReverserNum {
    
    public static void main(String[] args) {
        int num = -123;
        System.out.println(reverse(num));
    }

    public static int reverse(int x) {
        if (x > -10 && x < 10) {
            return x;
        }
        boolean positive = true;
        if(x < 0) {
            positive = false;
            x = -x;
        }
        Queue<Integer> stack = new LinkedList<>();
        while (x > 0) {
            stack.add(x % 10);
            x = x / 10;
        }
        int num = 0;
        while (!stack.isEmpty()) {
            int n = stack.poll();
            num = num * 10 + n;
        }
        return positive ? num : -num;
    }
}
