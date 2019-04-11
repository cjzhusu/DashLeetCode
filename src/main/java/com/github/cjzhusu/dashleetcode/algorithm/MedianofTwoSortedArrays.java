package com.github.cjzhusu.dashleetcode.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * <p>
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * <p>
 * You may assume nums1 and nums2 cannot be both empty.
 * <p>
 * Example 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * The median is 2.0
 * Example 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * The median is (2 + 3)/2 = 2.5
 */
public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int m_ind = 0;
        int n_ind = 0;
        List<Integer> arr = new ArrayList<>();
        while (m_ind < m || n_ind < n) {
            int m_max = Integer.MAX_VALUE;
            int n_max = Integer.MAX_VALUE;
            if (m_ind < m) {
                m_max = nums1[m_ind] < m_max ? nums1[m_ind] : m_max;
            }

            if (n_ind < n) {
                n_max = nums2[n_ind] < n_max ? nums2[n_ind] : n_max;
            }

            if (m_max < n_max) {
                m_ind++;
                arr.add(m_max);
            } else if (n_max < m_max) {
                n_ind++;
                arr.add(n_max);
            } else {
                m_ind++;
                n_ind++;
                arr.add(m_max);
                arr.add(n_max);
            }
        }

        int arrLen = arr.size();
        if (arrLen % 2 == 1) {
            return (double) arr.get(arrLen / 2);
        } else {
            return (double) (arr.get(arrLen / 2) + arr.get(arrLen / 2 - 1)) / 2;
        }
    }

    public static void main(String[] args) {
        MedianofTwoSortedArrays mtsa = new MedianofTwoSortedArrays();
        int[] nums1 = {0};
        int[] nums2 = {};
        double res = mtsa.findMedianSortedArrays(nums1, nums2);
        System.out.println(res);
    }
}
