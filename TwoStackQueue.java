import java.util.*;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。

 */
public class TwoStackQueue {


    // public static void main(String[] args) {

    // }
    
}


class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        while (!stack1.isEmpty()) {
            Integer i = stack1.pop();
            stack2.push(i);
        }
        stack1.push(node);
        while (!stack2.isEmpty()) {
            Integer i = stack2.pop();
            stack1.push(i);
        }   
    }
    
    public int pop() {
        return stack1.pop();
    }
}