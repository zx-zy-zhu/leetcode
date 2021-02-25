package link.siyu.leetcode.easy;

/**
 * @author: siyu
 * @date: 2021/2/25
 * @description: 最长公共前缀
 */
public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        String result = null;
        for (String str : strs) {
            if (result == null) {
                result = str;
                continue;
            }

            if (str.length() > result.length()) {
                continue;
            }
        }

        return result;
    }
}
