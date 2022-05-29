package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Problem268 {

    public int missingNumber(int[] nums) {
        int sum = 0;
        long sum_nums = 0;
        long n = nums.length;
        for (int i = 0; i < n; i++) {
            sum_nums += nums[i];
            sum += i;
        }
        return (int) (sum + n - sum_nums);
    }
    public static void main(String[] args) {
        Problem268 m = new Problem268();
        int[] nums = {3,0,1};
        int maxForm = m.missingNumber(nums);
        System.out.println(maxForm);
    }
}
