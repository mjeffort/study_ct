package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Problem354 {

    class Envelope implements Comparable<Envelope> {
        public int w;
        public int h;

        public Envelope(int w, int h) {
            this.w = w;
            this.h = h;
        }

        @Override
        public int compareTo(Envelope o) {
            if (this.w == o.w) return o.h - this.h;
            return this.w - o.w;
        }
    }

    public int maxEnvelopes(int[][] envelopes) {
        int res = 0;
        ArrayList<Envelope> list = new ArrayList<>();
        for (int i = 0; i < envelopes.length; i++) {
            list.add(new Envelope(envelopes[i][0], envelopes[i][1]));
        }
        Collections.sort(list);
        int[] dp = new int[envelopes.length];
        for (Envelope e : list) {
            int he = e.h;
            int left = Arrays.binarySearch(dp, 0, res, he);
            if (left < 0) left = -left - 1;
            if (left == res) res++;
            dp[left] = he;
        }
        return res;
    }

    public static void main(String[] args) {
        Problem354 m = new Problem354();
        int[][] envelopes = {{5, 4}, {6, 5}, {6, 7}, {2, 3}};
//        int[][] envelopes = {{1,1},{1,1},{1,1}};
        int maxForm = m.maxEnvelopes(envelopes);
        System.out.println(maxForm);
    }
}
