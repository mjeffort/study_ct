package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Problem191 {

    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }

    public static void main(String[] args) {
        Problem191 m = new Problem191();
        int n = 00000000000000000000000000001011;
        int maxForm = m.hammingWeight(n);
        System.out.println(maxForm);
    }
}
