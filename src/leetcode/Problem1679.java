package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Problem1679 {

    public int maxOperations2(int[] nums, int k) {
        int[] ch = new int[nums.length];
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if(ch[i] == 1) continue;
            for (int j = i + 1; j < nums.length; j++) {
                if(ch[j] == 1) continue;
                if (nums[i] + nums[j] == k) {
                    res++;
                    ch[i] = 1;
                    ch[j] = 1;
                    break;
                }
            }
        }
        return res;
    }
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> hash = new HashMap<>();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (hash.getOrDefault(k - nums[i], 0) > 0) {
                res++;
                hash.put(k - nums[i], hash.get(k - nums[i]) - 1);
            } else {
                hash.put(nums[i], hash.getOrDefault(nums[i], 0) + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Problem1679 m = new Problem1679();
        int[] nums = {1, 2, 3, 4};
        int k = 5;
        int maxForm = m.maxOperations(nums, k);
        System.out.println(maxForm);
    }
}
