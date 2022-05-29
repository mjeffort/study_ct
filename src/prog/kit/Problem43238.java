package prog.kit;

import java.util.Arrays;

/**
 * 입국심사
 */
public class Problem43238 {
    public long solution(int n, int[] times) {
        long answer = 0;
        int max = Arrays.stream(times).max().getAsInt();
        long left = 0;
        long right = (long) max * (long) n;
        while (left < right) {
            long mid = (right - left) / 2 + left;
            long count = countPass(mid, times);
            if (count >= n) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private long countPass(long mid, int[] times) {
        long count = 0;
        for (int i = 0; i < times.length; i++) {
            count += mid / times[i];
        }
        return count;
    }

    public static void main(String[] args) {
        Problem43238 m = new Problem43238();
        int n = 6;
        int[] times = {7, 10};
        long solution = m.solution(n, times);
        System.out.println(solution);
    }
}
