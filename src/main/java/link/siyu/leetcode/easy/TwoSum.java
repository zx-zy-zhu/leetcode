package link.siyu.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: siyu
 * @date: 2021/1/29
 * @description: 两数之和
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        Map<Integer, Integer> elementMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int expect = target - nums[i];
            if (elementMap.containsKey(expect)) {
                result[0] = elementMap.get(expect);
                result[1] = i;
                break;
            }
            elementMap.put(nums[i], i);
        }

        return result;
    }
}
