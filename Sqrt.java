import java.util.*;


public class Sqrt {
    
    /**
     * 
     * @param x int整型 
     * @return int整型
     */
    public int sqrt (int x) {
        // write code here
        int l = 1;
        int r = x;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (mid <= x / mid && (mid + 1) > x / (mid + 1)) {
                return mid;
            } else if ( mid > x / mid) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return 0;
    }

}
