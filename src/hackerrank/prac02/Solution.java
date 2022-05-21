package hackerrank.prac02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */

    public static void minimumBribes(List<Integer> q) {
        // Write you code here
        int res = 0;
        int n = q.size();

        boolean isChaotic = false;
        for (int i = 0; i < n; i++) {
            if ((q.get(i) - i - 1) > 2) {
                isChaotic = true;
                break;
            }

        }
        if (isChaotic) {
            System.out.println("Too chaotic");
        }

        for (int i = 1; i < n; i++) {
            int pos = q.indexOf(i);
            if(pos == (i-1)) continue;
            for (int j = pos; j > 0; j--) {
                if (q.get(j - 1) > q.get(j)) {
                    int tmp = q.get(j - 1);
                    q.set(j - 1, q.get(j));
                    q.set(j, tmp);
                    res++;
                }
            }
        }

        System.out.println(res);

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                Result.minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}