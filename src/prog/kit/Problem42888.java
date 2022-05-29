package prog.kit;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 오픈채팅방
 */
public class Problem42888 {
    class User {
        public String id;
        public String name;

        public User(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public void change(String name) {
            this.name = name;
        }
    }

    static class History {
        public User user;
        public char state;

        public History(User user, char state) {
            this.user = user;
            this.state = state;
        }

        public static History enter(User user) {
            return new History(user, 'E');
        }

        public static History leave(User user) {
            return new History(user, 'L');
        }
    }

    public String[] solution(String[] record) {

        HashMap<String, User> users = new HashMap<>();
        ArrayList<History> histories = new ArrayList<>();
        for (String s : record) {
            String[] split = s.split(" ");
            String action = split[0];
            String id = split[1];
            String name = "";
            if (split.length == 3) {
                name = split[2];
            }

            if (action.equals("Enter")) {
                User user = users.getOrDefault(id, new User(id, name));
                if (user.name != name) user.change(name);
                users.put(id, user);
                histories.add(History.enter(users.get(id)));
            } else if (action.equals("Leave")) {
                histories.add(History.leave(users.get(id)));
            } else {
                users.get(id).change(name);
            }
        }

        String[] answer = new String[histories.size()];
        int i = 0;
        for (History h : histories) {
            if (h.state == 'E') {
                answer[i++] = h.user.name + "님이 들어왔습니다.";
            } else {
                answer[i++] = h.user.name + "님이 나갔습니다.";
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Problem42888 m = new Problem42888();
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        String[] solution = m.solution(record);
        for (String s : solution) {
            System.out.println(s);
        }
    }
}
