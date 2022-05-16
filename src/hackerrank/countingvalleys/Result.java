package hackerrank.countingvalleys;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */

    public static int countingValleys(int steps, String path) {
        // Write your code here
        int res = 0;
        int high = 0;
        boolean down = false;
        for (char x : path.toCharArray()) {
            if (x == 'U') {
                high++;
            } else {
                high--;
            }
            if (high < 0) {
                down = true;
            } else if (down && high == 0) {
                res++;
                down = false;
            }
        }

        return res;
    }

}
