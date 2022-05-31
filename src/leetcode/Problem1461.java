package leetcode;

import java.util.HashSet;

public class Problem1461 {

    public boolean hasAllCodes(String s, int k) {
        HashSet<String> sets = new HashSet<>();
        for (int i = 0; i < s.length() - k + 1; i++) {
            sets.add(s.substring(i, i + k));
        }

        if (sets.size() == Math.pow(2, k)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Problem1461 m = new Problem1461();
        String s = "0110";
        int k = 2;
        boolean res = m.hasAllCodes(s, k);
        System.out.println(res);
    }
}
