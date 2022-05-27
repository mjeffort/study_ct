package hackerrank.greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Luck Balance
 */
public class Practice02 {

    public static int luckBalance(int k, List<List<Integer>> contests) {
        // Write your code here
        int res = 0;
        Collections.sort(contests, (a, b) -> a.get(1) == b.get(1) ? b.get(0) - a.get(0) : a.get(1) - b.get(1));

        for (int i = 0; i < contests.size(); i++) {
            if (contests.get(i).get(1) == 0) {
                res += contests.get(i).get(0);
            } else {
                if (k > 0) {
                    k--;
                    res += contests.get(i).get(0);
                } else {
                    res -= contests.get(i).get(0);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) throws IOException {

        int n = 3;

        int k = 1;

        List<List<Integer>> contests = new ArrayList<>();

        List<Integer> input = new ArrayList<>();
        input.add(5);
        input.add(1);
        contests.add(input);

        List<Integer> input2 = new ArrayList<>();
        input2.add(2);
        input2.add(0);
        contests.add(input2);

        List<Integer> input3 = new ArrayList<>();
        input3.add(1);
        input3.add(1);
        contests.add(input3);
//
//        IntStream.range(0, n).forEach(i -> {
//            try {
//                contests.add(
//                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                                .map(Integer::parseInt)
//                                .collect(toList())
//                );
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        });

        int result = Practice02.luckBalance(k, contests);

    }
}

