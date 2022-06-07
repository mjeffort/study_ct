package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    public static void main(String[] args) {
        Problem88 main = new Problem88();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3;
        int n = 3;
        main.merge(nums1, m, nums2, n);
//        System.out.println(maxForm);
    }
}
