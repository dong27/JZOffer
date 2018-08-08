package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//与所有单词相关联的字串
//给定一个字符串 s 和一些长度相同的单词 words。在 s 中找出可以恰好串联 words 中所有单词的子串的起始位置。

//注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
/**
 * 看了排名第一的解法，茅塞顿开。其中利用到了“滑动窗口”的思想，也有点像KMP。思路是假设字典中每个单词的长度为size，
 * 那么以size为窗口大小来滑动窗口。如果有单词加入，就扩大窗口右边界，如果单词不连续，就缩小窗口左边界。这样做的好处是，
 * 同一step下的所有满足条件的答案都可以一次性的加到结果中，并且是以size作为step扫描的，效率大大提高。大概的思路是，
 * 和解法一一样需要把字典放到HashMap里面，以字典中单词长度size为step，依次扫描字符串对应的位置，比如例一，
 * 分别扫描1, 4, 7.../2, 5, 8.../3, 6, 9...。维持一个初始大小为size的窗口，左边界为每次扫描字符串的起始位置，
 * 右边界根据每次扫描到的子串单词决定。建立一个新的HashMap记录当前窗口里的单词。如果接下来的子串单词在字典中，那么把他加入到窗口字典。
 * 如果窗口字典中单词个数恰好是字典中单词总数，且每个单词对应的出现次数完全一致，那么这就是一个符合要求的匹配。
 * 如果扫描到的子串不在字典中，或者窗口字典中单词出现次数已经超过了原本字典单词的出现次数，那就要调整左边界和窗口字典，
 * 使匹配能继续进行。详见下文代码。
 */
public class Test30 {
    public List<Integer> findSubstring(String s, String[] words) {
        if (s.length() == 0 || words == null || words.length == 0) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        int size = words[0].length(), len = words.length;
        HashMap<String, Integer> m = new HashMap<>();
        HashMap<String, Integer> curM = new HashMap<>();
        for (int j = 0; j < words.length; j++)
            m.put(words[j], m.getOrDefault(words[j], 0) + 1);
        for (int i = 0; i < size; i++) {
            int start = i;
            int count = 0;
            curM.clear();
            for (int j = i; j <= s.length() - size; j += size) {
                String cur = s.substring(j, j + size);
                if (m.containsKey(cur)) {
                    curM.put(cur, curM.getOrDefault(cur, 0) + 1);
                    count++;
                    while (curM.get(cur) > m.get(cur)) {
                        String left = s.substring(start, start + size);
                        curM.put(left, curM.get(left) - 1);
                        count--;
                        start += size;
                    }
                    if (count == len) {
                        res.add(start);
                        String left = s.substring(start, start + size);
                        curM.put(left, curM.get(left) - 1);
                        count--;
                        start += size;
                    }
                }
                else {
                    start = j + size;
                    curM.clear();
                    count = 0;
                }
            }
        }
        return res;
    }
}
