public class BinarySearch {
    
    public static void main(String[] args) {

    }


    public static int bSearch(int[] nums, int target) {
        // write code here
        int b = 0;
        int e = nums.length - 1;
        while (b <= e) {
            int mid = (e + b) / 2;
            if (nums[mid] == target) {
                while(mid - 1 >=0 && nums[mid - 1] == target)mid--;
                return mid;
            } else if (nums[mid] > target) {
                e = mid - 1;
            } else if (nums[mid] < target) {
                b = mid + 1;
            }
        }
        return -1;
    }
}
