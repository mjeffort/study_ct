package prog.kit;

import java.util.Arrays;

/**
 * 소수 찾기
 */
public class Problem42839 {
    static int res;
    static boolean[] ch;
    public int solution(String numbers) {
        res = 0;
        ch = new boolean[10000000];
        for (int k = 1; k <= numbers.length(); k++) {
            char[] tmp = new char[k];
            boolean[] visited = new boolean[numbers.length()];
            perm(numbers.toCharArray(), tmp, visited, 0, numbers.length(), k);
        }

        return res;
    }

    static void perm(char[] arr, char[] output, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
            if(isPrime(output)) res++;
            return;
        }

        for (int i=0; i<n; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                output[depth] = arr[i];
                perm(arr, output, visited, depth + 1, n, r);
                output[depth] = 0; // 이 줄은 없어도 됨
                visited[i] = false;;
            }
        }
    }

    public static boolean isPrime(char[] number){
        int num = Integer.parseInt(String.valueOf(number));
        if(ch[num]) return false;
        ch[num] = true;
        if(num < 2) return false;
        for(long i=2; i*i<=num; i++){
            if(num % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Problem42839 m = new Problem42839();
        int solution = m.solution("011");
        System.out.println(solution);
    }
}
