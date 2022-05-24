package prog.kit;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 가장 큰 수
 */
public class Problem42746 {
    class Num implements Comparable<Num>{
        public String n;

        public Num(String n) {
            this.n = n;
        }

        public Num(int n) {
            this.n = String.valueOf(n);
        }

        @Override
        public int compareTo(Num o) {
            int ch = this.n.length() - o.n.length();
            if (ch != 0 && this.n.startsWith(o.n)) {
                Num sub = new Num(this.n.substring(o.n.length()));
                return sub.compareTo(o);
            } else if (ch != 0 && o.n.startsWith(this.n)) {
                Num sub = new Num(o.n.substring(this.n.length()));
                return this.compareTo(sub);
            }
            return this.n.compareTo(o.n);
        }
    }
    public String solution(int[] numbers) {
        String answer = "";
        List<Num> list = Arrays.stream(numbers).mapToObj(Num::new).collect(Collectors.toList());
        Collections.sort(list, Collections.reverseOrder());
        for (Num s : list) {
            answer += s.n;
        }
        long res;
        try {
            res = Long.parseLong(answer);
        } catch (Exception e) {
            return answer;
        }
        return String.valueOf(res);
    }

    public static void main(String[] args) {
        Problem42746 m = new Problem42746();
        int[] numbers = {0,0,0,0};
        String solution = m.solution(numbers);
        System.out.println(solution);
    }
}
