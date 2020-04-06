/*
 * @lc app=leetcode.cn id=460 lang=java
 *
 * [460] LFU缓存
 *
 * https://leetcode-cn.com/problems/lfu-cache/description/
 *
 * algorithms
 * Hard (35.97%)
 * Likes:    162
 * Dislikes: 0
 * Total Accepted:    9K
 * Total Submissions: 22.8K
 * Testcase Example:  '["LFUCache","put","put","get","put","get","get","put","get","get","get"]\n' +
  '[[2],[1,1],[2,2],[1],[3,3],[2],[3],[4,4],[1],[3],[4]]'
 *
 * 请你为 最不经常使用（LFU）缓存算法设计并实现数据结构。它应该支持以下操作：get 和 put。
 * 
 * 
 * get(key) - 如果键存在于缓存中，则获取键的值（总是正数），否则返回 -1。
 * put(key, value) -
 * 如果键不存在，请设置或插入值。当缓存达到其容量时，则应该在插入新项之前，使最不经常使用的项无效。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除
 * 最近 最少使用的键。
 * 
 * 
 * 「项的使用次数」就是自插入该项以来对其调用 get 和 put 函数的次数之和。使用次数会在对应项被移除后置为 0 。
 * 
 * 
 * 
 * 进阶：
 * 你是否可以在 O(1) 时间复杂度内执行两项操作？
 * 
 * 
 * 
 * 示例：
 * 
 * LFUCache cache = new LFUCache( 2 ); //capacity (缓存容量)
 * 
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // 返回 1
 * cache.put(3, 3);    // 去除 key 2
 * cache.get(2);       // 返回 -1 (未找到key 2)
 * cache.get(3);       // 返回 3
 * cache.put(4, 4);    // 去除 key 1
 * cache.get(1);       // 返回 -1 (未找到 key 1)
 * cache.get(3);       // 返回 3
 * cache.get(4);       // 返回 4
 * 
 */

// @lc code=start
import java.util.*;


class LFUCache {

    /*
    Approach: Create a class called Node which will be a node of a DoublyLinkedList having key, value, frequency,
          prevNode and nextNode.
          Use a HashMap (keyNodeMap: key -> Node) to handle data access by key.
          Then use a HashMap (freqNodeDLLMap: frequency -> DoublyLinkedList<Node>) to handle frequency.
          Also, maintain a variable (minumumFrequency) which will store the current minimum frequency of keys in cache.
          Thus if we want to add a new key, we just need to find (or create new) the likedlist by its frequency (which is 1),
          add the item to the start of the linked list.
          If cache is full and we need to remove an item, we will get the minimum frequency (minumumFrequency),
          get the appropriate linkedlist from freqNodeDLLMap by it, then remove the last item of that linkedlist.
          Also we'll use the key of that removed item to remove the item from our cache (keyNodeMap).
          If we want to increment the freqneucy of a key, we'll get the node, remove it from its current frequency linked list
          by joining it's prevNode and nextNode (This is why we're using DoublyLinkedList. No need to find a node by traversing
          to remove it. If we have the node, we can just join its previous and next node to remove it.). Then add the node to
          the linkedlist of the new (incremented) frequency.
          Thus, the frequency ranking management will be done in O(1) time.
    
    Complexity analysis: Time: O(1), Space: O(n).

    */
    
    
    int capacity;
    HashMap<Integer, Node> keyNodeMap = new HashMap<>();
    HashMap<Integer, NodeDLinkedList> freqNodeDLLMap = new HashMap<>();
    int minumumFrequency = 1;
    
    public LFUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        Node node = keyNodeMap.get(key);
        if(node != null){                                                               //Item exists
            incrementFrequency(node);                                                   //Increment frequency
            return node.value;                                                          //Return value
        }
        else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        
        if(capacity <= 0) return;
        
        if(keyNodeMap.containsKey(key)){                                                //Item exists
            
            Node node = keyNodeMap.get(key);                                            //Get old node 
            node.value = value;                                                         //Update with new value
            incrementFrequency(node);                                                   //Increment frequency
            keyNodeMap.put(key, node);                                                  //Put (update) in cache
        }
        else{                                                                           //Item doesn't exist 
            
            Node node = new Node(key, value);                                           //Create new node
            
            if(keyNodeMap.size() == capacity){                                          //Cache is full
                Node removedLastNode = freqNodeDLLMap.get(minumumFrequency)
                                        .removeLastNode();                              //Remove LFU node from removedLastNode
                keyNodeMap.remove(removedLastNode.key);                                 //Remove LFU node from cache
            }
            
            incrementFrequency(node);                                                   //Add to frequency map
            keyNodeMap.put(key, node);                                                  //Add to cache
            
            minumumFrequency = 1;                                                       //Since new node is having freqency as 1,
                                                                                        //update minumumFrequency to be 1
        }
        
    }
    
    
    private void incrementFrequency(Node node){
        
        int oldFrequency = node.frequency;
        
        if(freqNodeDLLMap.containsKey(oldFrequency)){                                   //Frequency already exists
            NodeDLinkedList oldNodeDLinkedList = freqNodeDLLMap.get(oldFrequency);      //Get frequency linkedlist
            oldNodeDLinkedList.remove(node);                                            //Remove current node
            if(node.frequency == minumumFrequency &&                                    //If this frequency was the minumum freq.
                oldNodeDLinkedList.length == 0){                                        //and no node is having this freq anymore
                minumumFrequency++;                                                     //Increment minumum frequency
            }
        }

        int newFrequency = oldFrequency + 1;                                            //Increment frequency
        node.frequency = newFrequency;                                                  //Set new frequency to node
        NodeDLinkedList newNodeDLinkedList =                                            //Get or create the LinkedList for 
            freqNodeDLLMap.getOrDefault(                                                //this new frequency
            newFrequency, new NodeDLinkedList()
        );           
        newNodeDLinkedList.add(node);                                                   //Add node to the freq linkedlist
        freqNodeDLLMap.put(newFrequency, newNodeDLinkedList);                           //Put freq linkedlist to freqNodeDLLMap
    }
    
    
    private class Node{
        int key;
        int value;
        int frequency;
        Node prev;
        Node next;
        Node(int key, int value){
            this.key = key;
            this.value = value;
            this.frequency = frequency;
        }
    }
    
    private class NodeDLinkedList{
        
        Node head, tail;
        int length;
        
        //Add a node to top
        void add(Node node){
            
            //Remove old pointers
            node.prev = null;
            node.next = null;
                
            if(head==null){                                                               //Empty list
                head = node;
                tail = node;
            }
            else{
                node.next = head;                                                         //Forward linking
                head.prev = node;                                                         //Backward linking
                head = node;
            }
            
            length++;
        }
        
        //Remove a node
        void remove(Node node){
            
            if(node==head){                                                               //Need to remove head node
                if(node==tail){                                                           //Tail node is the same (list size = 1) 
                    tail=null;                                                            //Make tail null
                }
                head = head.next;                                                         //Make head point to the next node
            }
            else{                                                                         //Need to remove later node
                node.prev.next = node.next;                                               //Forward linking

                if(node==tail){                                                           //Need to remove tail node
                    tail = node.prev;                                                     //Point tail to prev node
                }
                else{
                    node.next.prev = node.prev;                                           //Backward linking
                }
            }
            
            length--;
            
        }
        
        //Remove last node
        Node removeLastNode(){
            
            Node tailNode = tail;
            
            if(tailNode != null){                                                         //LastNode exists 
                remove(tailNode);
            }
            return tailNode;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

