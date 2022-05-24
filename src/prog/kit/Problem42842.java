package prog.kit;

/**
 * 카펫
 */
public class Problem42842 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int n = brown + yellow;
        for (int i = 3; i*i <= n; i++) {
            if (n % i == 0) {
                int j = n / i;
                if ((i - 2) * (j - 2) == yellow) {
                    answer[0] = j;
                    answer[1] = i;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Problem42842 m = new Problem42842();
        int[] solution = m.solution(10, 2);
        for (int i : solution) {
            System.out.print(i + " ");
        }

    }
}
