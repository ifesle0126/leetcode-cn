public class MaxSumOfSubArray {
    
    public static void main(String[] args) {
        int[] arr = {1,2, -99, 5,-5};
        int num = maxsumofSubarray(arr);
        System.out.println(num);

    }

    public static int maxsumofSubarray (int[] arr) {
        int tmp = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (tmp < 0) {
                tmp = arr[i];
            } else {
                tmp = arr[i] + tmp;
            }
            if(tmp > max) {
                max = tmp;
            }
        }
        return max;
    }

    /**
     * timeout
     */
    public static int maxsumofSubarrayTimeOut (int[] arr) {

        int[] dp = new int[arr.length];
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            dp[i] = arr[i];
            if (max < dp[i]) {
                max = dp[i];
            }
            for (int j = i + 1; j < arr.length; j++){
                dp[j] = dp[j - 1] + arr[j];
                if (max < dp[j]) {
                    max = dp[j];
                }
            }
        }
        return max;
    }

}
