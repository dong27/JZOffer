package Leetcode;

import java.util.ArrayList;
import java.util.List;

//N皇后
//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
//每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
public class Test51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        int[] queenList = new int[n]; //第i个位置存放的数表示row行时，Q的列
        placeQueen(queenList, 0, n, res);//在第0行放Q
        return res;
    }
    private void placeQueen(int[] queenList, int row, int n, List<List<String>> res) {
        //如果已经填满，就生成结果
        if (row == n) {
            ArrayList<String> list = new ArrayList<String>();
            for (int i = 0; i < n; i++) {
                String str = "";
                for (int col = 0; col < n; col++){
                    if(queenList[i] == col) {
                        str += "Q";
                    } else {
                        str += ".";
                    }
                }
                list.add(str);
            }
            res.add(list);
        }
        for (int col = 0; col < n; col++) {//循环每一列
            if (isValid(queenList, row, col)) { //如果在该列放入Q不冲突的话
                queenList[row] = col;
                placeQueen(queenList, row + 1, n, res);
            }
        }
    }
    private boolean isValid(int[] queenList, int row, int col) {
        for (int i = 0; i < row; i++) {
            int pos = queenList[i];
            if (pos == col) { //和新加入的Q处于同一列
                return false;
            }
            if (pos + row - i == col) { //在新加入的Q的右对角线上
                return false;
            }
            if (pos - row + i == col) { //在新加入的Q的左对角线上
                return false;
            }
        }
        return true;
    }
}