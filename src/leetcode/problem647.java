package leetcode;

public class problem647 {
    public int countSubstrings(String s) {
        int res = 0;
        int n = s.length();
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= n - i; j++) {
                if (isPalindromic(s.substring(j, j + i))) {
                    res++;
                }
            }
        }

        return res;
    }

    public boolean isPalindromic(String s) {
        char[] arr = s.toCharArray();
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            if (arr[i] != arr[n - i - 1]) {
                return false;
            }
        }
        return true;
    }
}
