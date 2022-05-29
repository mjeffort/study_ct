package leetcode;

public class problem318 {
    public int maxProduct(String[] words) {
        int res = 0;
//        Arrays.sort(words, (a, b) -> b.length()-a.length());
        int n = words.length;
        int[] masks = new int[n];
        for (int i=0; i<n; i++)
            for (char c: words[i].toCharArray())
                masks[i] |= (1 << (c - 'a'));

        for (int i = 0; i < words.length-1; i++) {
            for (int j = i+1; j < words.length; j++) {
                if(res  > words[i].length() * words[j].length())
                    continue;
                if ((masks[i] & masks[j]) == 0)
                    res = Math.max(res ,words[i].length() * words[j].length());
            }
        }
        return res;
    }

    private boolean isNotShared(String a, String b) {
        for (char c : b.toCharArray()) {
            if(a.contains(String.valueOf(c))) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        problem318 m = new problem318();
        String[] words = {"abcw","baz","foo","bar","xtfn","abcdef"};
        int maxForm = m.maxProduct(words);
        System.out.println(maxForm);
    }
}
