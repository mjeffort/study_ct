package prog.kit;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * N으로 표현
 * 미제출
 */
public class Problem42895 {
    class Vertex implements Comparable<Vertex> {
        public int sum;
        public int cnt;

        public Vertex(int sum, int cnt) {
            this.sum = sum;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Vertex o) {
            return this.cnt - o.cnt;
        }
    }
    public int solution(int N, int number) {
        int answer = 0;
        answer = bfs(N, number);
        return answer;
    }

    private int bfs(int n, int number) {
        int res = 1;
        PriorityQueue<Vertex> Q = new PriorityQueue<>();
        Q.offer(new Vertex(n, res));
        if(Q.poll().sum == number) return res;
        res++;
        Q.offer(new Vertex(n + 10 * n, res));
        Q.offer(new Vertex(n + n, res));
        Q.offer(new Vertex(n / n, res));
        Q.offer(new Vertex(n * n, res));
        Q.offer(new Vertex(n - n, res));
        while (!Q.isEmpty()) {

            if(res > 8) break;
            int nn = n;
            for (int i = 1; i <= res; i++) {
                nn += 10 * i * n;
            }
            Q.offer(new Vertex(nn, res + 1));
            while(Q.peek().cnt == res) {
                Vertex tmp = Q.poll();
                if(tmp.sum == number) return res;
                Q.offer(new Vertex(tmp.sum + n, res+1));
                Q.offer(new Vertex(tmp.sum / n, res+1));
                Q.offer(new Vertex(tmp.sum * n, res+1));
                Q.offer(new Vertex(tmp.sum - n, res+1));
                Q.offer(new Vertex(tmp.sum + (n*n), res+2));
                Q.offer(new Vertex(tmp.sum + (n/n), res+2));
                Q.offer(new Vertex(tmp.sum - (n*n), res+2));
                Q.offer(new Vertex(tmp.sum - (n/n), res+2));
            }
            res++;

        }

        for (Vertex v : Q) {
            if (v.cnt <= 8 && v.sum == number) {
                return v.cnt;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Problem42895 m = new Problem42895();
        int solution = m.solution(5, 54);
        System.out.println(solution);
    }
}
