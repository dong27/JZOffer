package Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//合并区间
//给出一个区间的集合，请合并所有重叠的区间。
public class Test56 {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals==null||intervals.size()==0){
            return intervals;
        }
        if(intervals.size()==1){
            return intervals;
        }
        for(int i=0;i<intervals.size();i++){
            Interval temp1=intervals.get(i);
            if(temp1==null){
                continue;
            }
            for(int j=i+1;j<intervals.size();j++){
                Interval temp2=intervals.get(j);
                temp1=intervals.get(i);
                if(temp2==null){
                    continue;
                }
                if(temp1==null){
                    continue;
                }
                if(temp2.end<temp1.start){
                    continue;
                }else if(temp2.end>=temp1.start&&temp2.end<=temp1.end&&temp2.start<=temp1.start){
                    Interval replace=new Interval(temp2.start, temp1.end);
                    intervals.remove(j);
                    intervals.add(j, replace);
                    intervals.remove(i);
                    intervals.add(i, null);
                }else if(temp2.start<=temp1.start&&temp2.end>=temp1.end){
                    Interval replace=new Interval(temp2.start, temp2.end);
                    intervals.remove(j);
                    intervals.add(j, replace);
                    intervals.remove(i);
                    intervals.add(i, null);
                }else if(temp2.start>=temp1.start&&temp2.end<=temp1.end){
                    Interval replace=new Interval(temp1.start, temp1.end);
                    intervals.remove(j);
                    intervals.add(j, replace);
                    intervals.remove(i);
                    intervals.add(i, null);
                }else if(temp2.start>=temp1.start&&temp2.end>=temp1.end&&temp2.start<=temp1.end){
                    Interval replace=new Interval(temp1.start, temp2.end);
                    intervals.remove(j);
                    intervals.add(j, replace);
                    intervals.remove(i);
                    intervals.add(i, null);

                }else if(temp2.start>=temp1.end){
                    continue;
                }
            }

        }
        List<Interval> result=new ArrayList<Interval>();
        for(int i=0;i<intervals.size();i++){
            if(intervals.get(i)==null){

            }else{
                result.add(intervals.get(i));
            }
        }
        Collections.sort(result, new Comparator<Interval>() {

            @Override
            public int compare(Interval o1, Interval o2) {
                // TODO Auto-generated method stub
                return o1.start-o2.start;
            }
        });
        return result;
    }
    public class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }
}
