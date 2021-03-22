package link.siyu.leetcode.easy;

import java.util.*;

/**
 * @author: siyu
 * @date: 2021/2/25
 * @description: 最长公共前缀
 */
public class LongestCommonPrefix {

    /**
     * 沙雕解法
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {

        if (strs.length <= 0) {
            return "";
        }

        String commonPrefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            commonPrefix = commonPrefix(commonPrefix, strs[i]);
        }

        return commonPrefix;
    }

    private static String commonPrefix(String a, String b) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length() && i < b.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                break;
            }
            sb.append(a.charAt(i));
        }
        return sb.toString();
    }

    /**
     * 排序法
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix2(String[] strs) {
        if (strs.length <= 0) {
            return "";
        }
        long t = System.currentTimeMillis();
        quickSort(strs, 0, strs.length - 1);
        System.out.println("treeSet构造时间：" + (System.currentTimeMillis() - t));

        t = System.currentTimeMillis();
        String a = strs[0];
        String b = strs[strs.length - 1];
        System.out.println("获取元素时间：" + (System.currentTimeMillis() - t));

        t = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length() && i < b.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                break;
            }
            sb.append(a.charAt(i));
        }
        System.out.println("获取子串时间：" + (System.currentTimeMillis() - t));
        return sb.toString();
    }

    private static void quickSort(String[] arr,int left,int right)      //快速排序算法
    {
        String f,t;
        int rtemp,ltemp;

        ltemp=left;
        rtemp=right;
        f=arr[(left+right)/2];            //分界值
        while(ltemp<rtemp)
        {
            while(arr[ltemp].compareTo(f)<0)
            {
                ++ltemp;
            }
            while(arr[rtemp].compareTo(f)>0)
            {
                --rtemp;
            }
            if(ltemp<=rtemp)
            {
                t=arr[ltemp];
                arr[ltemp]=arr[rtemp];
                arr[rtemp]=t;
                --rtemp;
                ++ltemp;
            }
        }
        if(ltemp==rtemp)
        {
            ltemp++;
        }
        if(left<rtemp)
        {
            quickSort(arr,left,ltemp-1);      //递归调用
        }
        if(ltemp<right)
        {
            quickSort(arr,rtemp+1,right);      //递归调用
        }
    }

    public static void main(String[] args) {
        long t = System.currentTimeMillis();
        String[] strs1 = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix2(strs1));
        System.out.println("总执行时间：" + (System.currentTimeMillis() - t));
    }
}
