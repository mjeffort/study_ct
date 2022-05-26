package hackerrank.greedy;

import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Minimum Absolute Difference in an Array
 */
public class Practice01 {

    public static int minimumAbsoluteDifference(List<Integer> arr) {
        // Write your code here
        int min = Integer.MAX_VALUE;
        int n = arr.size();
        Collections.sort(arr, Comparator.comparingInt(Math::abs));
        for (int i = 0; i < n - 1; i++) {
            min = Math.min(min, Math.abs(arr.get(i) - arr.get(i + 1)));
        }
        return min;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Practice01.minimumAbsoluteDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

