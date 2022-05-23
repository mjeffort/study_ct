package leetcode;

public class Problem474 {

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] arr = new int[m+1][n+1];

        for(String str : strs){
            int c0 = 0;
            int c1 = 0;

            for(char c : str.toCharArray()){
                if(c == '0') c0++;
                else c1++;
            }

            for(int i=m;i>=c0;i--){
                for(int j=n;j>=c1;j--){
                    arr[i][j] = Math.max(arr[i][j],arr[i-c0][j-c1] + 1);
                }
            }
        }
        return arr[m][n];
    }
//
//    static int res;
//    static int mm;
//    static int nn;
//    static boolean flag;
//
//    public int findMaxForm(String[] strs, int m, int n) {
//        int len = strs.length;
//        boolean[] visited = new boolean[len];
//        mm = m;
//        nn = n;
//        res = 0;
//        flag = false;
//
//        for (int i = len; i > 0; i--) {
//            comb(strs, visited, 0, len , i);
//        }
//        return res;
//    }
//
//    private void comb(String[] strs, boolean[] visited, int start, int len, int r) {
//        if(flag) return;
//        if (r == 0) {
//            int sum0 = 0, sum1 = 0, count = 0;
//            for (int i = 0; i < len; i++) {
//                if (visited[i]) {
//                    for (char c : strs[i].toCharArray()) {
//                        if (c == '0') sum0 += 1;
//                        else if (c == '1') sum1 += 1;
//                    }
//                    count++;
//                }
//            }
//            if ((mm >= sum0 && nn >= sum1) || (mm >= sum1 && nn >= sum0)) {
//                res = count;
//                flag = true;
//            }
//            return;
//        }
//        for (int i = start; i < len; i++) {
//            visited[i] = true;
//            comb(strs, visited, i + 1, len, r - 1);
//            visited[i] = false;
//        }
//    }

    public static void main(String[] args) {
        Problem474 m = new Problem474();
        String[] strs = {"10","0001","111001","1","0"};
        int maxForm = m.findMaxForm(strs, 3, 2);
        System.out.println(maxForm);
    }
}
