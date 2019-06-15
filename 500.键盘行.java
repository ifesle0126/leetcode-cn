import java.util.*;

/*
 * @lc app=leetcode.cn id=500 lang=java
 *
 * [500] 键盘行
 */
class Solution {
    public String[] findWords(String[] words) {
        int[] mapping = new int[26];
        String[] keyboard = new String[]{"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        for(int i = 0; i < keyboard.length; i++) {
            String line = keyboard[i];
            char[] cells = line.toCharArray();
            for(char cell : cells) {
                mapping[cell - 'a'] = i + 1;
            }
        }
        List<String> list = new ArrayList<>();
        for(String word : words) {
            String lowerWord = word.toLowerCase();
            char[] lowerCells = lowerWord.toCharArray();
            int level = mapping[lowerCells[0] - 'a'];
            boolean f = true;
            for(int i = 1; i < lowerCells.length; i++) {
                if(level != mapping[lowerCells[i] - 'a']) {
                    f = false;
                    break;
                }
            }
            if(f) {
                list.add(word);
            }
        }
        return list.toArray(new String[list.size()]);
    }
}

