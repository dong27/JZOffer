package Offer;

import java.util.Comparator;
import java.util.PriorityQueue;

//数据流中的中位数
public class Test41 {
    private PriorityQueue<Integer> minQueue=new PriorityQueue<>();
    private PriorityQueue<Integer> maxQueue=new PriorityQueue<>(15, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });
    int count=0;
    public void insert(Integer num){
        count++;
        if((count&1)==0){
            if(!maxQueue.isEmpty()&&num<maxQueue.peek()){
                maxQueue.offer(num);
                num=maxQueue.poll();
            }
            minQueue.offer(num);
        }else{
            if(!minQueue.isEmpty()&&num>minQueue.peek()){
                minQueue.offer(num);
                num=minQueue.poll();
            }
            maxQueue.offer(num);
        }
    }
    public double getMedian(){
        if((count&1)==0){
            return ((double)(maxQueue.peek()+minQueue.peek()))/2;
        }else
            return (double)maxQueue.peek();
    }
}
