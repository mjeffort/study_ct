package kakao.blind22.prac01;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public int[] solution(String[] id_list, String[] report, int k) {
        int n = id_list.length;
        int[] answer = new int[n];
        int[] out = new int[n];
        int[][] ch = new int[n][n];
        ArrayList<String> idList = new ArrayList<>(List.of(id_list));
        for (String s : report) {
            String[] split = s.split(" ");
            int x = idList.indexOf(split[0]);
            int y = idList.indexOf(split[1]);
            if (ch[x][y] == 0) {
                ch[x][y] = 1;
                out[y] += 1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && ch[i][j] == 1 && out[j] >= k) {
                    answer[i] += 1;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main main = new Main();
        String[] id_list = new String[]{"muzi", "frodo", "apeach", "neo"};
        String[] report = new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        int[] solution = main.solution(id_list, report, k);
        for (int i : solution) {
            System.out.println(i + " ");

        }
    }
}
