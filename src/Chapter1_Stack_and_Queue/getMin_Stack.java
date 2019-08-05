package Chapter1_Stack_and_Queue;

/**
 * @author DuanmuXu
 * @date 2019/8/4 23:11
 */

import java.util.Stack;

/**
 * 题目：实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作
 */
public class getMin_Stack {
    public static class Mystack1{
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public Mystack1(){
            this.stackData = new Stack<Integer>();
            this.stackMin = new Stack<Integer>();
        }

        public void push(int newNum){
            if (this.stackMin.isEmpty()){
                this.stackMin.push(newNum);
            }else if (newNum <= this.getmin()){
                this.stackMin.push(newNum);
            }
            this.stackData.push(newNum);
        }

        public int getmin(){
            if (this.stackMin.isEmpty()){
                throw new RuntimeException("Your stack is empty.");
            }
            return this.stackMin.peek();
        }

        public int pop(){
            if (this.stackData.isEmpty()){
                throw new RuntimeException("Your stack is empty.");
            }
            int value = this.stackData.pop();
            if (value == this.getmin()){
                this.stackMin.pop();
            }
            return value;
        }
    }

    public static class Mystack2{
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public Mystack2(){
            this.stackData = new Stack<Integer>();
            this.stackMin = new Stack<Integer>();
        }

        public void push(int newNum){
            if (this.stackMin.isEmpty()){
                this.stackMin.push(newNum);
            }else if (newNum <= this.getmin()){
                this.stackMin.push(newNum);
            }else {
                int value = this.stackMin.peek();
                this.stackMin.push(value);
            }
            this.stackData.push(newNum);
        }

        public int getmin(){
            if (this.stackMin.isEmpty()){
                throw new RuntimeException("Your stack is empty.");
            }
            return this.stackMin.peek();
        }

        public int pop(){
            if (this.stackData.isEmpty()){
                throw new RuntimeException("Your stack is empty.");
            }
            this.stackMin.pop();
            return this.stackData.pop();
        }
    }

    /**
     * Mystack1与Mystack2区别
     * 方案一中stackMin压入时稍省空间，但是弹出操作稍费时间
     * 方案二中stackMin压入时稍费空间，但是弹出操作稍省时间
     */
    public static void main(String[] args){
        Mystack1 mystack1 = new Mystack1();
        mystack1.push(2);
        System.out.println(mystack1.getmin());
        mystack1.push(4);
        System.out.println(mystack1.getmin());
        mystack1.push(1);
        System.out.println(mystack1.getmin());
        System.out.println(mystack1.pop());
        System.out.println(mystack1.getmin());

        System.out.println("----------------------");

        Mystack2 mystack2 = new Mystack2();
        mystack2.push(2);
        System.out.println(mystack2.getmin());
        mystack2.push(4);
        System.out.println(mystack2.getmin());
        mystack2.push(1);
        System.out.println(mystack2.getmin());
        System.out.println(mystack2.pop());
        System.out.println(mystack2.getmin());
    }
}
