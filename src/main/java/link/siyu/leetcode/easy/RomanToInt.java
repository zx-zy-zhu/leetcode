package link.siyu.leetcode.easy;

import com.sun.tools.javac.util.Assert;

/**
 * @author: siyu
 * @date: 2021/2/25
 * @description: 罗马数字转整数
 */
public class RomanToInt {
    /**
     * 沙雕解法
     * @param s
     * @return
     */
    public static int romanToInt2(String s) {
        char[] romanLetters = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int[] correspondingNumbers = {1, 5, 10, 50, 100, 500, 1000};
        int[] specialRomanLetterIndexes = {0, 2, 4};

        int result = 0;
        int pointer = 0;
        while (pointer < s.length()) {
            char romanLetter = s.charAt(pointer++);
            int romanLetterIndex = 0;
            for (int i = 0; i < romanLetters.length; ++i) {
                if (romanLetters[i] == romanLetter) {
                    romanLetterIndex = i;
                    break;
                }
            }

            // 判断是否是存在特例的字符
            boolean isSpecialLetter = false;
            for (int i = 0; i < specialRomanLetterIndexes.length; i++) {
                if (romanLetterIndex == specialRomanLetterIndexes[i]) {
                    isSpecialLetter = true;
                    break;
                }
            }

            // 如果是特殊情况，则计算两个字符的值，然后继续下一个字符
            if (isSpecialLetter && pointer < s.length()) {
                char nextRomanLetter = s.charAt(pointer);
                int validIndex = romanLetterIndex;
                if (romanLetters[++validIndex] == nextRomanLetter || romanLetters[++validIndex] == nextRomanLetter) {
                    int correspondingNumber = correspondingNumbers[validIndex] - correspondingNumbers[romanLetterIndex];
                    result += correspondingNumber;
                    pointer++;
                    continue;
                }
            }

            result += correspondingNumbers[romanLetterIndex];
        }

        return result;
    }

    /**
     * 参考解法
     * @param s
     * @return
     */
    public static int romanToInt(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for(int i = 1;i < s.length(); i ++) {
            int num = getValue(s.charAt(i));
            if(preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }

    private static int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    public static void main(String[] args) {
        int result = romanToInt("III");
        Assert.check(result == 3, "III计算错误, 错误结果：" + result);

        result = romanToInt("IV");
        Assert.check(result == 4, "IV计算错误, 错误结果：" + result);

        result = romanToInt("IX");
        Assert.check(result == 9, "IX计算错误, 错误结果：" + result);

        result = romanToInt("LVIII");
        Assert.check(result == 58, "LVIII计算错误, 错误结果：" + result);

        result = romanToInt("MCMXCIV");
        Assert.check(result == 1994, "MCMXCIV计算错误, 错误结果：" + result);
    }
}
