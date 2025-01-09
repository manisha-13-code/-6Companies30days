public class maxProductSolution {
    long ans = 0;
    public boolean isPal(String s) {
        int l = 0;
        int h = s.length() - 1;

        while(l < h) {
            if(s.charAt(l) != s.charAt(h)) return false;
            l++;
            h--;
        }
        return true;
    }
    public void helper(String s, int idx, StringBuilder s1, StringBuilder s2) {
        if(isPal(s1.toString()) && isPal(s2.toString())) {
            long temp = (int)(s1.length() * s2.length());
            ans = Math.max(ans, temp);
        }

        for(int i = idx; i < s.length(); i++) {
            s1.append(s.charAt(i));
            helper(s, i+1, s1, s2);
            s1.deleteCharAt(s1.length() - 1);

            s2.append(s.charAt(i));
            helper(s, i+1, s1, s2);
            s2.deleteCharAt(s2.length() - 1);
        }
    }
    public int maxProduct(String s) {

        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        helper(s, 0, s1, s2);
        return (int)ans;
    }
}
