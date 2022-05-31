package prog.kit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 프린터
 */
public class Problem42587 {
    class Doc {
        public int loc;
        public int pri;

        public Doc(int loc, int pri) {
            this.loc = loc;
            this.pri = pri;
        }
    }

    public int solution(int[] priorities, int location) {
        int answer = 0;
        int max = Arrays.stream(priorities).max().getAsInt();
        Queue<Doc> Q = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < priorities.length; i++) {
            Q.offer(new Doc(i, priorities[i]));
        }

        while (!Q.isEmpty()) {
            Doc tmp = Q.poll();
            if (tmp.pri == max) {
                res.add(tmp.loc);
                if (tmp.loc == location) return res.size();
            } else {
                Q.offer(tmp);
            }
            max = Q.stream().map(i -> i.pri).max(Integer::compareTo).get();
        }

        return answer;
    }

    public static void main(String[] args) {
        Problem42587 m = new Problem42587();
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;
        long solution = m.solution(priorities, location);
        System.out.println(solution);
    }
}
