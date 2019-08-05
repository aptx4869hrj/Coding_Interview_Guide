package Stack_and_Queue;

/**
 * @author DuanmuXu
 * @date 2019/8/5 22:30
 */

import java.util.Stack;

/**
 * 题目：编写一个类，用两个栈实现队列，支持队列的基本操作（add，poll，peek）
 */
public class twoStack_to_Queue {
    public static class twoStacksQueue{
        Stack<Integer> stackPush;
        Stack<Integer> stackPop;

        public twoStacksQueue(){
            this.stackPush = new Stack<Integer>();
            this.stackPop = new Stack<Integer>();
        }

        // 将stackPush中的元素全部倒叙放在stackPop中
        public void pushTopop(){
            if (stackPop.isEmpty()){
                while (!stackPush.isEmpty()){
                    stackPop.push(stackPush.pop());
                }
            }
        }

        public void add(int newNum){
            stackPush.push(newNum);
            pushTopop();
        }

        public int peek(){
            if (stackPush.isEmpty() && stackPop.isEmpty()){
                throw new RuntimeException("Your queue is empty");
            }
            pushTopop();
            return stackPop.peek();
        }

        public int pull(){
            if (stackPush.isEmpty() && stackPop.isEmpty()){
                throw new RuntimeException("Your queue is empty");
            }
            pushTopop();
            return stackPop.pop();
        }
    }

    public static void main(String[] args){
        twoStacksQueue twoStacksQueue = new twoStacksQueue();
        twoStacksQueue.add(5);
        System.out.println(twoStacksQueue.peek());
        twoStacksQueue.add(6);
        twoStacksQueue.add(7);
        twoStacksQueue.add(8);
        System.out.println(twoStacksQueue.pull());
        twoStacksQueue.add(9);
        System.out.println(twoStacksQueue.pull());
        twoStacksQueue.add(10);
        System.out.println(twoStacksQueue.pull());
        System.out.println(twoStacksQueue.pull());
        System.out.println(twoStacksQueue.pull());
        System.out.println(twoStacksQueue.pull());
    }
}
