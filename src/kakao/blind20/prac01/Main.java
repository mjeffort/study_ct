package kakao.blind20.prac01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Main {

    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        int n = s.length();
//        int[] count = new int[n+1];
        for (int i = 1; i <= n; i++) {
            String tmp = "";
            String cur = s.substring(0, i);
            int cnt = 0;
            for (int j = 0; j < n;) {
                if(j+i > n){
                    tmp += s.substring(j, n);
                    break;
                }

                String split = s.substring(j, j + i);
                if (cur.equals(split)) {
                    cnt++;
                } else {
                    if(cnt > 1) tmp += String.valueOf(cnt);
                    tmp += cur;

                    //초기화
                    cnt = 1;
                    cur = split;
                }
                j = j + i;
            }
            if(cnt > 1) tmp += String.valueOf(cnt);
            tmp += cur;
            answer = Math.min(answer, tmp.length());
        }

        return answer;
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println("Math.log10(123) = " + ((int) Math.log10(1124122512) + 1));
        String s = "aabbaccc";
        int solution = main.solution(s);
        System.out.println(solution);
    }
}
