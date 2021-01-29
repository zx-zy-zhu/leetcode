package link.siyu.leetcode.easy;

/**
 * @author: siyu
 * @date: 2021/1/29
 * @description: 是否回文数字
 */
public class IsPalindrome {

    /**
     * 反转后判断是否相等（问题：反转后溢出的数字会存在问题）
     *
     * TODO: 还有其他解法，比如判断前半部分和后半部分是否相等
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int result = 0;
        int current;
        int y = x;
        while (y != 0) {
            current = y % 10;
            if (result > Integer.MAX_VALUE / 10
                    || (result == Integer.MAX_VALUE / 10 && y > 7)) {
                break;
            }
            result = result * 10 + current;

            y = y / 10;
        }

        return x == result;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(12321));
    }
}
