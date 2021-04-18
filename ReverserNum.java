import java.util.*;

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
