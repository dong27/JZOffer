package Leetcode;

import java.util.ArrayList;
import java.util.List;

//组合
//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
public class Test77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (k > n)
        {
            return ret;
        }
        List<Integer> list = new ArrayList<Integer>();
        getpass(n, k, list, ret, 1);

        return ret;
    }
    public void getpass(int n, int k, List<Integer> list,
                        List<List<Integer>> ret, int start)
    {
        if (list.size() == k)
        {
            ret.add(new ArrayList<Integer>(list));
            return;
        }
        int len = list.size();
        for (int i = start; i <= n; i++)
        {
            //加上下面着一个判断语句，速度就提高了很多，嘿嘿
            if (n - i < (k - len-1))
            {
                return;
            }
            list.add(i);
            getpass(n, k, list, ret, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
