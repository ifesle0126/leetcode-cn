import java.util.*;

public class TopKNum {
    

    public static void main(String[] args) {
        int[] arr = {1332802,1177178,1514891,871248,753214,123866,1615405,328656,1540395,968891,1884022,252932,1034406,1455178,821713,486232,860175,1896237,852300,566715,1285209,1845742,883142,259266,520911,1844960,218188,1528217,332380,261485,1111670,16920,1249664,1199799,1959818,1546744,1904944,51047,1176397,190970,48715,349690,673887,1648782,1010556,1165786,937247,986578,798663};
        int n = arr.length;
        int k = 24;
        int num = findKth(arr, n - 1, k - 1);
        System.out.println(num);
    }

    private static int findKth(int[] a, int n, int k) {
        return findKth(a, k, 0, n);
    }


    private static int findKth(int[] a, int k, int beg, int end) {
        if (beg >= end) {
            throw new RuntimeException("params error. beg:" + beg + " end:" + end);
        }
        int f = a[beg];
        int i = beg;
        int j = end;
        while (i < j) {
            while (i < j && a[j] < f) j--;
            if (i < j) {
                a[i++] = a[j];
            }
            while (i < j && a[i] > f) i++;
            if (i < j) {
                a[j--] = a[i];
            }
        }
        a[i] = f;
        if (i == k) {
            return f;
        } else if (i < k) {
            return findKth(a, k, i + 1, end);
        } else {
            return findKth(a, k, beg, i - 1);
        }
    }
}
