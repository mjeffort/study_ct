package prog.kit;

import java.util.Arrays;

/**
 * H-Index
 */
public class Problem42747 {
    public int solution(int[] citations) {
        int answer = 0;
        int max = Arrays.stream(citations).max().getAsInt();
        for (int i = max; i >= 0; i--) {
            int tmp = i;
            long count = Arrays.stream(citations).filter(j -> j >= tmp).count();
            if (count >= tmp) return tmp;
        }
        return answer;
    }

    public static void main(String[] args) {
        Problem42747 m = new Problem42747();
        int[] citations = {3, 0, 6, 1, 5};
        int solution = m.solution(citations);
        System.out.println(solution);
    }
}
