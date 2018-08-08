package Leetcode;

//单词搜索

/**
 * 基本思路很简单，对矩阵里每个点都进行一次深度优先搜索，看它能够产生一个路径和所给的字符串是一样的。
 * 重点在如何优化搜索，避免不必要的计算。比如我们一个方向的搜索中已经发现了这个词，那我们就不用再搜索。
 * 另外，为了避免循环搜索，我们还要将本轮深度优先搜索中搜索过的数字变一下，
 * 等递归回来之后再变回来。实现这个特性最简单的方法就是异或上一个特定数，然后再异或回来。
 */

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 单词必须按照字母顺序，通过相邻的单元格内的字母构成，
 其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 */
public class Test79 {
    public boolean exist(char[][] board, String word) {
        if(board.length == 0) return false;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                // 从i,j点作为起点开始搜索
                boolean isExisted = search(board, i, j, word, 0);
                if(isExisted) return true;
            }
        }
        return false;
    }
    private boolean search(char[][] board, int i, int j, String word, int idx){
        if(idx >= word.length()) return true;
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(idx)) return false;
        // 将已经搜索过的字母标记一下，防止循环。只要变成另外一个字符，就不会再有循环了。
        board[i][j] ^= 255;
        boolean res = search(board, i-1, j, word, idx+1) || search(board, i+1, j, word, idx+1) || search(board, i, j-1, word, idx+1) || search(board, i, j+1, word, idx+1);
        // 再次异或255就能恢复成原来的字母
        board[i][j] ^= 255;
        return res;
    }
}
