public class Solution {
    public boolean isMatch(String s, String p) {
        char[] cs = s.toCharArray();
        char[] cp = p.toCharArray();
        int lens = cs.length;
        int lenp = cp.length;
        boolean[][] match = new boolean[lens + 1][lenp + 1];
        match[0][0] = true;

        char a, b;
        for (int i = 0; i <= lens; i++) {
            for (int j = 0; j <= lenp; j++) {
                if (j > 0) {
                    b = cp[j - 1];
                    match[i][j] |= match[i][j - 1] && b == '*';
                    if (i > 0) {
                        a = cs[i - 1];
                        match[i][j] |= match[i - 1][j] && b == '*';
                        match[i][j] |= match[i - 1][j - 1] && charMatch(a, b);
                    }
                }
            }
        }
        return match[lens][lenp];
    }

    private boolean charMatch(char a, char b) {
        return a == b || b == '?' || b == '*';
    }
}