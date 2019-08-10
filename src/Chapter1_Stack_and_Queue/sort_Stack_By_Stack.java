package Chapter1_Stack_and_Queue;

import java.util.Stack;

/**
 * @author DuanmuXu
 * @date 2019/8/10 23:53
 */

/**
 * 使用一个栈去排序另一个栈中的元素
 */
public class sort_Stack_By_Stack {
    public static void sortStackByStack(Stack<Integer> stack){
        Stack<Integer> help = new Stack<Integer>();
        while (!stack.isEmpty()){
            int cur = stack.pop();
            while (!help.isEmpty() && cur > help.peek()){
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while (!help.isEmpty()){
            stack.push(help.pop());
        }
    }

    public static void main(String[] args){
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(3);
        stack.push(3);
        stack.push(5);
        stack.push(1);
        stack.push(2);
        stack.push(7);
        stack.push(4);
        System.out.println("排序前：");
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }

        System.out.println("-------");
        System.out.println("排序后：");

        stack.push(3);
        stack.push(3);
        stack.push(5);
        stack.push(1);
        stack.push(2);
        stack.push(7);
        stack.push(4);
        sortStackByStack(stack);
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
