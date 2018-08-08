package Offer;

import java.util.Stack;

/**
 * 主义下标的判断的时刻
 */
//栈的压入，弹出序列
    //输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出序列
public class Test31 {
    public static void main(String[] args) {
        int[] inOrder={1,2,3,4,5};
        int[] outOrder1={4,5,3,2,1};
        int[] outOrder2={5,4,1,3,2};
        System.out.println(isPopOrder(inOrder,outOrder1));
        System.out.println(isPopOrder(inOrder,outOrder2));
    }
    public static boolean isPopOrder(int[] inOrder,int[] outOrder){
        Stack<Integer> stack=new Stack<>();
        int size=inOrder.length;
        int index=0;
        if(size<=0) return false;
        if(stack.isEmpty()){
            stack.push(inOrder[index]);
            index++;
        }
        int start=0;
        for(start=0;start<outOrder.length;start++){
            while (stack.peek()!=outOrder[start]){
                if(index>=inOrder.length) { //注意判断下标
                    return false;
                }
                stack.push(inOrder[index]);
                index++;
            }
            stack.pop();
        }
        return true;
    }
}
