package link.siyu.leetcode.easy;

/**
 * @author: siyu
 * @date: 2021/1/29
 * @description: 整数反转
 */
public class IntegerReverse {

    /**
     * 沙雕解法
     *
     * @param x
     * @return
     */
    public static int reverse(int x) {
        boolean negative = false;
        if (x < 0) {
            negative = true;
            x = -x;
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(x);
        stringBuilder.reverse();
        String reverseString = stringBuilder.toString();
        if (negative) {
            reverseString = "-" + reverseString;
        }

        try {
            return Integer.parseInt(reverseString);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    /**
     * 最优解法
     *
     * @param x
     * @return
     */
    public static int reverse2(int x) {
        int result = 0;

        int current;
        while (x != 0) {
            current = x % 10;
            if (result > Integer.MAX_VALUE / 10
                    || (result == Integer.MAX_VALUE / 10 && x > 7)) {
                return result;
            }
            if (result < Integer.MIN_VALUE / 10
                    || (result == Integer.MIN_VALUE / 10 && x < -8)) {
                return result;
            }
            result = result * 10 + current;

            x = x / 10;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(1234567899));

        System.out.println(reverse2(1234567899));
    }
}
