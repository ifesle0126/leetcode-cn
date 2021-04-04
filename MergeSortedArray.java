import java.util.*;

public class MergeSortedArray {


    public static void main(String[] args) {
        int[] A = new int[]{1,0};
        merge(A, 1, new int[]{2}, 1);

        for (int a : A) {
            System.out.println(a);
        }
    }
    

    public static void merge(int[] A, int m, int[] B, int n) {
        if (m < 1) {
            for (int i  = 0; i < n; i++) {
                A[i] = B[i];
            }
            return;
        }
        int aIndex = m - 1;
        int bIndex = n - 1;
        int len = m + n - 1;
        while (len >= 0 && aIndex >= 0 && bIndex >= 0) {
            int num = A[aIndex] > B[bIndex] ? A[aIndex--] : B[bIndex--];
            A[len--] = num;
        }
        int remainIndex = aIndex > bIndex ? aIndex : bIndex;
        int[] remainArr = aIndex > bIndex ? A : B;
        while (len >= 0 && remainIndex >= 0) {
            A[len--] = remainArr[remainIndex--];
        }
    }
}
