package Chapter1_Stack_and_Queue;

import java.util.LinkedList;

/**
 * @author DuanmuXu
 * @date 2019/8/13 22:39
 */
public class window_Max_Array {
    public static int[] getMaxWindow(int[] arr, int w){
        if (arr == null || w < 1 || arr.length < w){
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<Integer>();
        // 定义输出数组长度
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++){
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]){
                qmax.pollLast();
            }
            qmax.addLast(i);
            if (qmax.peekFirst() == i - w){
                qmax.pollFirst();
            }
            if (i >= w - 1){
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args){
        int[] arr = {4,3,5,4,3,3,6,7};
        int[] result = getMaxWindow(arr, 3);
        for (int res:result) {
            System.out.print(res + " ");
        }
    }
}
