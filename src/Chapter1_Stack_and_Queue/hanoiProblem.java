package Chapter1_Stack_and_Queue;

import java.util.Stack;

/**
 * @author DuanmuXu
 * @date 2019/8/12 0:25
 */
public class hanoiProblem {
    /**
     * 递归的方法
     */
    public static int hanoiProblem1(int num, String left, String mid, String right){
        if (num < 1){
            return 0;
        }
        return process(num, left, mid, right, left, right);
    }

    private static int process(int num, String left, String mid, String right, String from, String to) {
        if (num == 1){
            if (from.equals(mid) || to.equals(mid)){
                System.out.println("Move 1 from " + from + " to " + to);
                return 1;
            }else {
                System.out.println("Move 1 from " + from + " to " + mid);
                System.out.println("Move 1 from " + mid + " to " + to);
                return 2;
            }
        }
        if (from.equals(mid) || to.equals(mid)){
            String another = (from.equals(left) || to.equals(left)) ? right : left;
            int part1 = process(num - 1, left, mid, right, from, another);
            int part2 = 1;
            System.out.println("Move " + num + " from " + from + " to " + to);
            int part3 = process(num - 1, left, mid, right, another, to);
            return part1 + part2 + part3;
        }else {
            int part1 = process(num - 1, left, mid, right, from, to);
            int part2 = 1;
            System.out.println("Move " + num + " from " + from + " to " + mid);
            int part3 = process(num - 1, left, mid, right, to, from);
            int part4 = 1;
            System.out.println("Move " + num + " from " + mid + " to " + to);
            int part5 = process(num - 1, left, mid, right, from, to);
            return part1 + part2 + part3 + part4 + part5;
        }
    }

    /**
     * 非递归的方法
     */
    public enum Action{
        No, LToM, MToL, MToR, RToM
    }

    public static int hanoiProblem2(int num, String left, String mid, String right){
        Stack<Integer> lS = new Stack<Integer>();
        Stack<Integer> mS = new Stack<Integer>();
        Stack<Integer> rS = new Stack<Integer>();
        lS.push(Integer.MAX_VALUE);
        mS.push(Integer.MAX_VALUE);
        rS.push(Integer.MAX_VALUE);
        for (int i = num; i > 0; i--){
            lS.push(i);
        }

        Action[] record = {Action.No};
        int step = 0;
        while (rS.size() != num + 1){
            step += fStackToStack(record, Action.MToL, Action.LToM, lS, mS, left, mid);
            step += fStackToStack(record, Action.LToM, Action.MToL, mS, lS, mid, left);
            step += fStackToStack(record, Action.RToM, Action.MToR, mS, rS, mid, right);
            step += fStackToStack(record, Action.MToR, Action.RToM, rS, mS, right, mid);
        }
        return step;
    }

    public static int fStackToStack(Action[] record, Action preNoAct, Action nowAct, Stack<Integer> fStack, Stack<Integer> tStack, String from, String to){
        if (record[0] != preNoAct && fStack.peek() < tStack.peek()){
            tStack.push(fStack.pop());
            System.out.println("Move " + tStack.peek() + " from " + from + " to " + to);
            record[0] = nowAct;
            return 1;
        }
        return 0;
    }

    public static void main(String[] args){
        int num = 3;

        // solution 1
        int steps1 = hanoiProblem1(num, "left", "mid", "right");
        System.out.println("It will move " + steps1 + " steps.");
        System.out.println("===================================");

        //solution 2
        int steps2 = hanoiProblem2(num, "left", "mid", "right");
        System.out.println("It will move " + steps2 + " steps.");
        System.out.println("===================================");
    }
}
