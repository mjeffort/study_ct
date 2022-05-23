package prog.kit;

import java.util.Arrays;

/**
 * 전화번호 목록
 */
public class Problem42577 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length-1; i++) {
            String s = phone_book[i];
            String s2 = phone_book[i+1];

            if(s.length() < s2.length() && s2.startsWith(s)) return false;
            else if (s.length() >= s2.length() && s.startsWith(s2)) return false;
        }

        return answer;
    }
}
