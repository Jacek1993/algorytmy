package codility;

import java.util.Arrays;

public class Solution1 {
    static String solution(String S) {
        int[] occurrences = new int[26];
        for (char ch : S.toCharArray()) {
            occurrences[ch - 'a']++;
        }
        System.out.println(Arrays.toString(occurrences));

        char best_char = '\0';
        int  best_res  = 0;

        for (int i = 0; i < 26; i++) {
            if (occurrences[i] > best_res) {
                best_char = (char)((int)'a' + i);
                best_res  = occurrences[i];
            }
        }

        return Character.toString(best_char);
    }

    public static void main(String[] args) {
        System.out.println(solution("hello"));
        System.out.println(solution(""));
        System.out.println(solution("abcdefg"));
    }
}