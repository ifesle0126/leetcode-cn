import java.util.*;

public class CanJump {

    public static void main(String[] args) {
        int[] nums  = new int[]{2,0,0,1,4};
        boolean b = canJump(nums);
        System.out.println(b);
    }

    public static boolean canJump(int[] nums) {
        int minStepCount = 1;
        int i = nums.length - 2;
        while (i >= 0) {
            int num = nums[i];
            if (num >= minStepCount) {
                i--;
                continue;
            } else if (i == 0) {
                return false;
            } else {
                minStepCount++;
            }
            i--;
        }
        return true;
    }
    
}
