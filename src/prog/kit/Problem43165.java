package prog.kit;

/**
 * 타겟 넘버
 */
public class Problem43165 {
    static int answer = 0;
    public int solution(int[] numbers, int target) {

        int[] ch = new int[numbers.length];
        dfs(numbers, target, 0, ch);

        return answer;
    }

    private void dfs(int[] numbers, int target, int i, int[] ch) {
        if (i == numbers.length) {
            int sum = 0;
            for (int j = 0; j < numbers.length; j++) {
                sum += (numbers[j] * ch[j]);
            }
            if (sum == target) answer++;
            return;
        } else {
            ch[i] = -1;
            dfs(numbers, target, i + 1, ch);
            ch[i] = 1;
            dfs(numbers, target, i + 1, ch);
        }

        return;
    }

    public static void main(String[] args) {
        Problem43165 m = new Problem43165();
        int[] numbers = {4, 1, 2, 1};
        int target = 4;
        int solution = m.solution(numbers, target);
        System.out.println(solution);
    }
}
