import java.util.*;

public class QuitSort {

    public static void main(String[] args) {
        int[] arr = {5, 9, 1, 9, 5, 3, 7, 6, 1};
        quitSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    
    private static void quitSort(int[] arr, int beg, int end) {
        if (beg >= end) {
            return;
        }
        int i = beg;
        int j = end;
        int f = arr[beg]; 
        while (i < j) {
            while (i < j && f < arr[j]) j--;
            if (i < j) {
                arr[i++] = arr[j];
            }
            while (i < j && f > arr[i]) i++;
            if (i < j) {
                arr[j--] = arr[i];
            }
        }
        arr[i] = f;
        quitSort(arr, beg, i - 1);
        quitSort(arr, i + 1, end);
    }
}
