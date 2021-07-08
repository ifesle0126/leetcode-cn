import java.util.*;


public class FoundOnceNumber {
        /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param arr int一维数组 
     * @param k int 
     * @return int
     */
    public int foundOnceNumber (int[] arr, int k) {
        // write code here

        List<Set<Integer>> listSet = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            listSet.add(new HashSet<>());
        }
        
        for (int num : arr) {
            boolean has = false;
            for (int index = 0; index < k - 1; index++) {
                if (listSet.get(index).contains(num)) {
                    has = true;
                    listSet.get(index).remove(num);
                    listSet.get(index + 1).add(num);
                }
            }
            if (!has) {
                listSet.get(0).add(num);
            }
        }
        return listSet.get(0).iterator().next();





        // Set<Integer> set = new HashSet<>();
        // long sum = 0;
        // long all = 0;
        // for (int i : arr) {
        //     all += i;
        //     if (!set.contains(i)) {
        //         sum += i;
        //         set.add(i);;
        //     }
        // }
        // for (int i : set) {
        //     if (all - i == (sum - i) * k) {
        //         return i;
        //     }
        // }
        // return -1;
    }
}
