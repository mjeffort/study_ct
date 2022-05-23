package prog.kit;

import java.util.Arrays;

/**
 * 모의고사
 */
public class Problem42840 {
    public int[] solution(int[] answers) {
        int[] arrA = {1, 2, 3, 4, 5}; //5
        int[] arrB = {2, 1, 2, 3, 2, 4, 2, 5}; //8
        int[] arrC = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; //10
        int n = answers.length;
        int[] res = new int[3];
        for (int i = 0; i < n; i++) {
            if (answers[i] == arrA[i % 5]) res[0] += 1;
            if (answers[i] == arrB[i % 8]) res[1] += 1;
            if (answers[i] == arrC[i % 10]) res[2] += 1;
        }

        int max = Arrays.stream(res).max().getAsInt();

        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (res[i] == max) count++;
        }
        int[] answer = new int[count];
        int k = 0;
        for (int i = 0; i < 3; i++) {
            if (res[i] == max)
                answer[k++] = i + 1;
        }

        return answer;
    }

    public static void main(String[] args) {
        Problem42840 m = new Problem42840();
        int[] a = {1, 2, 3, 4, 5};
        m.solution(a);
    }
}
