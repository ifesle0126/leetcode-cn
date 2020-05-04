/*
 * @lc app=leetcode.cn id=432 lang=java
 *
 * [432] 全 O(1) 的数据结构
 *
 * https://leetcode-cn.com/problems/all-oone-data-structure/description/
 *
 * algorithms
 * Hard (34.28%)
 * Likes:    43
 * Dislikes: 0
 * Total Accepted:    2.8K
 * Total Submissions: 8.3K
 * Testcase Example:  '["AllOne","getMaxKey","getMinKey"]\n[[],[],[]]'
 *
 * 请你实现一个数据结构支持以下操作：
 * 
 * 
 * Inc(key) - 插入一个新的值为 1 的 key。或者使一个存在的 key 增加一，保证 key 不为空字符串。
 * Dec(key) - 如果这个 key 的值是 1，那么把他从数据结构中移除掉。否则使一个存在的 key 值减一。如果这个 key
 * 不存在，这个函数不做任何事情。key 保证不为空字符串。
 * GetMaxKey() - 返回 key 中值最大的任意一个。如果没有元素存在，返回一个空字符串"" 。
 * GetMinKey() - 返回 key 中值最小的任意一个。如果没有元素存在，返回一个空字符串""。
 * 
 * 
 * 
 * 
 * 挑战：
 * 
 * 你能够以 O(1) 的时间复杂度实现所有操作吗？
 * 
 */

// @lc code=start
import java.util.*;

public class AllOne {

    // Map that stores key to the node
    Map<String, Integer> map;
    
    // Map that groups keys having same value using double
    // linked list as value
    Map<Integer, Set<String>> valueMap;
    
    // MinMax linkedlist to keep track of
    // min and max values
    LinkedList<Integer> minMax;

    /** Initialize your data structure here. */
    public AllOne() {
        map = new HashMap<>();
        valueMap = new HashMap<>();
        minMax = new LinkedList<Integer>();
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        // If new key, just insert into the map
        // and place it in the appropriate position
        // in value map
        if(!map.containsKey(key)) {
            map.put(key, 1);
            putInValueMap(1, key);
        } else {
            // If already existing
            int val = map.get(key);
            // Remove from value map for old value
            removeFromValueMap(val, key);
            // Increment value
            map.put(key, val + 1);
            // Place it the new value in value map
            putInValueMap(val + 1, key);
        }
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        // If this key not found, just return
        if(!map.containsKey(key)) {
            return;
        }
        
        int val = map.get(key);
        // If value is 1, then remove from map
        if(val == 1) {
            map.remove(key);
            // Remove from value map too
            removeFromValueMap(1, key);
        } else {
            // Remove from old value
            removeFromValueMap(val, key);
            // Decrement value
            map.put(key, val - 1);
            
            // Insert at new value
            putInValueMap(val - 1, key);
        }
        
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if(minMax == null || minMax.isEmpty()) {
            return "";
        }
        // minMax.getFirst() always has max value
        if(valueMap.size() == 1) {
            return valueMap.entrySet().iterator().next().getValue().iterator().next();
        }
        Set<String> set =  valueMap.get(minMax.getFirst());
        if(set == null) {
            return "";
        }
        return set.iterator().next();
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if(minMax == null || minMax.isEmpty()) {
            return "";
        }
        // minMax.getLast() always has min value
        if(valueMap.size() == 1) {
            return valueMap.entrySet().iterator().next().getValue().iterator().next();
        }
        Set<String> set =  valueMap.get(minMax.getLast());
        if(set == null) {
            return "";
        }
        return set.iterator().next();
    }
    
    private void putInValueMap(int count, String node) {
        // If not seen before, create a new dll
        if(!valueMap.containsKey(count)) {
            valueMap.put(count, new HashSet<String>());
        }
        // Add to dll
        valueMap.get(count).add(node);
        
        // Update min max
        if(minMax.isEmpty() || minMax.getFirst() < count) {
            minMax.addFirst(count);
        }
        
        if(minMax.isEmpty() || minMax.getLast() > count) {
            minMax.addLast(count);
        }
    }
    
    private void removeFromValueMap(int count, String node) {
        // If not present in value map, just return
        if(!valueMap.containsKey(count)) {
            return;
        }
        
        // Remove from dll in value map
        valueMap.get(count).remove(node);
        
        // If no elements present with this value
        if(valueMap.get(count).size() == 0) {
            // Remove from value map all together
            valueMap.remove(count);
            
            // Update min max
            if(!minMax.isEmpty() && minMax.getLast() == count) {
                minMax.removeLast();
            }
            if(!minMax.isEmpty() && minMax.getFirst() == count) {
                minMax.removeFirst();
            }
        }
    }
}
/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
// @lc code=end

