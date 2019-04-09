package com.github.cjzhusu.dashleetcode.board;

import com.github.cjzhusu.dashleetcode.algorithm.TwoSum;

public class DashDoor {
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int target = 9;
        int[] nums = new int[]{2, 7, 11, 15};
        int[] result = twoSum.twoSum(nums, target);
        System.out.println(result[0]);
    }
}
