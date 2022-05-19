package kakao.blind22.prac02;

import java.util.Arrays;

public class Main2 {

    public static boolean isPrime(long num){
        if(num < 2) return false;
        for(long i=2; i*i<=num; i++){
            if(num % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 120;
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i*i; j <= n; j+=i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if(isPrime[i])
                System.out.print(i+" ");
        }
    }
}
