package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Problem1480 {

    public int[] runningSum(int[] nums) {
        int[] res = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            res[i] = sum;
        }
        return res;
    }
    public static void main(String[] args) {
        Problem1480 m = new Problem1480();
        int[] nums = {1, 2, 3, 4};
        int[] solution = m.runningSum(nums);
        for (Integer o : solution) {
            System.out.println(o + " ");
        }
    }
}
