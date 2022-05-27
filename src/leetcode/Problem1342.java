package leetcode;

public class Problem1342 {

    public int numberOfSteps(int num) {
        int res = 0;
        while (num > 0) {
            res += num % 2;
            num = num / 2;
            if (num > 0) res++;
        }
        return res;
    }

    public static void main(String[] args) {
        Problem1342 m = new Problem1342();
        int num = 123;
        int maxForm = m.numberOfSteps(num);
        System.out.println(maxForm);
    }
}
