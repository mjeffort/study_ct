package kakao.blind22.prac04;

import java.util.Arrays;

public class Main {

    public boolean cmp(int[] a, int[] b) {
        for (int i = 11; i >= 0; i--) {
            if(a[i] != b[i]) return a[i] > b[i];
        }
        return false;
    }

    public int[] solution(int n, int[] info) {
        int[] mn = new int[12];
        Arrays.fill(mn, -1);

        for (int brute = 0; brute < 1024; brute++) {
            int[] arrow = new int[12];
            int score = 0;
            int left = n;

            for (int i = 0; i < 10; i++) {
                if ((brute & (1 << i)) != 0) {
                    score += (10 - i);
                    left -= (info[i] + 1);
                    arrow[i] = info[i] + 1;
                } else if (info[i] != 0)
                    score -= (10 - i);
            }
            if (score <= 0 || left < 0) continue;
            arrow[10] = left;
            arrow[11] = score;
            if (cmp(arrow, mn)) {
                for (int i = 0; i < 12; i++) {
                    mn[i] = arrow[i];
                }
            }
        }
            if (mn[0] == -1) {
                int[] ret = new int[1];
                ret[0] = -1;
                return ret;
            }
            int[] ret = new int[11];
            for (int i = 0; i < 11; i++) {
                ret[i] = mn[i];
            }
            return ret;
    }



    public static void main(String[] args) {
        Main main = new Main();
        int n = 10;
        int[] info = {0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3};
        int[] solution = main.solution(n, info);
        for (int i : solution) {
            System.out.print(i + " ");
        }
    }
}
