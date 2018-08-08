package Offer;

import java.util.Stack;

//包含min函数的栈
//定义栈的数据结构，在该类型中实现一个能够找得到栈的最小元素的min函数。在该栈中，min，push，pop的时间复杂度都是O(1)
public class Test30 {
    public Stack<Integer> m_data;
    public Stack<Integer> m_min;

    public void push(Integer value){
        m_data.push(value);
        if(value<m_min.peek()){
            m_min.push(value);
        }else{
            m_min.push(m_min.peek());
        }
    }
    public Integer pop(){
        m_min.pop();
        return m_data.pop();
    }
    public Integer min(){
        return m_min.peek();
    }
}
