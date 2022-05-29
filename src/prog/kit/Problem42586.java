package prog.kit;

import java.util.*;

/**
 * 기능개발
 */
public class Problem42586 {

    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> deploy = new ArrayList<>();
        int n = progresses.length;
        int[] ch = new int[n];
        int[] en = new int[n];
        PriorityQueue<Integer> Q = new PriorityQueue<>();

        int k = 0;
        while (ch[n - 1] == 0) {
            for (int i = 0; i < n; i++) {
                progresses[i] += speeds[i];
                if (en[i] == 0 && progresses[i] >= 100) {
                    Q.offer(i);
                    en[i] = 1;
                }
            }

            int count = 0;
            while (!Q.isEmpty() && Q.peek() == k) {
                Q.poll();
                ch[k++] = 1;
                count++;
            }
            if(count > 0) deploy.add(count);
        }

        return deploy.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        Problem42586 m = new Problem42586();
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        int[] solution = m.solution(progresses, speeds);
        for (Integer i : solution) {
            System.out.println(i);
        }
    }
}
