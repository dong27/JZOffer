package Leetcode;

import java.util.ArrayList;
import java.util.List;

//文本左右对齐
//给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。

//你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每
// 行恰好有 maxWidth 个字符。
//要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
//文本的最后一行应为左对齐，且单词之间不插入额外的空格。
public class Test68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int pos = 0;
        int len = 0;
        int w = 0;
        for(int i=0; i<words.length; i++) {
            len += words[i].length();
            w ++;
            if (len + (w-1) > maxWidth) {
                StringBuilder sb = new StringBuilder();
                int remainSpaces = maxWidth - (len - words[i].length());
                int remainWords = w - 2;
                int space = remainWords>0?(int)Math.ceil((double)remainSpaces/remainWords): remainSpaces;
                for(int j=0; j<w-1; j++) {
                    sb.append(words[i+1-w+j]);

                    for(int k=0; k<space; k++) sb.append(" ");
                    remainSpaces -= space;
                    remainWords --;
                    space = remainWords>0?(int)Math.ceil((double)remainSpaces/remainWords): remainSpaces;
                }
                result.add(sb.toString());
                len = words[i].length();
                w = 1;
            }
            if (i==words.length-1) {
                StringBuilder sb = new StringBuilder();
                int remainSpaces = maxWidth - len;
                int space = 1;
                for(int j=0; j<w; j++) {
                    sb.append(words[i+1-w+j]);
                    if (j<w-1) space = 1; else space = remainSpaces;
                    for(int k=0; k<space; k++) sb.append(" ");
                    remainSpaces -= space;
                }
                result.add(sb.toString());
            }
        }
        return result;
    }
}
