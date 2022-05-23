package prog.kit;

import java.util.HashMap;
import java.util.Map;

/**
 * 완주하지 못한 선수
 */
public class Problem42576 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> hash = new HashMap<>();
        for (String s : participant) {
            hash.put(s, hash.getOrDefault(s, 0) + 1);
        }

        for (String s : completion) {
            Integer cnt = hash.get(s) - 1;
            if (cnt == 0) hash.remove(s);
            else hash.put(s, cnt);
        }

        answer = (String) hash.keySet().toArray()[0];

        return answer;
    }
}
