package kakao.blind22.prac03;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public int[] solution(int[] fees, String[] records) {
        HashMap<Integer, Integer> cars = new HashMap<Integer, Integer>();
        HashMap<String, Integer> in = new HashMap<String, Integer>();

        for (String record : records) {
            String[] split = record.split(" ");
            String[] time = split[0].split(":");
            if (split[2].equals("IN")) {
                in.put(split[1], Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]));
            } else {
                Integer inTime = in.get(split[1]);
                in.remove(split[1]);
                int outTime = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
                cars.put(Integer.parseInt(split[1]), cars.getOrDefault(Integer.parseInt(split[1]), 0) + (outTime - inTime));
            }

        }

        for (String s : in.keySet()) {
            Integer inTime = in.get(s);
            cars.put(Integer.parseInt(s), cars.getOrDefault(Integer.parseInt(s), 0) + (1439 - inTime));
        }


        List<Integer> carNum = cars.keySet().stream().collect(Collectors.toList());
        Collections.sort(carNum);
        int[] answer = new int[carNum.size()];
        int i = 0;
        for (Integer num : carNum) {
            answer[i++] = calculate(fees, cars.get(num));
        }

        return answer;
    }

    public int calculate(int[] fees, int t) {
        if (t <= fees[0]) return fees[1];
        if ((t - fees[0]) % fees[2] == 0) {
            return fees[1] + (t - fees[0]) / fees[2] * fees[3];
        }
        return fees[1] + ((t - fees[0]) / fees[2] + 1) * fees[3];
    }

    public static void main(String[] args) {
        Main main = new Main();
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        int[] solution = main.solution(fees, records);
        for (int i : solution) {
            System.out.print(i + " ");
        }
    }
}
