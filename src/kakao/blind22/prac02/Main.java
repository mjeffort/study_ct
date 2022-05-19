package kakao.blind22.prac02;

public class Main {

    public int solution(int n, int k) {
        int answer = 0;
        String[] split = Integer.toString(n, k).split("0+");
        for (String s : split) {
            if (isPrime(Long.parseLong(s))) {
                answer++;
            }
        }

        return answer;
    }

    public static boolean isPrime(long num){
        if(num < 2) return false;
        for(long i=2; i*i<=num; i++){
            if(num % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Main main = new Main();
        int n = 437674;
        int k = 3;
        int solution = main.solution(n, k);
        System.out.println(solution);
    }
}
