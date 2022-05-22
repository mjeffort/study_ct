package kakao.blind22.prac04;

public class Main2 {

    static int max = Integer.MIN_VALUE;
    static int[] max_arr;
    static int[] ch;
    static int cnt = 0;
    public void DFS(int n, int count, int level, int[] info) {
        if (n < count) return;
        if (n == count || level == 10) {
            int df = calculate(ch);
            if (df > max) {
                max = df;
                max_arr = ch.clone();
                cnt = count;
            } else if (df == max) {
                boolean flag = false;
                for (int i = 0; i <= n; i++) {
                    if(max_arr[i] < ch[i]) flag = true;
                    else if(max_arr[i] >= ch[i]) flag = false;
                }
                if(flag){
                    max_arr = ch.clone();
                    cnt = count;
                }

            }

        } else {
            ch[level] = 1;
            DFS(n, count + info[level]+1, level+ 1, info);
            ch[level] = -1;
            DFS(n, count, level+1, info);
            ch[level] = 0;
        }
    }

    public int[] solution(int n, int[] info) {
        int[] answer = new int[11];
        int[] fail = {-1};
        ch = new int[11];
        max_arr = new int[11];
        for (int i = 0; i <= 10; i++) {
            if (info[i] > 0)
                ch[i] = -1;
        }

        DFS(n, 0, 0, info);

        int diff = calculate(max_arr);
        if (diff > 0) {
            for (int i = 0; i < info.length; i++) {
                if (max_arr[i] == 1) {
                    answer[i] = info[i] + 1;
                } else {
                    answer[i] = 0;
                }
            }
            answer[10] = n - cnt;
            return answer;
        } else {
            return fail;
        }
    }

    public int calculate(int[] ch) {
        int sumA = 0;
        int sumR = 0;
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == -1) {
                sumA += (10 - i);
            } else if (ch[i] == 1) {
                sumR += (10 - i);
            }
        }
        return sumR - sumA;
    }

    public static void main(String[] args) {
        Main2 main = new Main2();
        int n = 10;
        int[] info = {0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3};
        int[] solution = main.solution(n, info);
        for (int i : solution) {
            System.out.print(i + " ");
        }
    }
}
